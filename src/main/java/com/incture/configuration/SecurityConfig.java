package com.incture.configuration;

import com.sap.cloud.security.xsuaa.XsuaaServiceConfiguration;
import com.sap.cloud.security.xsuaa.XsuaaServiceConfigurationDefault;
import com.sap.cloud.security.xsuaa.token.TokenAuthenticationConverter;
import com.sap.cloud.security.xsuaa.token.authentication.XsuaaJwtDecoderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

@EnableWebSecurity
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled=true)
@ComponentScan(basePackages = {"com.incture"})
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private XsuaaServiceConfiguration xsuaaServiceConfiguration;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().authorizeRequests()
//		http.csrf().disable().authorizeRequests()
//				.antMatchers("/getCustomerDetails").access("@userPermissionEvaluator.hasPermission(null,null,T(com.incture.reposotory.UserRepository).ROLE_USER_ADMIN)");
				.antMatchers("/getCustomerDetail").hasAuthority("YardDisplay1")
				.and()
				.oauth2ResourceServer()
				.jwt()
				.jwtAuthenticationConverter(getJwtAuthoritiesConverter());
		 System.out.println("Inside config");
    }

	private Converter<Jwt, AbstractAuthenticationToken> getJwtAuthoritiesConverter() {
		System.out.println("Inside config1");
		TokenAuthenticationConverter converter = new TokenAuthenticationConverter(xsuaaServiceConfiguration);
		System.out.println("Inside config2");
		converter.setLocalScopeAsAuthorities(true);
		return converter;
	}

	@Bean
	JwtDecoder jwtDecoder() {
		return new XsuaaJwtDecoderBuilder(xsuaaServiceConfiguration).build();
	}

	@Bean
	XsuaaServiceConfigurationDefault xsuaaConfig() {
		return new XsuaaServiceConfigurationDefault();
	}

}
