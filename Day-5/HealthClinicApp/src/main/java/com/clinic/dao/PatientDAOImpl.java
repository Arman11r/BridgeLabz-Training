package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;
import com.clinic.exception.DAOException;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setDate(3, patient.getDateOfBirth() != null ? Date.valueOf(patient.getDateOfBirth()) : null);
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getPhoneNumber());
            pstmt.setString(6, patient.getEmail());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
            return -1;

        } catch (SQLException e) {
            throw new DAOException("Failed to insert patient: " + e.getMessage(), e);
        }
    }

    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch patient with id " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        String sql = "SELECT * FROM patients ORDER BY patient_id";
        List<Patient> patients = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) patients.add(mapRow(rs));
            return patients;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch all patients: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET first_name=?, last_name=?, date_of_birth=?, gender=?, " +
                "phone_number=?, email=? WHERE patient_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            pstmt.setDate(3, patient.getDateOfBirth() != null ? Date.valueOf(patient.getDateOfBirth()) : null);
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getPhoneNumber());
            pstmt.setString(6, patient.getEmail());
            pstmt.setInt(7, patient.getPatientId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to update patient " + patient.getPatientId() + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to delete patient " + id + ": " + e.getMessage(), e);
        }
    }

    private Patient mapRow(ResultSet rs) throws SQLException {
        Patient p = new Patient();
        p.setPatientId(rs.getInt("patient_id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        Date dob = rs.getDate("date_of_birth");
        p.setDateOfBirth(dob != null ? dob.toLocalDate() : null);
        p.setGender(rs.getString("gender"));
        p.setPhoneNumber(rs.getString("phone_number"));
        p.setEmail(rs.getString("email"));
        p.setActive(rs.getBoolean("is_active"));
        Timestamp registeredOn = rs.getTimestamp("registered_on");
        p.setRegisteredOn(registeredOn != null ? registeredOn.toLocalDateTime() : null);
        return p;
    }
}