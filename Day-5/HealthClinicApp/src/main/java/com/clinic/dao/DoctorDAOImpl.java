package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Doctor;
import com.clinic.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl implements DoctorDAO {

    @Override
    public int insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (first_name, last_name, phone_number, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getPhoneNumber());
            pstmt.setString(4, doctor.getEmail());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
            return -1;

        } catch (SQLException e) {
            throw new DAOException("Failed to insert doctor: " + e.getMessage(), e);
        }
    }

    @Override
    public Doctor getDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch doctor with id " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        String sql = "SELECT * FROM doctors ORDER BY doctor_id";
        List<Doctor> doctors = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) doctors.add(mapRow(rs));
            return doctors;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch all doctors: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        String sql = "UPDATE doctors SET first_name=?, last_name=?, phone_number=?, email=? WHERE doctor_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, doctor.getFirstName());
            pstmt.setString(2, doctor.getLastName());
            pstmt.setString(3, doctor.getPhoneNumber());
            pstmt.setString(4, doctor.getEmail());
            pstmt.setInt(5, doctor.getDoctorId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to update doctor " + doctor.getDoctorId() + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteDoctor(int id) {
        String sql = "DELETE FROM doctors WHERE doctor_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to delete doctor " + id + ": " + e.getMessage(), e);
        }
    }

    private Doctor mapRow(ResultSet rs) throws SQLException {
        Doctor d = new Doctor();
        d.setDoctorId(rs.getInt("doctor_id"));
        d.setFirstName(rs.getString("first_name"));
        d.setLastName(rs.getString("last_name"));
        d.setPhoneNumber(rs.getString("phone_number"));
        d.setEmail(rs.getString("email"));
        d.setActive(rs.getBoolean("is_active"));
        return d;
    }
}