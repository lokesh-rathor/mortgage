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

import com.santander.mortgage.service.MortgageService;

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
	
}
