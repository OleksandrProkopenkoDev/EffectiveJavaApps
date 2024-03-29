package com.spro.security;


import javax.crypto.SecretKey;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spro.auth.AppUserService;
import com.spro.jwt.JwtConfig;
import com.spro.jwt.JwtTokenVerifier;
import com.spro.jwt.JwtUsernameAndPasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity 
@EnableMethodSecurity
@EnableConfigurationProperties(JwtConfig.class)
public class SecurityConfig {

	
	private final PasswordEncoder passwordEncoder;
	private final AppUserService appUserService;
	private final SecretKey secretKey;
	private final JwtConfig jwtConfig;

	public SecurityConfig(
			PasswordEncoder passwordEncoder,
			AppUserService appUserService,
			SecretKey secretKey,
			JwtConfig jwtConfig) {
		this.passwordEncoder = passwordEncoder;
		this.appUserService = appUserService;
		this.secretKey = secretKey;
		this.jwtConfig = jwtConfig;
	}

	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
        	//	.csrf(csrf -> csrf
        //				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .sessionManagement()
                	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(
                			authenticationManager(http.getSharedObject(AuthenticationConfiguration.class)),
                			jwtConfig,
                			secretKey))
                .addFilterAfter(
                		new JwtTokenVerifier(secretKey,jwtConfig), 
                		JwtUsernameAndPasswordAuthenticationFilter.class)
                .authorizeHttpRequests((auth)->	auth
                		.requestMatchers("home","/","index","/css/*","/js/*").permitAll()
//                		.requestMatchers("/api/**").hasRole(STUDENT.name())
//                		.requestMatchers( HttpMethod.DELETE,"management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                		.requestMatchers( HttpMethod.POST,"management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                		.requestMatchers( HttpMethod.PUT,"management/api/**").hasAuthority(COURSE_WRITE.getPermission())
//                		.requestMatchers(HttpMethod.GET, "management/api/**").hasAnyRole(ADMIN.name(),ADMINTRAINEE.name())
                		//order of Matchers does matter!
                		.anyRequest()
                		.authenticated()); // we want to authorize requests
                  	
//                .requestMatchers() //exclude these from auth list
//                .permitAll()
//                .anyRequest()			//any request must be 
//                .authenticated()		//authenticated
//                .and()
                //.httpBasic();			//use basic authentication
//                  .formLogin()
//	                  .loginPage("/login").permitAll()
//	                  .defaultSuccessUrl("/courses", true)
//	                  .passwordParameter("password")//set a custom name of parameter in html submit form
//	                  .usernameParameter("username")
//                  .and()
//                  .rememberMe()//2 weeks
//                  		.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21)) //3weeks
//                  		.key("something_very_secure")
//                  		.rememberMeParameter("remember-me")
//                  .and()
//                  .logout()
//                  		.logoutUrl("/logout")
//                  		.logoutRequestMatcher(new AntPathRequestMatcher("/logout","GET"))
//                  		.clearAuthentication(true)
//                  		.invalidateHttpSession(true)
//                  		.deleteCookies("JSESSIONID", "remember-me")
//                  		.logoutSuccessUrl("/login");	
                
        return http.build();
    }

	@Bean
	DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider =
				new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(appUserService);
		return provider;
	}
	
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}

//@Bean
//UserDetailsService userDetailsService() {
////	how we retrieve users from database
//	UserDetails annaSmith = User.builder()
//		.username("annasmith") 
//		.password(passwordEncoder.encode("password"))
////		.roles(STUDENT.name()) //ROLE_STUDENT
//		.authorities(STUDENT.getGrantedAuthorities())
//		.build();
//	
//	UserDetails lindaUser = User.builder()
//  		.username("linda")
//  		.password(passwordEncoder.encode("password123"))
////  		.roles(ADMIN.name())//ROLE_ADMIN
//  		.authorities(ADMIN.getGrantedAuthorities())
//  		.build();
//	
//	UserDetails tomUser = User.builder()
//  		.username("tom")
//  		.password(passwordEncoder.encode("password123"))
////  		.roles(ADMINTRAINEE.name())//ROLE_ADMINTRAINEE
//  		.authorities(ADMINTRAINEE.getGrantedAuthorities())
//  		.build();
//	return new InMemoryUserDetailsManager(annaSmith,lindaUser,tomUser);
//}