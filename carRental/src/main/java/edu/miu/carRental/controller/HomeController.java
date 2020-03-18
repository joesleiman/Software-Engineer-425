package edu.miu.carRental.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Address;
import edu.miu.carRental.domain.Booking;
import edu.miu.carRental.domain.Car;
import edu.miu.carRental.domain.Payment;
import edu.miu.carRental.serviceImp.AddressServiceImp;
import edu.miu.carRental.serviceImp.BookingServiceImp;
import edu.miu.carRental.serviceImp.CarServiceImp;
import edu.miu.carRental.serviceImp.PaymentServiceImp;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class HomeController {
	
	@Autowired
    private CarServiceImp carService;
	
	@Autowired
	private BookingServiceImp bookingService;
	
	@Autowired
	private PaymentServiceImp paymentService;
	
	@Autowired
	private AddressServiceImp addressService;
	
	//@PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.findAll();
    }
    
    //@PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/cars/{id}")
    public Car getCar(@PathVariable Long id){
        Car car= carService.findById(id);
        return car;
    }
    
    //@PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/search_cars/{id}")
    public Car searchCars(@PathVariable Long id){
        Car car= carService.findById(id);
        return car;
    }
    
    //@PreAuthorize("hasAnyRole('USER')")
    /*@PostMapping("/booking")
  	public Booking addBooking(@RequestBody Booking booking) {
  		Payment payment = booking.getPayment();
  		Address address = payment.getBillingAddress();
  		address = addressService.save(address);
  		payment.setBillingAddress(address);
  		payment = paymentService.save(payment);
  		booking.setPayment(payment);  		
  		return bookingService.save(booking);
  	}*/
  	@PostMapping("/booking")
  	public Booking addBooking(@RequestBody Booking booking) {
  		return bookingService.save(booking);
  	}
    
    //@PreAuthorize("hasAnyRole('USER')")
  	@GetMapping("/search_booking/{referenceNumber}")
  	public List<Booking> searchBooking(@PathVariable String referenceNumber){
  		return bookingService.searchBookings(referenceNumber);
  	}	
    
    //@PreAuthorize("hasAnyRole('USER')")
  	@PutMapping("/cancel_booking/{referenceNumber}")
  	public Booking cancelBooking(@PathVariable String referenceNumber) {
  		return bookingService.customerCancelBooking(referenceNumber, "Canceled");
  	}
  	
    //@PreAuthorize("hasAnyRole('USER')")
  	@GetMapping("/booking/{referenceNumber}")
  	public Booking getBooking(@PathVariable String referenceNumber) {
  		//if booking is not found, then method will return null
  		return bookingService.findByReferenceNumber(referenceNumber);
  	}
  	
    //@PreAuthorize("hasAnyRole('USER')")
  	@GetMapping("/check_availiable_cars")
  	public List<Car> getAvailableCars(@RequestParam String start, String end){
  		List<Car> cars = carService.findAll().stream()
  				.filter(car->car.getCarStatus().equals("available")).collect(Collectors.toList());
  		LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ISO_DATE);
  		LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ISO_DATE);
  		List<Booking> bookings = bookingService.getBookingsWithinRange(startDate, endDate);  		
  		if(!bookings.isEmpty()) {
  			List<Long> carIds = new ArrayList<>();
  			for(Booking b: bookings){
  				carIds.add(b.getCar().getCarId());
  			}
  			cars = cars.stream().filter(car->!carIds.contains(car.getCarId())).collect(Collectors.toList());
  		}  
  		
  		return cars;
  	}
	
}
