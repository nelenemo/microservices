package com.example.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients//help you to scan your FeignClients and generate an implementation during run time
                   // (basePackages = "com.example.employee.feignclient")
                    //incase base package not provided, all your packages will be scanned and classes with @feignClient will be proxied
public class EmployeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeApplication.class, args);
    }

}
