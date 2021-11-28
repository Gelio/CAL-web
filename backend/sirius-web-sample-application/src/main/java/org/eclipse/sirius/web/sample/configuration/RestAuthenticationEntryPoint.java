package org.eclipse.sirius.web.sample.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.sirius.web.spring.exceptions.CALRestException;
import org.eclipse.sirius.web.spring.exceptions.CALRestExceptionWriter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private final CALRestExceptionWriter exceptionWriter;

    public RestAuthenticationEntryPoint(CALRestExceptionWriter exceptionWriter) {
        this.exceptionWriter = exceptionWriter;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        this.exceptionWriter.writeException(new CALRestException("Authentication error", authException), response); //$NON-NLS-1$
    }
}
