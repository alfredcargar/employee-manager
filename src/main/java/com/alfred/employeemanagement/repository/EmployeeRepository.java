package com.alfred.employeemanagement.repository;

import com.alfred.employeemanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
