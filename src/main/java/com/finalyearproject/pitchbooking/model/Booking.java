package com.finalyearproject.pitchbooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
// Test Git Commit
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Booking() {
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
}
