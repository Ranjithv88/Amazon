package com.SpringBoot.Amazon.Security;

import com.SpringBoot.Amazon.Exception.AuthEntryPoint;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import java.util.Arrays;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfiguration {

    private AuthenticationFilter securityFilterChain;
    private AuthEntryPoint authenticationEntryPoint;
    private AuthenticationProvider authenticationProvider;

    private final String[] guest = {"/guest/**","/test"};
    private final String[] user = {"/user/**"};
    private final String[] seller = {"/user/**"};
    private final String[] admin = {"/admin/**"};
    private String[][] developer = {user,guest,seller,admin};


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(exception->exception.authenticationEntryPoint(authenticationEntryPoint))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authentication->
                        authentication.requestMatchers(guest).permitAll()
                                .requestMatchers(user).hasAuthority("USER")
                                .requestMatchers(seller).hasAuthority("SELLER")
                                .requestMatchers(admin).hasAuthority("ADMIN")
                                .requestMatchers( Arrays.stream(developer).flatMap(Arrays::stream).toArray(String[]::new)).hasAuthority("DEVELOPER")
                );
        httpSecurity.authenticationProvider(authenticationProvider);
        httpSecurity.addFilterBefore(securityFilterChain, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

}

