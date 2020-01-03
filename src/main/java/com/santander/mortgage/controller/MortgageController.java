package com.santander.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.mortgage.proxy.RegistrationProxy;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MortgageController {

	
	@Autowired
	private RegistrationProxy proxy;
	
	@GetMapping("get-data")
	public String getData() {
		return proxy.sayHello();
	}
	
}
