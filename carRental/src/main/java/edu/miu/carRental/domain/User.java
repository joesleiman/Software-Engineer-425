package edu.miu.carRental.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name = "first_name",nullable=false)
	@NotNull(message = "*Please provide first name")
	private String firstName;
	
	@Column(name = "last_name", nullable=false)
	@NotNull(message = "*Please provide last name")
	private String lastName;
	
	@Column(name = "date_of_birth", nullable=false)
	@NotNull(message = "*Please provide date of birth")
	@DateTimeFormat(pattern = "YYYY/MM/dd")
	private LocalDate dateOfBirth;
	
	@Column(name = "phone_number", nullable=false)
	@NotNull(message = "*Please provide phone number")
	@Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "* please provide valid phone number")
	private String phoneNumber;
	
	@Column(name = "email", nullable = false, unique = true)
	@NotNull(message = "*Please provide user name") 
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,3})$",message = "* please provide a valid email")
	private String email;
	
	@Column(name = "password", nullable=false)
	@NotNull(message = "*Please provide password") 
    private String password;
	
	
	@NotNull(message = "*Please provide role") 
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(@NotNull(message = "*Please provide first name") String firstName,
			@NotNull(message = "*Please provide last name") String lastName,
			@NotNull(message = "*Please provide date of birth") LocalDate dateOfBirth,
			@NotNull(message = "*Please provide phone number") @Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "* please provide valid phone number") String phoneNumber,
			@NotNull(message = "*Please provide user name") @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,3})$", message = "* please provide a valid email") String email,
			@NotNull(message = "*Please provide password") String password,
			@NotNull(message = "*Please provide role") List<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
		
}
