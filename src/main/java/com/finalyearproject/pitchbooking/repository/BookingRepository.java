package com.finalyearproject.pitchbooking.repository;

import com.finalyearproject.pitchbooking.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookingRepository {

    public List findAllBookings() {
        Booking booking1 = new Booking();
        booking1.setName("Christopher Hamilton");
        Booking booking2 = new Booking();
        booking2.setName("Craig Farrer ");
        Booking booking3 = new Booking();
        booking3.setName("Gavin Graham ");
        Booking booking4 = new Booking();
        booking4.setName("David Norrby ");
        Booking booking5 = new Booking();
        booking5.setName("David Best ");



        List bookings = Arrays.asList(booking1, booking2, booking3, booking4, booking5);

        return bookings;
    }
}
