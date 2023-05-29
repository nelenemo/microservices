package com.example.employee.controller;

import com.example.employee.dto.ResponseEmployee;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController

public class EmployeeController {
    private final EmployeeService employeeService;



    @Autowired
    private RestTemplate restTemplate;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getEmployee")
    public String GetEmployee(){

        String address=restTemplate.getForObject("http://localhost:8081/Address",String.class);
        return "Name: Alex , Age:30 "+address;
    }

    @GetMapping("/getEmployees/{id}")
    public ResponseEntity<ResponseEmployee> getEmployeesById(@PathVariable ("id") Long id){
        ResponseEmployee employeesById = employeeService.getEmployeesById(id);


        return ResponseEntity.status(HttpStatus.OK).body(employeesById);
    }

    @PostMapping("/saveEmployeesDetails")
    public EmployeeEntity saveEmployees(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.saveEmployees(employeeEntity);
    }

    //    @PostMapping("/save")
//    public Don createDon(@RequestBody Don don) {
//        System.out.println(don);
//        return donService.createDon(don);


}
