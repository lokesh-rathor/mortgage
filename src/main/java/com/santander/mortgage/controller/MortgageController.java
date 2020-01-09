package com.santander.mortgage.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.service.MortgageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.proxy.RegistrationProxy;
import com.santander.mortgage.service.ValuationService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MortgageController {

	@Autowired
	private MortgageService mortgageService;
	

	@PostMapping("/propertyDetails")
	public ResponseEntity<MortgageResponseDto> mortgage(
			@RequestBody MortgageRequestDto mortgageRequestDto) {
		MortgageResponseDto mortgageResponseDto=mortgageService.savePropertyDetails(mortgageRequestDto);
		return new ResponseEntity<>(mortgageResponseDto, HttpStatus.OK);
	
	}
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
	

	
//	@Autowired
//	private RegistrationProxy proxy;
	
	@Autowired
	private ValuationService valuationService;
	
	/*
	 * @GetMapping("get-data") public String getData() { return proxy.sayHello(); }
	 */
//	
//	@GetMapping("valuation")
//	public String getValuation() {
//		return proxy.sayHi();
//	}
//	
	
	
	@PostMapping("/valuation")
	ResponseEntity<ValuationResponseDto> postValuation(
			@RequestBody ValuationRequestDto valuationRequestDto) {

		ValuationResponseDto valuationResponseDto=valuationService.postValuation(valuationRequestDto);
		
		return new ResponseEntity<>(valuationResponseDto, HttpStatus.OK);

	}
	
	
}
