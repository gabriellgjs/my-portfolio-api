package com.myportfolio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

  @Autowired
  SecurityFilter securityFilter;
  @Bean
  public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
    return httpSecurity
    .csrf(csrf -> csrf.disable())
    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    .authorizeHttpRequests(authorize -> authorize
    .requestMatchers(HttpMethod.GET,"/ping").permitAll()
    .requestMatchers(HttpMethod.GET,"/ping/pong").hasRole("ADMIN")

    .requestMatchers(HttpMethod.GET, "/resume/**").permitAll()

    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
    .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()

    .requestMatchers(HttpMethod.GET, "/developers").hasRole("ADMIN")
    .requestMatchers(HttpMethod.POST, "/developers").hasRole("ADMIN")

    .requestMatchers(HttpMethod.GET, "/educations").hasRole("ADMIN")
    .requestMatchers(HttpMethod.POST, "/educations").hasRole("ADMIN")
    .requestMatchers(HttpMethod.GET, "/educations/**").hasRole("ADMIN")

    .requestMatchers(HttpMethod.POST, "/experiences").hasRole("ADMIN")
    .requestMatchers(HttpMethod.GET, "/experiences").hasRole("ADMIN")


    .requestMatchers(HttpMethod.GET, "/skills/**").hasRole("ADMIN")
    .requestMatchers(HttpMethod.GET, "/skills").hasRole("ADMIN")
    .requestMatchers(HttpMethod.POST, "/skills").hasRole("ADMIN")
    .requestMatchers(HttpMethod.PATCH, "/skills/**").hasRole("ADMIN")
    .requestMatchers(HttpMethod.PUT, "/skills/**").hasRole("ADMIN")
    .requestMatchers(HttpMethod.DELETE, "/skills/**").hasRole("ADMIN")


    .requestMatchers(HttpMethod.POST, "/projects").hasRole("ADMIN")
    .requestMatchers(HttpMethod.GET, "/projects").hasRole("ADMIN")
    .anyRequest().authenticated()
    )
    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
    .build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return  authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return  new BCryptPasswordEncoder();
  }
}
