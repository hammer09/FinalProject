package com.finalyearproject.pitchbooking.controller;

import com.finalyearproject.pitchbooking.model.Booking;
import com.finalyearproject.pitchbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {

    private final String BOOKING_LIST_URL = "/bookings/list";
    private final String EDIT_BOOKING_URL = "/bookings/edit/{id}";
    private final String EDIT_BOOKING_TEMPLATE = "/bookings/edit";
    private final String DELETE_BOOKING_URL = "/delete/{id}";
    private final String VIEW_HOME_PAGE_URL = "/";
    private final String SHOW_NEW_BOOKING_FORM_URL = "/new";
    private final String SAVE_BOOKING_URL = "/save";
    private final String UPDATE_BOOKING_URL = "/update/{id}";

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


    @GetMapping(VIEW_HOME_PAGE_URL )
    public String viewHomePage(Model model) {
        List<Booking> listBookings = bookingService.listAll();
        model.addAttribute("listBookings", listBookings);

        return "index";
    }


    @GetMapping(SHOW_NEW_BOOKING_FORM_URL)
    public String showNewBookingForm(Model model) {
        Booking booking = new Booking();
        model.addAttribute("booking",booking);

        return "bookings/create";
    }


    @PostMapping (SAVE_BOOKING_URL)
    public String saveBooking(@Valid @ModelAttribute("booking")

                                          Booking booking,
            BindingResult bindingResult,Model model){

        if (bindingResult.hasErrors()){
            return "create";
        }

        bookingService.save(booking);

        return "redirect:/";
    }

    @GetMapping(EDIT_BOOKING_URL)
    public String showEditBookingForm(@PathVariable(name = "id") Long id, Model model)  {
        //Find booking by id
        Booking booking = bookingService.get(id);

        // Add booking to model
        model.addAttribute("booking", booking);

        return EDIT_BOOKING_TEMPLATE;
    }


    @PostMapping (UPDATE_BOOKING_URL)
    public String updateBooking(@PathVariable(name = "id") Long id, @Valid @ModelAttribute("booking")
                                      Booking booking,
                              BindingResult bindingResult,Model model){

        if (bindingResult.hasErrors()){
            return EDIT_BOOKING_TEMPLATE + "/" + id;
        }

        //Find booking by id
        //booking = bookingService.findById(booking.getId());
        bookingService.save(booking);

        return "redirect:/";
    }

//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @Valid User user,
//                             BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            user.setId(id);
//            return "update-user";
//        }
//
//        userRepository.save(user);
//        model.addAttribute("users", userRepository.findAll());
//        return "index";
//    }


    @GetMapping(DELETE_BOOKING_URL)
    public  String deleteBooking(@PathVariable(name = "id")long id) {
        bookingService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registration () {
        return "/registration";
    }


    @GetMapping("/login")
    public String login() { return "/login";
    }

    @GetMapping("/expenditure")
    public String expenditure() {
        return "/expenditure";
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }


}