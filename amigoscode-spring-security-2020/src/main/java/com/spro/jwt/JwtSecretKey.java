package com.spro.jwt;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtSecretKey {

	private final JwtConfig jwtConfig;
	
	public JwtSecretKey(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}



	@Bean
	SecretKey secretKey() {
		return Keys.hmacShaKeyFor(jwtConfig.getSecretKey().getBytes());
	}
}
