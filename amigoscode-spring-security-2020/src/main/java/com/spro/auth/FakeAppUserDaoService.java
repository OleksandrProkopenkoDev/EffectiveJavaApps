package com.spro.auth;

import static com.spro.security.AppUserRole.ADMIN;
import static com.spro.security.AppUserRole.ADMINTRAINEE;
import static com.spro.security.AppUserRole.STUDENT;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;

@Repository("fake")
public class FakeAppUserDaoService implements AppUserDao{

	private final PasswordEncoder passwordEncoder;
	
	public FakeAppUserDaoService(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Optional<AppUser> selectAppUserByUsername(String username) {
		return getAppUsers()
				.stream()
				.filter(appUser -> username.equals(appUser.getUsername()))
				.findFirst();
	}

	private List<AppUser> getAppUsers(){
		List<AppUser> appUsers = Lists.newArrayList(
				new AppUser(
						"annasmith",
						passwordEncoder.encode("password"),
						STUDENT.getGrantedAuthorities(),
						true,
						true,
						true,
						true),
				new AppUser(
						"linda",
						passwordEncoder.encode("password"),
						ADMIN.getGrantedAuthorities(),
						true,
						true,
						true,
						true),
				new AppUser(
						"tom",
						passwordEncoder.encode("password"),
						ADMINTRAINEE.getGrantedAuthorities(),
						true,
						true,
						true,
						true)
				);
		return appUsers;
	}
	
}
