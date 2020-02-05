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

    public  List<Booking> listAll(){

        return  bookingRepository.findAll();
    }

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }

    public void save (Booking booking) {
        bookingRepository.save(booking);
    }
    public void createBooking(Booking booking) {
        bookingRepository.save(booking);
    }

   public Booking get (Long id) {
        return bookingRepository.findById(id).get();
    }

    public void delete (Long id) {
        bookingRepository.deleteById(id);
    }
}