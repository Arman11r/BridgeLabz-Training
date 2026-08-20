package com.employeePayRoll.dao;

import com.employeePayRoll.dto.Payslip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public class PayslipDaoImpl implements PayslipDao {

    private final JdbcTemplate jdbcTemplate;

    public PayslipDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Payslip> payslipRowMapper = (rs, rowNum) -> new Payslip(
            rs.getLong("id"),
            rs.getLong("employee_id"),
            rs.getString("pay_month"),
            rs.getBigDecimal("basic_salary"),
            rs.getBigDecimal("allowances"),
            rs.getBigDecimal("tax_percent"),
            rs.getBigDecimal("gross_salary"),
            rs.getBigDecimal("net_salary"),
            rs.getTimestamp("generated_at").toLocalDateTime()
    );

    @Override
    public List<Payslip> findAllByEmployeeId(Long employeeId) {
        return jdbcTemplate.query(
                "SELECT * FROM payslips WHERE employee_id = ? ORDER BY pay_month DESC",
                payslipRowMapper, employeeId);
    }

    @Override
    public Optional<Payslip> findById(Long id) {
        List<Payslip> results = jdbcTemplate.query(
                "SELECT * FROM payslips WHERE id = ?", payslipRowMapper, id);
        return results.stream().findFirst();
    }

    @Override
    public Optional<Payslip> findByEmployeeIdAndMonth(Long employeeId, String payMonth) {
        List<Payslip> results = jdbcTemplate.query(
                "SELECT * FROM payslips WHERE employee_id = ? AND pay_month = ?",
                payslipRowMapper, employeeId, payMonth);
        return results.stream().findFirst();
    }

    @Override
    public Payslip save(Payslip payslip) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO payslips(employee_id, pay_month, basic_salary, allowances, " +
                            "tax_percent, gross_salary, net_salary, generated_at) VALUES (?,?,?,?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setLong(1, payslip.getEmployeeId());
            ps.setString(2, payslip.getPayMonth());
            ps.setBigDecimal(3, payslip.getBasicSalary());
            ps.setBigDecimal(4, payslip.getAllowances());
            ps.setBigDecimal(5, payslip.getTaxPercent());
            ps.setBigDecimal(6, payslip.getGrossSalary());
            ps.setBigDecimal(7, payslip.getNetSalary());
            ps.setTimestamp(8, Timestamp.valueOf(payslip.getGeneratedAt()));
            return ps;
        }, keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        payslip.setId(generatedId);
        return payslip;
    }
}
