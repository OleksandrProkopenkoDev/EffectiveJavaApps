package com.spro.appuser;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spro.registration.token.ConfirmationToken;
import com.spro.registration.token.ConfirmationTokenRepository;
import com.spro.registration.token.ConfirmationTokenService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

	private final static String USER_NOT_FOUND_MSG = 
			"user with email %s not found";
	private final AppUserRepository appUserRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ConfirmationTokenService confirmationTokenService;
	
	@Override
	public UserDetails loadUserByUsername(String email)
				throws UsernameNotFoundException {
		
		return appUserRepository
			   .findByEmail(email)
			   .orElseThrow(()->
			   new UsernameNotFoundException(USER_NOT_FOUND_MSG.formatted(email)));
	}
	
	public String singUpUser(AppUser appUser) {
		boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
		if(userExists) {
//			TODO resend email with confirmation link
			throw new IllegalStateException("email already taken");
		}
		String encodedPassword = 
				bCryptPasswordEncoder.encode(appUser.getPassword()); 
		appUser.setPassword(encodedPassword);
		appUserRepository.save(appUser);
		// send confirmation token
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				appUser
				);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		
		
		
		return token;
	}

	public int enableAppUser(String email) {
		return	appUserRepository.setEnabledAppUser(email);
	}

}
