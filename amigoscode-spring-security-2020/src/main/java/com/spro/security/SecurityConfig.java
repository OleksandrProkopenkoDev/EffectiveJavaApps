package com.spro.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                
                .authorizeHttpRequests((auth)->	auth
                		.requestMatchers("/home","/","index","/css/*","/js/*")
                		.permitAll()
                		.anyRequest()
                		.authenticated()) // we want to authorize requests
                
//                .requestMatchers() //exclude these from auth list
//                .permitAll()
//                .anyRequest()			//any request must be 
//                .authenticated()		//authenticated
//                .and()
                .httpBasic();			//use basic authentication

                
        return http.build();
    }
	
}
