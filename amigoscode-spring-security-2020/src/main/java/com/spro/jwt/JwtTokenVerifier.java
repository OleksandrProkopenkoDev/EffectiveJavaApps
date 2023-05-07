package com.spro.jwt;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.base.Strings;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenVerifier extends OncePerRequestFilter{

	private final SecretKey secretKey;
	private final JwtConfig jwtConfig;
	
	public JwtTokenVerifier(SecretKey secretKey, JwtConfig jwtConfig) {
		this.secretKey = secretKey;
		this.jwtConfig = jwtConfig;
	}



	@Override
	protected void doFilterInternal(
			HttpServletRequest request, 
			HttpServletResponse response,
			FilterChain filterChain)
			throws ServletException, IOException {

		//1 get the token from the header
		String authorizationHeader = request.getHeader(jwtConfig.getAuthorizationHeader());
		
		//chek if our authorization token is present in clients request header
		if(Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())){
			//if not present : return. Authentication failed
			filterChain.doFilter(request, response);
			return;
		}
		System.out.println(jwtConfig.getTokenPrefix()+"check bearer with space");
		//1st: delete unnesesary 'Bearer ' in the start of string
		String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");//delete 'Bearer ' in the begining of the line

		try {
			//token is present.
			
			//2nd get claims from header
			Jws<Claims> claimsJws = Jwts.parser()
				.setSigningKey(secretKey)
				.parseClaimsJws(token);
		
			Claims body = claimsJws.getBody();
			//get username from claims
			String username = body.getSubject();
			//get list of user`s authorities in 'String' data type
			var authorities =(List<Map<String,String>>) body.get("authorities");
			//create a set of 'SimpleGrantedAuthorities' from that list of strings
			Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream()
					.map(m->new SimpleGrantedAuthority(m.get("authority")))
					.collect(Collectors.toSet());

			//create an authentication object with username, credentials=null and simpleGrantedAuthorities
			//this object means that user passed authentication successfully
			Authentication authentication = new UsernamePasswordAuthenticationToken(
					username,null,simpleGrantedAuthorities);
			//inform SpringSecurity system that username passed the authentication
			SecurityContextHolder.getContext().setAuthentication(authentication);
		
		
		}catch (JwtException e) {
			throw new IllegalStateException(String.format("Token %s cannot be trusted",token));
		}
		filterChain.doFilter(request, response);//pass request and response to next filter in filter chain
		
	}

}
