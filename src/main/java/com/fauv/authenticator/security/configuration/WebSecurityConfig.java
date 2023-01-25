package com.fauv.authenticator.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fauv.authenticator.controller.Controller;
import com.fauv.authenticator.security.filter.AuthenticationFilterOnRequest;
import com.fauv.authenticator.service.AuthenticationService;
import com.fauv.authenticator.service.TokenService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private TokenService tokenService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests((auth) -> {
				auth.antMatchers(HttpMethod.POST, Controller.getApisPostOpened()).permitAll();
				auth.antMatchers(HttpMethod.DELETE, Controller.getApisDeleteOpened()).permitAll();
				auth.antMatchers(HttpMethod.PUT, Controller.getApisPutOpened()).permitAll();
				auth.antMatchers(HttpMethod.GET, Controller.geApisGetOpened()).permitAll();
				auth.anyRequest().authenticated();
			})
			.headers(headers -> headers.xssProtection())
			.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(new AuthenticationFilterOnRequest(authenticationService, tokenService), UsernamePasswordAuthenticationFilter.class)
			.build();
			
	}
	
}
