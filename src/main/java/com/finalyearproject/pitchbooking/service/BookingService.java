package com.finalyearproject.pitchbooking.service;

import com.finalyearproject.pitchbooking.model.Booking;
import com.finalyearproject.pitchbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> findAllBookings() {
       return bookingRepository.findAllBookings();
    }
}
