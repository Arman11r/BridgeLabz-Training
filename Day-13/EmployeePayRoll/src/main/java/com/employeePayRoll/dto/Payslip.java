package com.employeePayRoll.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Unlike Employee's grossSalary/netSalary (calculated live from current values),
 * a Payslip is a frozen snapshot of an employee's pay for a given month. Once
 * generated, it does not change even if the employee's salary is updated later.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payslip {
    private Long id;
    private Long employeeId;
    private String payMonth;       // format: "yyyy-MM", e.g. "2026-08"
    private BigDecimal basicSalary;
    private BigDecimal allowances;
    private BigDecimal taxPercent;
    private BigDecimal grossSalary;
    private BigDecimal netSalary;
    private LocalDateTime generatedAt;
}
