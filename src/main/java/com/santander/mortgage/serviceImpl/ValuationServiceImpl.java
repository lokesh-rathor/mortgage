package com.santander.mortgage.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.model.Valuation;
import com.santander.mortgage.repository.ValuationRepository;
import com.santander.mortgage.service.ValuationService;

@Service
public class ValuationServiceImpl implements ValuationService {
	
	@Autowired
	private ValuationRepository valuationRespository;

	@Override
	public ValuationResponseDto postValuation(ValuationRequestDto valuationRequestDto) {
		
		Valuation valuation = new Valuation();
		valuation.setContactName(valuationRequestDto.getContactName());
		valuation.setContactNumber(valuationRequestDto.getContactNumber());
		valuation.setContactPerson(valuationRequestDto.getContactPerson());
		valuation.setIsPropertyInScotland(valuationRequestDto.getIsPropertyInScotland());
		
		valuation = valuationRespository.save(valuation);
		
		ValuationResponseDto valuationResponseDto = new ValuationResponseDto();
		valuationResponseDto.setUserId(valuation.getUserId());
		valuationResponseDto.setMessage("Valuation details added");
		
		return valuationResponseDto;
	}

	
	
}
