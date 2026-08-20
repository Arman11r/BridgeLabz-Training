package com.employeePayRoll.controller;

import com.employeePayRoll.dto.Payslip;
import com.employeePayRoll.dto.PayslipRequest;
import com.employeePayRoll.service.PayslipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees/{employeeId}/payslips")
@RequiredArgsConstructor
public class PayslipController {

    private final PayslipService payslipService;

    @PostMapping
    public ResponseEntity<Payslip> generatePayslip(
            @PathVariable Long employeeId,
            @Valid @RequestBody(required = false) PayslipRequest request) {
        String month = request == null ? null : request.getMonth();
        Payslip payslip = payslipService.generatePayslip(employeeId, month);
        return ResponseEntity.status(HttpStatus.CREATED).body(payslip);
    }

    @GetMapping
    public ResponseEntity<List<Payslip>> getPayslipsForEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payslipService.getPayslipsForEmployee(employeeId));
    }

    @GetMapping("/{payslipId}")
    public ResponseEntity<Payslip> getPayslipById(
            @PathVariable Long employeeId,
            @PathVariable Long payslipId) {
        Payslip payslip = payslipService.getPayslipById(payslipId);
        return ResponseEntity.ok(payslip);
    }
}
