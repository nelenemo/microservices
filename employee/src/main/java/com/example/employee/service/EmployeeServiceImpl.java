package com.example.employee.service;

import com.example.employee.dto.AddressResponse;
import com.example.employee.dto.ResponseEmployee;
import com.example.employee.entity.EmployeeEntity;
import com.example.employee.repo.EmployeesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeesRepo employeesRepo;
    @Autowired
    private WebClient webClient;

    public EmployeeServiceImpl(EmployeesRepo employeesRepo, ModelMapper modelMapper, RestTemplate restTemplate) {
        this.employeesRepo = employeesRepo;
        this.modelMapper = modelMapper;
        this.restTemplate = restTemplate;
    }

    //@Value("${addressserviceimpl.base.url}")
//private String addressBaseURL;
    private final ModelMapper modelMapper;

    //   public EmployeeServiceImpl(EmployeesRepo employeesRepo, ModelMapper modelMapper, RestTemplateBuilder builder, RestTemplate restTemplate){
//       this.employeesRepo = employeesRepo;
//       this.modelMapper = modelMapper;
////       this.restTemplate=builder
////               .rootUri(addressBaseURL)
////               .build();
//
//       this.restTemplate = restTemplate;
//   }
    private final RestTemplate restTemplate;

    @Override
    public ResponseEmployee getEmployeesById(Long id) {

        EmployeeEntity employeeEntity = employeesRepo.findById(id).get();
//        ResponseEmployee responseEmployee=new ResponseEmployee();
//        responseEmployee.setId(employeeEntity.getId());
//        responseEmployee.setName(employeeEntity.getName());
//        responseEmployee.setEmail(employe eEntity.getEmail());
//        responseEmployee.setBloodGroup(employeeEntity.getBloodGroup());

        ResponseEmployee responseEmployee = modelMapper.map(employeeEntity, ResponseEmployee.class);
        //  AddressResponse addressResponse = restTemplate.getForObject("http://localhost:8081/Address/{id}", AddressResponse.class, id);
        AddressResponse addressResponse = webClient
                .get()
                .uri("http://localhost:8081/Address/{id}"+ id)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
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

