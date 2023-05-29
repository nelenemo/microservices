package com.example.employee.feignclient;

import com.example.employee.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//http://localhost:8081/Address/1
@FeignClient(name = "abc", url="http://localhost:8081")
public interface AddressClient {//proxy
    @GetMapping  ("/Address/{id}")
    AddressResponse getAddressByEmployeeId(@PathVariable ("id") int id);
}
