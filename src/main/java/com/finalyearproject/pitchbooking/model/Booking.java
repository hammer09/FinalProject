package com.finalyearproject.pitchbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String teamname;
    private LocalDateTime time;

    public Booking() {
    }

    public Booking(String name, String teamName) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }


    public String getTeamName() {
        return teamname;
    }

    public void setTeamName(String teamName) {
        this.teamname = teamname;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
