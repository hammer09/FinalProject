package com.finalyearproject.pitchbooking.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Pitch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @OneToOne
    @JoinColumn
    private Booking booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


//private Pitch pitch;

    //private Set<Booking> booking = new HashSet<>();

    public Pitch() {
    }

    public Booking getBooking() {
        return booking;
    }

    private boolean sameAsFormer(Booking newBooking) {
        if (this.booking == null) {
            return newBooking == null;
        }
        return this.booking.equals(newBooking);
    }

    public void setBooking(Booking booking) {

        // prevent endless loop

        if (sameAsFormer(booking)) {
            return;
        }

        // set new booking

        Booking oldBooking = this.booking;
        this.booking = booking;

        // remove from the old booking

        if (oldBooking != null) {
            oldBooking.setPitch(null);
        }

        // set record into new booking

        if (booking != null) {
            booking.setPitch(this);;
        }
    }
}


