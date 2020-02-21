package com.finalyearproject.pitchbooking.controller;

import com.finalyearproject.pitchbooking.controller.BookingController;
import com.finalyearproject.pitchbooking.model.Booking;
import com.finalyearproject.pitchbooking.service.BookingService;
import javafx.beans.binding.Bindings;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.mockito.*;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingControllerIT {

    @InjectMocks
    BookingController bookingController;

    private MockMvc mockMvc;

    @Mock
    BookingService bookingService;

    @Mock
    Booking booking;

    private static long ID = -1;


    @Test
    public void saveBookingTest() {
        Booking booking = new Booking("name", "teamname");
        String result  = bookingController.saveBooking(booking);
        assertEquals(result, "redirect:/");
    }


    @Test
    public void getBookingTest(){
        Booking booking = new Booking("name", "teamname");
        String result  = bookingController.saveBooking(booking);

        assertEquals(result, "redirect:/");
    }

    @Test
    public void viewHomePageTest(){
        List<Booking> bookings = new ArrayList<>();
        bookings.add(booking);
        when(bookingService.listAll()).thenReturn(bookings);
    }

    @Test
    public void deleteBookingTest() throws Exception{


    }

}
