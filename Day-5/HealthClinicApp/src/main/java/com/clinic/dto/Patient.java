package com.clinic.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Patient {
    private int patientId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private boolean isActive;
    private LocalDateTime registeredOn;

    public Patient() {}

    public Patient(String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public LocalDateTime getRegisteredOn() { return registeredOn; }
    public void setRegisteredOn(LocalDateTime registeredOn) { this.registeredOn = registeredOn; }

    @Override
    public String toString() {
        return "Patient{id=" + patientId + ", name=" + firstName + " " + lastName +
                ", dob=" + dateOfBirth + ", gender=" + gender +
                ", phone=" + phoneNumber + ", email=" + email +
                ", active=" + isActive + ", registeredOn=" + registeredOn + "}";
    }
}