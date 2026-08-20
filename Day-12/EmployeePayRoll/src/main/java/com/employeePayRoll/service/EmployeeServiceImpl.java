package com.employeePayRoll.service;

import com.employeePayRoll.dao.EmployeeDao;
import com.employeePayRoll.dto.Employee;
import com.employeePayRoll.exception.EmployeeNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDAO;

    @Override
    public List<Employee> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeDAO.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        log.info("Fetching employee with id: {}", id);
        return employeeDAO.findById(id)
                .orElseThrow(() -> {
                    log.warn("Employee not found with id: {}", id);
                    return new EmployeeNotFoundException(id);
                });
    }

    @Override
    public Employee createEmployee(Employee employee) {
        log.info("Creating employee: {}", employee.getName());
        return employeeDAO.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        log.info("Updating employee with id: {}", id);
        if (!employeeDAO.existsById(id)) {
            log.warn("Cannot update — employee not found with id: {}", id);
            throw new EmployeeNotFoundException(id);
        }
        return employeeDAO.update(id, employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Deleting employee with id: {}", id);
        if (!employeeDAO.existsById(id)) {
            log.warn("Cannot delete — employee not found with id: {}", id);
            throw new EmployeeNotFoundException(id);
        }
        employeeDAO.deleteById(id);
        log.info("Employee deleted with id: {}", id);
    }
}
