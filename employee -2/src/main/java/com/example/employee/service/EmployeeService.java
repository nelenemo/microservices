package com.example.employee.service;

import com.example.employee.dto.ResponseEmployee;
import com.example.employee.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {
   ResponseEmployee getEmployeesById(int id);

    EmployeeEntity saveEmployees(EmployeeEntity employeeEntity);
}
