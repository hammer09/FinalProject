package com.finalyearproject.pitchbooking.controller;

import com.finalyearproject.pitchbooking.model.Booking;
import com.finalyearproject.pitchbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    private final String VIEW_HOME_PAGE_URL = "/";
    @GetMapping(VIEW_HOME_PAGE_URL )
    public String viewHomePage(Model model) {
        List<Booking> listBookings = bookingService.listAll();
        model.addAttribute("listBookings", listBookings);

        return "index";
    }

    private final String SHOW_NEW_BOOKING_FORM_URL = "/new";
    @GetMapping(SHOW_NEW_BOOKING_FORM_URL)
    public String showNewBookingForm(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking",booking);

        return "new_booking";
    }

    private final String SAVE_BOOKING_URL = "/save";
    @PostMapping (SAVE_BOOKING_URL)
    public String saveBooking(@ModelAttribute("booking") Booking booking){
        bookingService.save(booking);

        return "redirect:/";
    }

    private final String SHOW_EDIT_BOOKING_FORM_URL = "/edit/{id}";
    @GetMapping(SHOW_EDIT_BOOKING_FORM_URL)
    public ModelAndView showEditBookingForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_booking");

        Booking booking = bookingService.get(id);
        mav.addObject("booking", booking);

        return mav;
    }

    private final String DELETE_BOOKING_URL = "/delete/{id}";
    @GetMapping(DELETE_BOOKING_URL)
    public  String deleteBooking(@PathVariable(name = "id")long id) {
        bookingService.delete(id);

        return "redirect:/";
    }

    //@GetMapping("/")
    //public String home1() {
        //return "/home";
    //}

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }

    @GetMapping("/expenditure")
    public String expenditure() {
        return "/expenditure";
    }

    @GetMapping("/registration")
    public String registration () {
        return "/registration";
    }


    @GetMapping("/login")
    public String login() { return "/login";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}