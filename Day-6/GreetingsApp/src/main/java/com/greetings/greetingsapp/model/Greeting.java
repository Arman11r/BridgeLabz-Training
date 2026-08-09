package com.greetings.greetingsapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;

import java.time.LocalDateTime;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDateTime timestamp;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    // Automatically set right before this row is first saved - you never set it manually
    @PrePersist
    public void setTimestampOnCreate() {
        this.timestamp = LocalDateTime.now();
    }

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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Computed, not stored in the DB - "Hello, <name>!"
    @Transient
    public String getMessage() {
        return "Hello, " + name + "!";
    }
}