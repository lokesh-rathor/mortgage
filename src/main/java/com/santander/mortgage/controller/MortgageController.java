package com.santander.mortgage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
