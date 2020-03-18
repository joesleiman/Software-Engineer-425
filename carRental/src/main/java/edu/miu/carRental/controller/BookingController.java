package edu.miu.carRental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.carRental.domain.Booking;
import edu.miu.carRental.serviceImp.BookingServiceImp;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class BookingController {
	
	@Autowired
	private BookingServiceImp bookingService;
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@GetMapping("employee/bookings")
	public List<Booking> getAllBookings(){
		return bookingService.findAll();
	}
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@GetMapping("/employee/bookings/{id}")
	public Booking getBooking(@PathVariable Long id) {
		return bookingService.findById(id);
	}
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@PostMapping("/employee/bookings")
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.save(booking);
	}
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@PutMapping("/employee/bookings")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bookingService.save(booking);
	}
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@DeleteMapping(value="/employee/bookings/{id}")
	public void deleteBooking(@PathVariable Long id) {
		bookingService.delete(id);
	}
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@PutMapping("/employee/bookings/change_status")
	public Booking changeBookingStatus(@RequestBody Booking booking) {
		return bookingService.changeBookingStatus(booking.getReferenceNumber(), booking.getBookingStatus());
	}
	
	@PreAuthorize("hasAnyRole('EMPLOYEE','ADMIN')")
	@GetMapping("/employee/bookings/search/{searchString}")
	public List<Booking> searchBookings(@PathVariable String searchString){
		return bookingService.searchBookings(searchString);
	}	
	
}
