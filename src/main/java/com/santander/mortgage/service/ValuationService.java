package com.santander.mortgage.service;

import java.util.List;

import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;

public interface ValuationService {
	
	public ValuationResponseDto postValuation(ValuationRequestDto valuationRequestDto);

	public ValuationRequestDto getValuation(Long userId);


	
	

}
