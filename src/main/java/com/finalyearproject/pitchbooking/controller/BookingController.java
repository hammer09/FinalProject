package com.finalyearproject.pitchbooking.controller;

import com.finalyearproject.pitchbooking.model.Booking;
import com.finalyearproject.pitchbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/bookings/list")
    public String getBookings(Model model){
        // Get list of bookings from booking service
        List<Booking> bookings = bookingService.findAllBookings();

        // Add list of bookings to model
        model.addAttribute("bookings", bookings);

        // return view
        return "bookings/list";
    }
}
