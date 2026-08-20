package com.employeePayRoll.dao;

import com.employeePayRoll.dto.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    Employee update(Long id, Employee employee);
    void deleteById(Long id);
    boolean existsById(Long id);
}
