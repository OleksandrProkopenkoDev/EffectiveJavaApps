package com.spro.security;

import static com.spro.security.AppUserPermission.COURSE_READ;
import static com.spro.security.AppUserPermission.COURSE_WRITE;
import static com.spro.security.AppUserPermission.STUDENT_READ;
import static com.spro.security.AppUserPermission.STUDENT_WRITE;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum AppUserRole {
	STUDENT(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE)),
	ADMINTRAINEE(Sets.newHashSet(COURSE_READ, STUDENT_READ));
	
	private final Set<AppUserPermission> permissions;

	private AppUserRole(Set<AppUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<AppUserPermission> getPermissions() {
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		//this method just produces the set of objects 'SimpleGrantedAuthorities'
		//according to Spring documentation rules
		//and using our declared roles
		//it is similar to relative original Spring method logic
		//SimpleGrantedAuthority is a String containing two parts:
		// 'ROLE_' + 'name of role' (declared by us in our program)
		
		//in real uper text is wrong
		//Set<SimpleGrantedAuthority> contains strings with roles and permissions
		//
		Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
				.map(permission-> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		System.out.println("getGranted authorities method: permissions: "+permissions);
		return permissions;
	}
}
