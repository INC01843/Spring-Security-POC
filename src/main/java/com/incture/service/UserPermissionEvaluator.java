package com.incture.service;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.incture.reposotory.UserRepository;

@Component
//@ComponentScan(basePackages = "com.sap.security.um.user")
public class UserPermissionEvaluator implements PermissionEvaluator {

	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
		// TODO Auto-generated method stub
		System.out.println("inside haspermission1:::"+permission);
				return false;

	}

	public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType,
			Object permission) {
		// TODO Auto-generated method stub
		System.out.println("inside haspermission2:::"+hasPermission(targetType));
				return hasPermission(targetType);
//			return false;
		
	}

	private boolean hasPermission(String targetType) {
		
		UserRepository repo = new UserRepository();
//		repo.ALL_ROLES.stream().toArray();
		ArrayList<String> rolesCust = new ArrayList<String>();
		rolesCust.add("premiFri");
		rolesCust.add("log");
		
		if(targetType.equals("isPr")){
//			System.out.println(repo.ALL_ROLES.stream().anyMatch(r -> 
//				r.getRoleName().equals("logman")
//			));
//			for (String rol : rolesCust) {
//				if(repo.ALL_ROLES.stream().anyMatch(r -> r.getRoleName().equals(rol))) {
//					return true;
//				};
//			}
			
		}
		
		return true;
		
	}
}
