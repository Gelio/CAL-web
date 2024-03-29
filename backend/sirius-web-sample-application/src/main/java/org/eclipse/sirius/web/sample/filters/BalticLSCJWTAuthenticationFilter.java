package org.eclipse.sirius.web.sample.filters;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.sirius.web.sample.configuration.SpringWebSecurityConfiguration;
import org.eclipse.sirius.web.spring.exceptions.CALRestException;
import org.eclipse.sirius.web.spring.exceptions.CALRestExceptionWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class BalticLSCJWTAuthenticationFilter extends GenericFilterBean {
    // NOTE: adapted from https://stackoverflow.com/a/41975719/4874344

    private static final String AUTHORIZATION_HEADER_NAME = "Authorization"; //$NON-NLS-1$

    private static final Logger LOGGER = LoggerFactory.getLogger(BalticLSCJWTAuthenticationFilter.class);

    private final CALRestExceptionWriter exceptionWriter;

    public BalticLSCJWTAuthenticationFilter(CALRestExceptionWriter exceptionWriter) {
        this.exceptionWriter = exceptionWriter;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            var httpServletRequest = (HttpServletRequest) servletRequest;
            var jwt = this.resolveToken(httpServletRequest);
            if (jwt.isPresent()) {
                var authentication = this.getAuthentication(jwt.get());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else if (httpServletRequest.getRequestURI().equals("/subscriptions")) { //$NON-NLS-1$
                // NOTE: a workaround to add WebSocket authentication information
                // See https://github.com/eclipse-sirius/sirius-components/issues/846
                // for a description of the problem.
                // TODO: remove the workaround after it is clear how to correctly
                // authenticate WebSocket connections
                var principal = new User("websocket-auth-workaround", SpringWebSecurityConfiguration.DEFAULT_PASSWORD, List.of()); //$NON-NLS-1$
                var authentication = new UsernamePasswordAuthenticationToken(principal, SpringWebSecurityConfiguration.DEFAULT_PASSWORD);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

            filterChain.doFilter(servletRequest, servletResponse);

            this.resetAuthenticationAfterRequest();
        } catch (ExpiredJwtException exception) {
            LOGGER.info("Security exception for user {} - {}", exception.getClaims().getSubject(), exception.getMessage()); //$NON-NLS-1$
            LOGGER.debug("Exception " + exception.getMessage(), exception); //$NON-NLS-1$
            var response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            this.exceptionWriter.writeException(new CALRestException("JWT token expired", exception), response); //$NON-NLS-1$
        } catch (MalformedJwtException exception) {
            LOGGER.info("Security exception - {}", exception.getMessage()); //$NON-NLS-1$
            LOGGER.debug("Exception " + exception.getMessage(), exception); //$NON-NLS-1$
            var response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            this.exceptionWriter.writeException(new CALRestException("Malformed JWT, exception", exception), response); //$NON-NLS-1$
        } catch (JwtException exception) {
            LOGGER.info("Security exception - {}", exception.getMessage()); //$NON-NLS-1$
            LOGGER.debug("Exception " + exception.getMessage(), exception); //$NON-NLS-1$
            var response = (HttpServletResponse) servletResponse;
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            this.exceptionWriter.writeException(new CALRestException("Unknown JWT error: " + exception.getMessage(), exception), response); //$NON-NLS-1$
        }
    }

    private void resetAuthenticationAfterRequest() {
        SecurityContextHolder.getContext().setAuthentication(null);
    }

    private Optional<String> resolveToken(HttpServletRequest request) {
        var bearerToken = request.getHeader(BalticLSCJWTAuthenticationFilter.AUTHORIZATION_HEADER_NAME);
        var bearerPrefix = "Bearer "; //$NON-NLS-1$
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(bearerPrefix)) {
            var jwt = bearerToken.substring(bearerPrefix.length(), bearerToken.length());

            if (StringUtils.hasText(jwt)) {
                return Optional.of(jwt);
            }
        }
        return Optional.empty();
    }

    private Authentication getAuthentication(String jwt) throws JwtException {
        var jwtParser = Jwts.parserBuilder().build();

        String unsignedToken;

        try {
            // NOTE: strip the signature from the token to b
            // https://github.com/jwtk/jjwt/issues/280#issuecomment-380336760
            var splitToken = jwt.split("\\."); //$NON-NLS-1$
            unsignedToken = splitToken[0] + "." + splitToken[1] + "."; //$NON-NLS-1$ //$NON-NLS-2$
        } catch (Exception exception) {
            throw new MalformedJwtException("Could not split JWT into parts to remove the signature", exception); //$NON-NLS-1$
        }

        // TODO: (tentative) do not use the parser because it requires token to be not expired
        // We may want to make the UX a bit nicer for the thesis and allow stale tokens.

        // NOTE: do not verify token signature because the BalticLSC signing key is not known
        // https://github.com/jwtk/jjwt/issues/280#issuecomment-832733783
        var claims = jwtParser.parseClaimsJwt(unsignedToken).getBody();
        // NOTE: capabilities are not extracted from the JWT. They are not needed at the moment.
        var principal = new User(claims.getSubject(), SpringWebSecurityConfiguration.DEFAULT_PASSWORD, List.of());

        return new UsernamePasswordAuthenticationToken(principal, SpringWebSecurityConfiguration.DEFAULT_PASSWORD);
    }
}
