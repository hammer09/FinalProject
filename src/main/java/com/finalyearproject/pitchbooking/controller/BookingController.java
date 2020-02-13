package com.finalyearproject.pitchbooking.controller;

import com.finalyearproject.pitchbooking.model.Booking;
import com.finalyearproject.pitchbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookingController {

    private final String BOOKING_LIST_URL = "/bookings/list";
    @Autowired
    private BookingService bookingService;

    @GetMapping(BOOKING_LIST_URL)
    public String getBookings(Model model) {
        // Get list of bookings from booking service
        List<Booking> bookings = bookingService.findAllBookings();

        // Add list of bookings to model
        model.addAttribute("bookings", bookings);

        // return view
        return BOOKING_LIST_URL;
    }

   //@PostMapping("/bookings/create")
       //public String createBooking(@ModelAttribute Booking booking, BindingResult errors, Model model) {

           //bookingService.createBooking(booking);
           //return view
          // return "bookings/list";
    //}

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Booking> listBookings = bookingService.listAll();
        model.addAttribute("listBookings", listBookings);

        return "index";
    }

    @GetMapping("/new")
    public String showNewBookingForm(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking",booking);

        return "new_booking";
    }

    @RequestMapping (value = "/save", method = RequestMethod.POST)
    public String saveBooking(@ModelAttribute("booking") Booking booking){
        bookingService.save(booking);
        return "redirect:/";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditBookingForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_booking");

        Booking booking = bookingService.get(id);
        mav.addObject("booking", booking);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public  String deleteBooking(@PathVariable(name = "id")long id) {
        bookingService.delete(id);
        return "redirect:/";
    }

}
