package edu.miu.carRental.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bookings")
public class Booking {
	
	@Id
	@Column(name = "booking_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	@Column(name = "reference_number")
	@NotNull
	private String referenceNumber;
	
	@Column(name = "booking_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "*Please provide booking date")
	private LocalDate bookingDate;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "*Please provide booking start date and time")
    private LocalDate startDate;

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "*Please provide booking end date and time")
    private LocalDate endDate;
	
	@Column(name = "total_price")
	private Double totalPrice;
	
	@ManyToOne
	@JoinColumn(name = "car_id", nullable = false)
	private Car car;
	
	@OneToOne
	@JoinColumn(name="payment_id", nullable = true, unique = true)
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", nullable = false)
	private User user;

    public Booking() {}

	public Booking(@NotNull String referenceNumber,
			@NotNull(message = "*Please provide booking date") LocalDate bookingDate,
			@NotNull(message = "*Please provide booking start date and time") LocalDate startDate,
			@NotNull(message = "*Please provide booking end date and time") LocalDate endDate, 
			Double totalPrice,
			Car car, Payment payment, User user) {
		this.referenceNumber = referenceNumber;
		this.bookingDate = bookingDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.car = car;
		this.payment = payment;
		this.user = user;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}