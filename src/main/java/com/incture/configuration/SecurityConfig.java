package com.incture.configuration;

import com.incture.service.UserPermissionEvaluator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan(basePackageClasses = UserPermissionEvaluator.class)
//@ComponentScan(basePackages = "com.incture")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/getCustomerDetails").access("@userPermissionEvaluator.hasPermission(null,null,T(com.incture.reposotory.UserRepository).ROLE_USER_ADMIN)");

		 System.out.println("Inside config");
    }


}
