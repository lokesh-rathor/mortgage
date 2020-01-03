package com.santander.mortgage.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="zuul-api-gateway-server")
@RibbonClient(name="zuul-api-gateway-server")  
public interface RegistrationProxy {
	
	@GetMapping("/user-registration-service/users/say-hello")
	public String sayHello();

}
