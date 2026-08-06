package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Appointment;
import com.clinic.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl implements AppointmentDAO {

    @Override
    public int insertAppointment(Appointment appointment) {
        String sql = "INSERT INTO appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, appointment.getPatientId());
            pstmt.setInt(2, appointment.getDoctorId());
            pstmt.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDate()));
            pstmt.setString(4, appointment.getStatus());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
            return -1;

        } catch (SQLException e) {
            throw new DAOException("Failed to insert appointment: " + e.getMessage(), e);
        }
    }

    @Override
    public Appointment getAppointmentById(int id) {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch appointment " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Appointment> getAllAppointments() {
        String sql = "SELECT * FROM appointments ORDER BY appointment_date";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch all appointments: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Appointment> getAppointmentsByPatient(int patientId) {
        String sql = "SELECT * FROM appointments WHERE patient_id = ? ORDER BY appointment_date";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, patientId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch appointments for patient " + patientId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Appointment> getAppointmentsByDoctor(int doctorId) {
        String sql = "SELECT * FROM appointments WHERE doctor_id = ? ORDER BY appointment_date";
        List<Appointment> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, doctorId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch appointments for doctor " + doctorId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateAppointmentStatus(int appointmentId, String status) {
        String sql = "UPDATE appointments SET status = ? WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, appointmentId);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to update status for appointment " + appointmentId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteAppointment(int id) {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to delete appointment " + id + ": " + e.getMessage(), e);
        }
    }

    private Appointment mapRow(ResultSet rs) throws SQLException {
        Appointment a = new Appointment();
        a.setAppointmentId(rs.getInt("appointment_id"));
        a.setPatientId(rs.getInt("patient_id"));
        a.setDoctorId(rs.getInt("doctor_id"));
        Timestamp ts = rs.getTimestamp("appointment_date");
        a.setAppointmentDate(ts != null ? ts.toLocalDateTime() : null);
        a.setStatus(rs.getString("status"));
        return a;
    }
}