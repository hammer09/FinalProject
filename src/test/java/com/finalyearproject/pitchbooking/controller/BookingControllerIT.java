package com.finalyearproject.pitchbooking.controller;

import com.finalyearproject.pitchbooking.controller.BookingController;
import com.finalyearproject.pitchbooking.model.Booking;
import javafx.beans.binding.Bindings;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookingControllerIT {

    @Autowired
    BookingController bookingController;

    @Test
    public void testSaveBooking() {
        Booking booking = new Booking("name", "teamname");
        String result  = bookingController.saveBooking(booking);

        assertEquals(result, "redirect:/");
    }

}
