package com.santander.mortgage.proxy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.santander.mortgage.dto.UserRegistration;

@Component
public class UserClientFallback implements RegistrationProxy{

	@Override
	public String sayHello() {
		return "hello this is Feign ClIENT Fallback";
		
	}

	@Override
	public ResponseEntity<UserRegistration> getUserDetails(Long userId, String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
