package org.eclipse.sirius.web.spring.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.sirius.web.spring.configuration.BalticLSCProxyConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(URLConstants.BALTICLSC_PROXY_BASE_PATH)
public class BalticLSCProxyController {
    private final BalticLSCProxyConfiguration proxyConfiguration;

    public BalticLSCProxyController(BalticLSCProxyConfiguration proxyConfiguration) {
        this.proxyConfiguration = proxyConfiguration;
    }

    /**
     * <p>
     * Proxy requests to the BalticLSC server.
     * </p>
     *
     * Credits to {@link https://stackoverflow.com/a/49429650/4874344}
     */
    @RequestMapping("/**")
    public ResponseEntity<?> mirrorRest(@RequestBody(required = false) String body, HttpMethod method, HttpServletRequest request, HttpServletResponse response) throws URISyntaxException {
        var requestUrl = request.getRequestURI();
        var pathWithoutProxyPrefix = requestUrl.substring(URLConstants.BALTICLSC_PROXY_BASE_PATH.length());

        var uri = new URI(proxyConfiguration.getScheme(), null, proxyConfiguration.getHostname(), proxyConfiguration.getPort(), null, null, null);
        uri = UriComponentsBuilder.fromUri(uri).path(pathWithoutProxyPrefix).query(request.getQueryString()).build(true).toUri();

        var headers = new HttpHeaders();
        var headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        var httpEntity = new HttpEntity<>(body, headers);
        var restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, method, httpEntity, String.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
        }
    }
}
