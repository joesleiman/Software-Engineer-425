package edu.miu.carRental.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "admins")
public class Admin extends User {
	
	@Column(name = "user_name")
	@NotNull(message = "*Please provide user name") 
    private String userName;
	
	@Column(name = "password")
	@NotNull(message = "*Please provide password") 
    private String password;
	
	@Column(name = "role")
	@NotNull(message = "*Please provide role") 
	private String role;
	
	public Admin() {
		
	}
	public Admin(@NotNull(message = "*Please provide user name") String userName,
			@NotNull(message = "*Please provide password") String password,
			@NotNull(message = "*Please provide role") String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
