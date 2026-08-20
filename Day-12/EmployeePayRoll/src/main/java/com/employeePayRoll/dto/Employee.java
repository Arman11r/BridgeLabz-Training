package com.employeePayRoll.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Department is required")
    private String department;

    @NotNull(message = "Basic salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Basic salary must be positive")
    private BigDecimal basicSalary;

    @DecimalMin(value = "0.0", message = "Allowances cannot be negative")
    private BigDecimal allowances = BigDecimal.ZERO;

    @DecimalMin(value = "0.0", message = "Tax percent cannot be negative")
    private BigDecimal taxPercent = BigDecimal.ZERO;

    // Derived fields - calculated on the fly, not persisted to the DB.

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public BigDecimal getGrossSalary() {
        BigDecimal basic = basicSalary == null ? BigDecimal.ZERO : basicSalary;
        BigDecimal allow = allowances == null ? BigDecimal.ZERO : allowances;
        return basic.add(allow).setScale(2, RoundingMode.HALF_UP);
    }

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public BigDecimal getNetSalary() {
        BigDecimal gross = getGrossSalary();
        BigDecimal tax = taxPercent == null ? BigDecimal.ZERO : taxPercent;
        BigDecimal taxAmount = gross.multiply(tax)
                .divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP);
        return gross.subtract(taxAmount).setScale(2, RoundingMode.HALF_UP);
    }
}
