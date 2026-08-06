package com.clinic.dto;

public class Doctor {
    private int doctorId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private boolean isActive;

    public Doctor() {}

    public Doctor(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return "Doctor{id=" + doctorId + ", name=" + firstName + " " + lastName +
                ", phone=" + phoneNumber + ", email=" + email + ", active=" + isActive + "}";
    }
}