package com.spro.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import static com.spro.security.AppUserRole.*;

import java.util.concurrent.TimeUnit;

import static com.spro.security.AppUserPermission.*;

@Configuration
@EnableWebSecurity 
@EnableMethodSecurity
public class SecurityConfig {

	
	private final PasswordEncoder passwordEncoder;
	
	
    public SecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
        	//	.csrf(csrf -> csrf
        //				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .authorizeHttpRequests((auth)->	auth
                		.requestMatchers("home","/","index","/css/*","/js/*").permitAll()
//                		.requestMatchers("/api/**").hasRole(STUDENT.name())
//                		.requestMatchers( HttpMethod.DELETE,"management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                		.requestMatchers( HttpMethod.POST,"management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                		.requestMatchers( HttpMethod.PUT,"management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                		.requestMatchers(HttpMethod.GET, "management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                		//order of Matchers does matter!
                		.anyRequest()
                		.authenticated()) // we want to authorize requests
                
//                .requestMatchers() //exclude these from auth list
//                .permitAll()
//                .anyRequest()			//any request must be 
//                .authenticated()		//authenticated
//                .and()
                //.httpBasic();			//use basic authentication
                  .formLogin()
	                  .loginPage("/login").permitAll()
	                  .defaultSuccessUrl("/courses", true)
	                  .passwordParameter("password")//set a custom name of parameter in html submit form
	                  .usernameParameter("username")
                  .and()
                  .rememberMe()//2 weeks
                  		.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)) //3weeks
                  		.key("something_very_secure")
                  		.rememberMeParameter("remember-me")
                  .and()
                  .logout()
                  		.logoutUrl("/logout")
                  		.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
                  		.clearAuthentication(true)
                  		.invalidateHttpSession(true)
                  		.deleteCookies("JSESSIONID", "remember-me")
                  		.logoutSuccessUrl("/login");	
                
        return http.build();
    }
	
    @Bean
    UserDetailsService userDetailsService() {
//    	how we retrieve users from database
    	UserDetails annaSmith = User.builder()
    		.username("annasmith") 
    		.password(passwordEncoder.encode("password"))
//    		.roles(STUDENT.name()) //ROLE_STUDENT
    		.authorities(STUDENT.getGrantedAuthorities())
    		.build();
    	
    	UserDetails lindaUser = User.builder()
        		.username("linda")
        		.password(passwordEncoder.encode("password123"))
//        		.roles(ADMIN.name())//ROLE_ADMIN
        		.authorities(ADMIN.getGrantedAuthorities())
        		.build();
    	
    	UserDetails tomUser = User.builder()
        		.username("tom")
        		.password(passwordEncoder.encode("password123"))
//        		.roles(ADMINTRAINEE.name())//ROLE_ADMINTRAINEE
        		.authorities(ADMINTRAINEE.getGrantedAuthorities())
        		.build();
    	return new InMemoryUserDetailsManager(annaSmith,lindaUser,tomUser);
    }
}
