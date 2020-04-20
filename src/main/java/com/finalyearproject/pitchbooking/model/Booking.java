package com.finalyearproject.pitchbooking.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String teamname;
    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Pitch pitch;

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

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull(message = "Date/time Required")
    private LocalDateTime time;

    //private Booking booking;

    private boolean sameAsFormer(Pitch newPitch) {
        if (this.pitch == null) {
            return newPitch == null;
        }
        return this.pitch.equals(newPitch);
    }

    public Pitch getPitch() {
        return pitch;
    }

    public void setPitch(Pitch pitch) {

        // prevent endless loop

        if (sameAsFormer(pitch)) {
            return;
        }
        // set new pitch

        Pitch oldpitch = this.pitch;
        this.pitch = pitch;

        // remove from old stats

        if (oldpitch != null) {
            oldpitch.setBooking(null);
        }
        // set new stats
        if (pitch != null) {
            pitch.setBooking(this);
        }
    }
}



