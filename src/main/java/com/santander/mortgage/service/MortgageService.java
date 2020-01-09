package com.santander.mortgage.service;

import java.util.List;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.MortgageOptionsResponseDto;

public interface MortgageService {

	//public ConfirmMortgageResponseDto confirmMortgage() ;

	public ConfirmMortgageResponseDto confirmMortgage(Long userId); 
	
	public List<MortgageOptionsResponseDto> mortgageOptions();
	
}
