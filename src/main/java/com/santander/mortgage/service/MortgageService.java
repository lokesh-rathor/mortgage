package com.santander.mortgage.service;


import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.ConfirmMortgageResponseDto;

public interface MortgageService {
	
	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto) ;

	//public ConfirmMortgageResponseDto confirmMortgage() ;

	public ConfirmMortgageResponseDto confirmMortgage(Long userId);

	
}
