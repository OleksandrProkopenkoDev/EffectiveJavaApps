package com.spro.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spro.appuser.AppUserService;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig  {
	
	private final AppUserService appUserService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v*/registration/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
                
        return http.build();
    }
    
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =
                new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bCryptPasswordEncoder);
        daoAuthenticationProvider.setUserDetailsService(appUserService);
        return daoAuthenticationProvider;
    }


}


//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//            .csrf().disable()
//            .cors(Customizer.withDefaults())
//            .authorizeHttpRequests()
//            .requestMatchers(
//                    HttpMethod.POST,
//                    "/api/v1/customers",
//                    "/api/v1/auth/login"
//            )
//            .permitAll()
//            .requestMatchers(
//                    HttpMethod.GET,
//                    "/ping"
//            )
//            .permitAll()
//            .requestMatchers(
//                    HttpMethod.GET,
//                    "/api/v1/customers/**"
//            )
//            .permitAll()
//            .requestMatchers(HttpMethod.GET, "/actuator/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authenticationProvider(authenticationProvider)
//            .addFilterBefore(
//                    jwtAuthenticationFilter,
//                    UsernamePasswordAuthenticationFilter.class
//            )
//            .exceptionHandling()
//            .authenticationEntryPoint(authenticationEntryPoint);
//    return http.build();
//}




