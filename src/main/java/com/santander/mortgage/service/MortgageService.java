package com.santander.mortgage.service;

import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;

public interface MortgageService {
	
	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto) ;
	
}
