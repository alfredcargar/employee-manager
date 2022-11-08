package com.alfred.employeemanagement.services;

import com.alfred.employeemanagement.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MainService {

    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee editEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    void deleteEmployee(Long id);
}
