package com.employeePayRoll.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayslipRequest {

    /**
     * Optional. Format "yyyy-MM", e.g. "2026-08". Defaults to the current month if omitted.
     */
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])$", message = "month must be in yyyy-MM format")
    private String month;
}
