package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;
import com.clinic.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int insertVisitHistory(VisitHistory visitHistory) {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, visitHistory.getAppointmentId());
            pstmt.setString(2, visitHistory.getDiagnosis());
            pstmt.setString(3, visitHistory.getPrescription());
            pstmt.setString(4, visitHistory.getVisitNotes());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
            return -1;

        } catch (SQLException e) {
            throw new DAOException("Failed to insert visit history: " + e.getMessage(), e);
        }
    }

    @Override
    public VisitHistory getVisitHistoryByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch visit history for appointment " + appointmentId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<VisitHistory> getAllVisitHistory() {
        String sql = "SELECT * FROM visit_history ORDER BY visit_id";
        List<VisitHistory> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch all visit history: " + e.getMessage(), e);
        }
    }

    private VisitHistory mapRow(ResultSet rs) throws SQLException {
        VisitHistory v = new VisitHistory();
        v.setVisitId(rs.getInt("visit_id"));
        v.setAppointmentId(rs.getInt("appointment_id"));
        v.setDiagnosis(rs.getString("diagnosis"));
        v.setPrescription(rs.getString("prescription"));
        v.setVisitNotes(rs.getString("visit_notes"));
        return v;
    }
}