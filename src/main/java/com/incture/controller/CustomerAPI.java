package com.incture.controller;

import com.incture.dto.CustomerDto;
import com.incture.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class CustomerAPI {

    //	@PreAuthorize("hasPermission(null,T(com.sap.security.Repository.UserRoleRepository).YARD_ADMIN_DENTON)")
    @GetMapping("/getCustomerDetails")
    public String getCustomerDetails() {

//        ArrayList<CustomerDto> customerDetails = customerService.getCustomerDetails();
        return "successfully called";
    }
}
