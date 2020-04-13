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

        @OneToOne(mappedBy = "pitch", cascade = CascadeType.ALL)

        //private Set<Booking> booking = new HashSet<>();

       private Booking booking;

        public Pitch() { }



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
    }







