package com.incture.controller;

import com.incture.dto.CustomerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CustomerAPI {
    //	@PreAuthorize("hasPermission(null,T(com.sap.security.Repository.UserRoleRepository).YARD_ADMIN_DENTON)")
    @GetMapping("/getCustomerDetails")
    public HashMap<String,CustomerDto> getCustomerDetails() {
        return null;
    }
}
