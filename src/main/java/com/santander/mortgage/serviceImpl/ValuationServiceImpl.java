package com.santander.mortgage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.exception.UserNotFoundException;
import com.santander.mortgage.model.Valuation;
import com.santander.mortgage.repository.ValuationRepository;
import com.santander.mortgage.service.ValuationService;

@Service
public class ValuationServiceImpl implements ValuationService {
	
	@Autowired
	private ValuationRepository valuationRespository;

	@Override
	public ValuationRequestDto postValuation(ValuationRequestDto valuationRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ValuationRequestDto> getValuation(Long userId) {
		Valuation valuation = valuationRespository.findByUserId(userId);
		if (valuation == null) {
			throw new UserNotFoundException("User not found");
		}
		

		List<ValuationRequestDto> valuationResponseDtoList=new ArrayList<ValuationRequestDto>();
		ValuationRequestDto valuationRequestDto = new ValuationRequestDto();
		valuationRequestDto.setContactName(valuation.getContactName());
		valuationRequestDto.setContactPerson(valuation.getContactPerson());
		valuationRequestDto.setContactNumber(valuation.getContactNumber());
		valuationRequestDto.setIsPropertyInScotland(valuation.getIsPropertyInScotland());
		valuationResponseDtoList.add(valuationRequestDto);
		return valuationResponseDtoList;
     
	}
	
	
	

}
