package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Specialization;
import com.clinic.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SpecializationDAOImpl implements SpecializationDAO {

    @Override
    public int insertSpecialization(Specialization specialization) {
        String sql = "INSERT INTO specializations (name, description) VALUES (?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, specialization.getName());
            pstmt.setString(2, specialization.getDescription());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
            return -1;

        } catch (SQLException e) {
            throw new DAOException("Failed to insert specialization: " + e.getMessage(), e);
        }
    }

    @Override
    public Specialization getSpecializationById(int id) {
        String sql = "SELECT * FROM specializations WHERE specialization_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch specialization " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Specialization> getAllSpecializations() {
        String sql = "SELECT * FROM specializations ORDER BY specialization_id";
        List<Specialization> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch all specializations: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updateSpecialization(Specialization specialization) {
        String sql = "UPDATE specializations SET name=?, description=? WHERE specialization_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, specialization.getName());
            pstmt.setString(2, specialization.getDescription());
            pstmt.setInt(3, specialization.getSpecializationId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to update specialization " + specialization.getSpecializationId() + ": " + e.getMessage(), e);
        }
    }

    @Override
    public boolean deleteSpecialization(int id) {
        String sql = "DELETE FROM specializations WHERE specialization_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to delete specialization " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public void assignDoctorToSpecialization(int doctorId, int specializationId) {
        String sql = "INSERT INTO doctor_specializations (doctor_id, specialization_id) VALUES (?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, doctorId);
            pstmt.setInt(2, specializationId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Failed to assign doctor " + doctorId + " to specialization " + specializationId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Specialization> getSpecializationsForDoctor(int doctorId) {
        String sql = "SELECT s.* FROM specializations s " +
                "JOIN doctor_specializations ds ON s.specialization_id = ds.specialization_id " +
                "WHERE ds.doctor_id = ?";
        List<Specialization> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, doctorId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch specializations for doctor " + doctorId + ": " + e.getMessage(), e);
        }
    }

    private Specialization mapRow(ResultSet rs) throws SQLException {
        Specialization s = new Specialization();
        s.setSpecializationId(rs.getInt("specialization_id"));
        s.setName(rs.getString("name"));
        s.setDescription(rs.getString("description"));
        return s;
    }
}