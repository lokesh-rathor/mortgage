package com.santander.mortgage.service;

import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;

public interface ValuationService {
	
	public ValuationResponseDto postValuation(ValuationRequestDto valuationRequestDto);
	
	

}
