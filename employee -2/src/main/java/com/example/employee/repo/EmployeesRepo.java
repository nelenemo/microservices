package com.example.employee.repo;

import com.example.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepo extends JpaRepository<EmployeeEntity, Integer> {
}
