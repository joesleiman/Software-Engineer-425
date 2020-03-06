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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	
	@Column(name = "first_name")
	@NotNull(message = "*Please provide first name")
	private String firstName;
	
	@Column(name = "last_name")
	@NotNull(message = "*Please provide last name")
	private String lastName;
	
	@Column(name = "date_of_birth")
	@NotNull(message = "*Please provide date of birth")
	private LocalDate dateOfBirth;
	
	@Column(name = "email")
	@NotNull(message = "*Please provide email")
	private String email;
	
	@Column(name = "phone_number")
	@NotNull(message = "*Please provide phone number")
	private String phoneNumber;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address", nullable = false, unique = false)
	private Address address;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private List<Booking> booking;
	public User() {
		
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Booking> getBooking() {
		return booking;
	}
	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}
	

}
