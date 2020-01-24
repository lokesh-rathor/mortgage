package com.santander.mortgage.service;

import java.util.List;

import com.santander.mortgage.dto.ValuationRequestDto;

public interface ValuationService {
	
	public ValuationRequestDto postValuation(ValuationRequestDto valuationRequestDto);

	public List<ValuationRequestDto> getValuation(Long userId);

	/* public List<ValuationRequestDto> findAll(); */


	
	

}