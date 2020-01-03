package com.santander.mortgage.service;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;

public interface MortgageService {

	//public ConfirmMortgageResponseDto confirmMortgage() ;

	public ConfirmMortgageResponseDto confirmMortgage(Long userId);
	
}
