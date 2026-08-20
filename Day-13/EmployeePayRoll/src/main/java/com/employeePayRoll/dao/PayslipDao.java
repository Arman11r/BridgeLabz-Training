package com.employeePayRoll.dao;

import com.employeePayRoll.dto.Payslip;

import java.util.List;
import java.util.Optional;

public interface PayslipDao {
    List<Payslip> findAllByEmployeeId(Long employeeId);
    Optional<Payslip> findById(Long id);
    Optional<Payslip> findByEmployeeIdAndMonth(Long employeeId, String payMonth);
    Payslip save(Payslip payslip);
}
