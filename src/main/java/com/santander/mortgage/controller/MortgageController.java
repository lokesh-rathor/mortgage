package com.santander.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.service.MortgageService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MortgageController {

	
	
	@Autowired
	private MortgageService mortgageService;
	
//	@GetMapping("get-data")
//	public String getData() {
//		return proxy.sayHello();
//	}
	
	@GetMapping("/confirmMortgage/{userId}")
	public ResponseEntity<ConfirmMortgageResponseDto> confirmMortgage(@PathVariable("userId") Long userId){
		
			ConfirmMortgageResponseDto confirmMortgageResponseDto =  mortgageService.confirmMortgage(userId);
		
		return new ResponseEntity<>(confirmMortgageResponseDto, HttpStatus.OK);
		}

	}
	

