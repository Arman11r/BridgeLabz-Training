package com.clinic.dao;

import com.clinic.dto.Appointment;
import java.util.List;

public interface AppointmentDAO {
    int insertAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByPatient(int patientId);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    boolean updateAppointmentStatus(int appointmentId, String status);
    boolean deleteAppointment(int id);
}