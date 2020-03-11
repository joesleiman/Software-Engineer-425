package edu.miu.carRental.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import edu.miu.carRental.domain.User;

@SuppressWarnings("serial")
public class UserPrincipal implements UserDetails {
	private User user;
	
	public UserPrincipal(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//boolean isEmployee = false,isAdmin = false,isCustomer = false;
		
		Collection<GrantedAuthority> systemUser=new ArrayList<>();
		systemUser.add(new SimpleGrantedAuthority("Employee"));
		systemUser.add(new SimpleGrantedAuthority("Admin"));
		systemUser.add(new SimpleGrantedAuthority("Customer"));
		return systemUser;
		
//		
//		 for (GrantedAuthority grantedAuthority : systemUser) {
//	            if (grantedAuthority.getAuthority().equals("Employee")) {
//	            	isEmployee = true;
//	                break;
//	            } else if (grantedAuthority.getAuthority().equals("Admin")) {
//	                isAdmin = true;
//	                break;
//	            }else if (grantedAuthority.getAuthority().equals("Customer")) {
//	                isCustomer = true;
//	                break;
//	            }
//	        }
//	 
//	        if (isCustomer) {
//	            return "/customer.html";
//	        } else if (isAdmin) {
//	            return "/admin.html";
//	        } else if (isEmployee) {
//	            return "/employee.html";
//	        }else {
//	            throw new IllegalStateException();
//	        }
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
