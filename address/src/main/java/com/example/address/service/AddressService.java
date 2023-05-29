package com.example.address.service;

import com.example.address.dto.AddressResponse;

public interface AddressService {

    AddressResponse getAddressByEmployeeId(int employeeId);
}
