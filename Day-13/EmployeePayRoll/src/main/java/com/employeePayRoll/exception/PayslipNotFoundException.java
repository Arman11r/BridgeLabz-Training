package com.employeePayRoll.exception;

public class PayslipNotFoundException extends RuntimeException {
    public PayslipNotFoundException(Long id) {
        super("Payslip not found with id: " + id);
    }
}
