package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;
import com.clinic.exception.DAOException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public int insertBilling(Billing billing) {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, billing.getAppointmentId());
            pstmt.setBigDecimal(2, billing.getAmount());
            pstmt.setString(3, billing.getPaymentStatus());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) return keys.getInt(1);
            return -1;

        } catch (SQLException e) {
            throw new DAOException("Failed to insert billing: " + e.getMessage(), e);
        }
    }

    @Override
    public Billing getBillingByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM billing WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, appointmentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return mapRow(rs);
            return null;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch billing for appointment " + appointmentId + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Billing> getAllBillings() {
        String sql = "SELECT * FROM billing ORDER BY bill_id";
        List<Billing> list = new ArrayList<>();
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) list.add(mapRow(rs));
            return list;

        } catch (SQLException e) {
            throw new DAOException("Failed to fetch all billings: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean updatePaymentStatus(int billId, String status) {
        String sql = "UPDATE billing SET payment_status = ? WHERE bill_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, status);
            pstmt.setInt(2, billId);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new DAOException("Failed to update payment status for bill " + billId + ": " + e.getMessage(), e);
        }
    }

    private Billing mapRow(ResultSet rs) throws SQLException {
        Billing b = new Billing();
        b.setBillId(rs.getInt("bill_id"));
        b.setAppointmentId(rs.getInt("appointment_id"));
        b.setAmount(rs.getBigDecimal("amount"));
        b.setPaymentStatus(rs.getString("payment_status"));
        Timestamp ts = rs.getTimestamp("billing_date");
        b.setBillingDate(ts != null ? ts.toLocalDateTime() : null);
        return b;
    }
}