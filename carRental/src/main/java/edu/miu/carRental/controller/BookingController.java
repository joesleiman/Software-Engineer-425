package edu.miu.carRental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import edu.miu.carRental.domain.Booking;
import edu.miu.carRental.serviceImp.BookingServiceImp;

@RestController
public class BookingController {
	
	@Autowired
	private BookingServiceImp bookingService;
	
	@PreAuthorize("hasAuthority('Employee')")
	@GetMapping("/employee/bookings")
	public List<Booking> getAllBookings(){
		return bookingService.findAll();
	}
	
	@PreAuthorize("hasAuthority('Employee')")
	@GetMapping("/employee/bookings/{id}")
	public Booking getBooking(@PathVariable Long id) {
		return bookingService.findById(id);
	}
	
	//@PreAuthorize("hasAuthority('Employee')")
	@PostMapping("/employee/bookings")
	public Booking addBooking(@RequestBody Booking booking) {
		return bookingService.save(booking);
	}
	
	@PutMapping("/employee/bookings")
	public Booking updateBooking(@RequestBody Booking booking) {
		return bookingService.save(booking);
	}
	
	@DeleteMapping(value="/employee/bookings/{id}")
	public void deleteBooking(@PathVariable Long id) {
		bookingService.delete(id);
	}
	
	@PutMapping("/employee/bookings/change_status")
	public Booking changeBookingStatus(@RequestBody Booking booking) {
		return bookingService.changeBookingStatus(booking.getBookingId(), booking.getBookingStatus());
	}
	
	@GetMapping("/employee/bookings/search/{searchString}")
	public List<Booking> searchBookings(@PathVariable String searchString){
		return bookingService.searchBookings(searchString);
	}
}
