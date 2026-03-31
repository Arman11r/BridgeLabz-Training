package dao;

import db.DBConnection;
import model.Appointment;

import java.sql.*;

public class AppointmentDAO {

    public void bookAppointment(Appointment a) throws Exception {

        String sql = "INSERT INTO appointments(patient_id,doctor_id,appointment_date,status) VALUES(?,?,?,'SCHEDULED')";

        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setDate(3, a.getDate());

            ps.executeUpdate();
        }
    }
}