/*******************************************************************************
 * Copyright (c) 2019, 2020 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.sirius.web.sample.configuration;

import java.util.Arrays;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.eclipse.sirius.web.spring.configuration.SiriusWebPathResourceResolver;
import org.eclipse.sirius.web.spring.configuration.SpringWebMvcConfigurerConstants;
import org.eclipse.sirius.web.spring.controllers.URLConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Used to configure the server side routing.
 *
 * @author sbegaudeau
 */
@Configuration
public class SpringWebMvcConfigurer implements WebMvcConfigurer {
    private static final String[] ALLOWED_ORIGIN_PATTERNS = { "http://localhost:1234", "http://localhost:3000" }; //$NON-NLS-1$ //$NON-NLS-2$

    /**
     * The Spring environment.
     */
    private Environment environment;

    public SpringWebMvcConfigurer(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public Gson gson() {
        var builder = new GsonBuilder();

        if (!this.inDevMode()) {
            var strategy = new ExclusionStrategy() {
                @Override
                public boolean shouldSkipClass(Class<?> clazz) {
                    return false;
                }

                @Override
                public boolean shouldSkipField(FieldAttributes field) {
                    return field.getName().equals("stackTrace"); //$NON-NLS-1$
                }
            };
            builder.addSerializationExclusionStrategy(strategy);
        }

        return builder.create();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // @formatter:off

        // Make sure that all static assets are redirected properly to the proper path
        registry.addResourceHandler(
            SpringWebMvcConfigurerConstants.CSS_PATTERN,
            SpringWebMvcConfigurerConstants.HTML_PATTERN,
            SpringWebMvcConfigurerConstants.JS_PATTERN,
            SpringWebMvcConfigurerConstants.JS_CHUNK_PATTERN,
            SpringWebMvcConfigurerConstants.JS_MAP_PATTERN,
            SpringWebMvcConfigurerConstants.JSON_PATTERN,
            SpringWebMvcConfigurerConstants.ICO_PATTERN,
            SpringWebMvcConfigurerConstants.TTF_PATTERN,
            SpringWebMvcConfigurerConstants.MEDIA_PATTERN
        ).addResourceLocations(SpringWebMvcConfigurerConstants.STATIC_ASSETS_PATH);

        // Make sure that all other requests are redirected to index.html, the React router will handle it
        registry.addResourceHandler(
            SpringWebMvcConfigurerConstants.EMPTY_PATTERN,
            SpringWebMvcConfigurerConstants.HOMEPAGE_PATTERN,
            SpringWebMvcConfigurerConstants.ANY_PATTERN
        ).addResourceLocations(SpringWebMvcConfigurerConstants.INDEX_HTML_PATH)
        .resourceChain(true)
        .addResolver(new SiriusWebPathResourceResolver(URLConstants.API_BASE_PATH));

        // @formatter:on
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/graphiql", "/graphiql/index.html"); //$NON-NLS-1$ //$NON-NLS-2$
        registry.addRedirectViewController("/voyager", "/voyager/index.html"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (this.inDevMode()) {
            registry.addMapping(URLConstants.API_BASE_PATH + SpringWebMvcConfigurerConstants.ANY_PATTERN).allowedOriginPatterns(ALLOWED_ORIGIN_PATTERNS).allowCredentials(true);
        }
    }

    private boolean inDevMode() {
        return Arrays.asList(this.environment.getActiveProfiles()).contains("dev"); //$NON-NLS-1$
    }
}
