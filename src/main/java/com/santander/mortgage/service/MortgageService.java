package com.santander.mortgage.service;



import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;

public interface MortgageService {
	
	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto) ;


	public PropertyDetailsDto confirmMortgage(Long userId);

	
}
