package com.incture.service;

import com.incture.reposotory.UserRepository;
import com.sap.cloud.security.xsuaa.token.SpringSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Component
public class getUserDetails {

   private ArrayList<String> getUserDetails() {
        ArrayList<String> userDetailsList = new ArrayList<String>();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        userDetailsList.add(username);

        return userDetailsList;
    }
}
