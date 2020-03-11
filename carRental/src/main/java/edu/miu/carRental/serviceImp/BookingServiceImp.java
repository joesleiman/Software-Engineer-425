package edu.miu.carRental.serviceImp;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.miu.carRental.domain.Booking;
import edu.miu.carRental.repository.BookingRepository;
import edu.miu.carRental.service.BookingService;

@Service
public class BookingServiceImp implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking findById(Long id) {
		//return bookingRepository.findById(id).orElse(null);
		return bookingRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Booking with id : " + id+" is not available"));
	}

	@Override
	public Booking save(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public void delete(Long id) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Booking with id : " + id+" is not available"));
		
		bookingRepository.delete(booking);
	}

	@Override
	public Booking changeBookingStatus(Long id, String status) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Booking with id: " + id + " is not available."));
		System.out.println("CHANGED BOOKING:::::::::::::");
		System.out.println(booking.getStartDate());
		booking.setBookingStatus(status);
		
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> searchBookings(String searchString) {
		if(containDecimalPoint(searchString) && isMoney(searchString)) {
			return bookingRepository.findAllByTotalPrice(Double.parseDouble(searchString));
		}else if(isDate(searchString)) {
			LocalDate searchDate = LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
			//return bookingRepository.findAllByBookingDateContainingOrStartDateContainingOrEndDate(searchDate, searchDate, searchDate);
			return bookingRepository.findAllByBookingDateOrStartDateOrEndDate(searchDate, searchDate, searchDate);
		}else {
			return bookingRepository.findAllByReferenceNumber(searchString);
		}
	}
	
	private boolean isMoney(String searchString) {
		boolean isParseableAsMoney = false;
		try {
			Double.parseDouble(searchString);
			isParseableAsMoney = true;
		} catch (Exception e) {
			if(e instanceof ParseException) {
				isParseableAsMoney =false;
			}
		}
		return isParseableAsMoney;
	}
	
	private boolean isDate(String searchString) {
		boolean isParseableAsDate = false;
		try {
			LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
			isParseableAsDate = true;
		} catch (Exception e) {
			if(e instanceof ParseException) {
				isParseableAsDate = false;
			}
		}
		return isParseableAsDate;
	}
	
	private boolean containDecimalPoint(String searchString) {
		return searchString.contains(".");
	}
}
