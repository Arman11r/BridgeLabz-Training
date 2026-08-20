package com.employeePayRoll.service;

import com.employeePayRoll.dto.Payslip;

import java.util.List;

public interface PayslipService {
    Payslip generatePayslip(Long employeeId, String payMonth);
    List<Payslip> getPayslipsForEmployee(Long employeeId);
    Payslip getPayslipById(Long id);
}
