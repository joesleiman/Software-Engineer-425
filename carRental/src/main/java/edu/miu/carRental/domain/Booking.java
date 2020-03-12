package edu.miu.carRental.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@NotNull(message = "*Please provide reference number")
	private String referenceNumber;
	
	@Column(name = "booking_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "*Please provide booking date")
	private LocalDate bookingDate;

	@Column(name = "start_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "*Please provide booking start date")
    private LocalDate startDate;

	@Column(name = "end_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "*Please provide booking end date")
    private LocalDate endDate;
	
	@Column(name = "total_price")
	@NotNull(message = "*Please provide total price")
	private Double totalPrice;
	
	@Column(name = "booking_status")
	@NotNull(message = "*Please provide booking status")
	private String bookingStatus;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@Column(name = "car_id", nullable = false)
	private Car car;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@Column(name="payment_id", nullable = false, unique = true)
	private Payment payment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@Column(name="customer_id", nullable = false)
	private Customer customer;

    public Booking() {
    	
    }
	
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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

}