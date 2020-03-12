package edu.miu.carRental.config.util;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum AppUserRole {
	ADMIN(Sets.newHashSet()),
	EMPLOYEE(Sets.newHashSet());
	
	private final Set<ApplicationUserPermissions> permissions;

	AppUserRole(Set<ApplicationUserPermissions> permissions) {
		this.permissions=permissions;
	}

	public Set<ApplicationUserPermissions> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> authorities=
		getPermissions()
			.stream()
			.map(permission->new SimpleGrantedAuthority(permission.getPermission()))
			.collect(Collectors.toSet());
		authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return authorities;
		
	}

}
