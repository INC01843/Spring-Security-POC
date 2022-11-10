package com.incture.service;

import com.incture.dto.CustomerDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class CustomerService {
    public ArrayList<CustomerDto> getCustomerDetails() {
        ArrayList<CustomerDto> customerDetails = new ArrayList<CustomerDto>();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerId("12345");
        customerDto.setCustomerName("Incture");
        customerDto.setAddress("123ABC");
        customerDto.setStatus("In Progress");
        customerDetails.add(customerDto);
//        customerDetails.put("1",customerDto);

        return customerDetails;
    }
}
