package com.example.address.service;

import com.example.address.dto.AddressResponse;
import com.example.address.entity.AddressEntity;
import com.example.address.repo.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{



    private final AddressRepo addressRepo;

    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper modelMapper) {


        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }
    private final ModelMapper modelMapper;


    @Override
    public AddressResponse getAddressByEmployeeId(int employeeId) {
        AddressEntity addressEntity= addressRepo.findAddressByEmployeeAddress(employeeId);
        AddressResponse map = modelMapper.map(addressEntity, AddressResponse.class);
        return map;
    }
}
