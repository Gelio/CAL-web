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

import java.util.List;
import java.util.Objects;

import org.eclipse.sirius.web.persistence.entities.AccountEntity;
import org.eclipse.sirius.web.persistence.repositories.IAccountRepository;
import org.eclipse.sirius.web.sample.filters.BalticLSCJWTAuthenticationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Security configuration of Sirius Web.
 *
 * @author sbegaudeau
 */
@Configuration
@EnableWebSecurity
public class SpringWebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * <p>
     * Raw password used for every user.
     * </p>
     * <p>
     * User account password does not matter, because BalticLSC's JWTs are used for authentication.
     * </p>
     */
    // NOTE: password cannot be empty.
    // Otherwise, BCryptPasswordEncoder complain about empty passwords
    public static final String DEFAULT_PASSWORD = "default password, not used for authentication"; //$NON-NLS-1$

    private final IAccountRepository accountRepository;

    public SpringWebSecurityConfiguration(IAccountRepository accountRepository) {
        this.accountRepository = Objects.requireNonNull(accountRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/api/graphql").authenticated(); //$NON-NLS-1$
        http.authorizeRequests().antMatchers("/**").permitAll(); //$NON-NLS-1$

        var jwtFilter = new BalticLSCJWTAuthenticationFilter();
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var passwordEncoder = new BCryptPasswordEncoder();
        var encodedDefaultPassword = passwordEncoder.encode(SpringWebSecurityConfiguration.DEFAULT_PASSWORD);

        UserDetailsService accountBasedUserDetailsService = username -> {
            var account = this.accountRepository.findByUsername(username).orElseGet(() -> {
                var accountEntity = new AccountEntity();
                accountEntity.setUsername(username);
                accountEntity.setPassword(encodedDefaultPassword);
                // NOTE: roles are not used at the moment, but the database requires a valid string
                accountEntity.setRole("USER"); //$NON-NLS-1$
                this.accountRepository.save(accountEntity);

                return accountEntity;
            });

            return new User(account.getUsername(), account.getPassword(), List.of());
        };
        auth.userDetailsService(accountBasedUserDetailsService).passwordEncoder(passwordEncoder);
    }
}
