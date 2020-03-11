package edu.miu.carRental.service;

import java.util.List;

import edu.miu.carRental.domain.Booking;

public interface BookingService {
	
	public List<Booking> findAll();
	
	public Booking findById(Long id);
	
	public Booking save(Booking booking);
	
	public void delete(Long id);
	
	public Booking changeBookingStatus(Long id, String status);
	
	public List<Booking> searchBookings(String searchString);
}
