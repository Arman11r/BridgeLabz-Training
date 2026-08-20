package com.employeePayRoll.service;

import com.employeePayRoll.dao.PayslipDao;
import com.employeePayRoll.dto.Employee;
import com.employeePayRoll.dto.Payslip;
import com.employeePayRoll.exception.PayslipAlreadyExistsException;
import com.employeePayRoll.exception.PayslipNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PayslipServiceImpl implements PayslipService {

    private final PayslipDao payslipDao;
    private final EmployeeService employeeService;

    @Override
    public Payslip generatePayslip(Long employeeId, String payMonth) {
        String resolvedMonth = StringUtils.hasText(payMonth)
                ? payMonth
                : YearMonth.now().toString();

        log.info("Generating payslip for employee {} for month {}", employeeId, resolvedMonth);

        // Throws EmployeeNotFoundException if the employee doesn't exist.
        Employee employee = employeeService.getEmployeeById(employeeId);

        payslipDao.findByEmployeeIdAndMonth(employeeId, resolvedMonth).ifPresent(existing -> {
            log.warn("Payslip already exists for employee {} for month {}", employeeId, resolvedMonth);
            throw new PayslipAlreadyExistsException(employeeId, resolvedMonth);
        });

        Payslip payslip = new Payslip(
                null,
                employeeId,
                resolvedMonth,
                employee.getBasicSalary(),
                employee.getAllowances(),
                employee.getTaxPercent(),
                employee.getGrossSalary(),
                employee.getNetSalary(),
                LocalDateTime.now()
        );

        return payslipDao.save(payslip);
    }

    @Override
    public List<Payslip> getPayslipsForEmployee(Long employeeId) {
        log.info("Fetching payslips for employee {}", employeeId);
        // Throws EmployeeNotFoundException if the employee doesn't exist.
        employeeService.getEmployeeById(employeeId);
        return payslipDao.findAllByEmployeeId(employeeId);
    }

    @Override
    public Payslip getPayslipById(Long id) {
        log.info("Fetching payslip {}", id);
        return payslipDao.findById(id)
                .orElseThrow(() -> new PayslipNotFoundException(id));
    }
}
