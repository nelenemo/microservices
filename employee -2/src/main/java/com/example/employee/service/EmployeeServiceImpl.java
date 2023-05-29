package com.example.employee.service;

import com.example.employee.dto.AddressResponse;
import com.example.employee.dto.ResponseEmployee;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.feignclient.AddressClient;
import com.example.employee.repo.EmployeesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeesRepo employeesRepo;
    @Autowired
    private AddressClient addressClient;


    public EmployeeServiceImpl(EmployeesRepo employeesRepo, ModelMapper modelMapper) {
        this.employeesRepo = employeesRepo;
        this.modelMapper = modelMapper;

    }


    private final ModelMapper modelMapper;


    @Override
    public ResponseEmployee getEmployeesById(int id) {

        EmployeeEntity employeeEntity = employeesRepo.findById(id).get();
//        ResponseEmployee responseEmployee=new ResponseEmployee();
//        responseEmployee.setId(employeeEntity.getId());
//        responseEmployee.setName(employeeEntity.getName());
//        responseEmployee.setEmail(employe eEntity.getEmail());
//        responseEmployee.setBloodGroup(employeeEntity.getBloodGroup());

        ResponseEmployee responseEmployee = modelMapper.map(employeeEntity, ResponseEmployee.class);
        AddressResponse addressResponse = addressClient.getAddressByEmployeeId(id);
        responseEmployee.setAddressResponse(addressResponse);


        return responseEmployee;
    }


    @Override
    public EmployeeEntity saveEmployees(EmployeeEntity employeeEntity) {
        return employeesRepo.save(employeeEntity);
    }
}

//    //db call -> employee 1
//    EmployeeEntity employeeEntity = employeesRepo.findById(id).get();
//        return employeeEntity;

