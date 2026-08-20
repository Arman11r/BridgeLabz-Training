package com.employeePayRoll.exception;

public class PayslipAlreadyExistsException extends RuntimeException {
    public PayslipAlreadyExistsException(Long employeeId, String payMonth) {
        super("Payslip already exists for employee " + employeeId + " for month " + payMonth);
    }
}
