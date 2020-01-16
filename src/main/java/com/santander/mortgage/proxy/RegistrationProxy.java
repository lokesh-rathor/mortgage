package com.santander.mortgage.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.santander.mortgage.dto.UserRegistration;

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="zuul-api-gateway-server")  
public interface RegistrationProxy {
	
	@GetMapping("/user-registration-service/users/say-hello")
	public String sayHello();
	
	@GetMapping("/user-registration-service/users/details/{userId}")
	public ResponseEntity<UserRegistration> getUserDetails(@PathVariable("userId") Long userId);

}
