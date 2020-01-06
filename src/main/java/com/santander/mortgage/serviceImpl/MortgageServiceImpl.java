package com.santander.mortgage.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.model.PropertyDetails;
import com.santander.mortgage.repository.MortgageRepository;
import com.santander.mortgage.service.MortgageService;

@Service
public class MortgageServiceImpl implements MortgageService{
	
	@Autowired
	private MortgageRepository mortgageRepository;
	

	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto) {
		
		PropertyDetails propertyDetails = new PropertyDetails();
		propertyDetails.setUserId(mortgageRequestDto.getUserId());
		propertyDetails.setPropertyAddress(mortgageRequestDto.getPropertyAddress());
		propertyDetails.setPropertyType(mortgageRequestDto.getPropertyType());
		propertyDetails.setNumberOfBedrooms(mortgageRequestDto.getNumberOfBedrooms());
		propertyDetails.setPropertyBuilt(mortgageRequestDto.getPropertyBuilt());
		propertyDetails.setPropertyAge(mortgageRequestDto.getPropertyAge());
		propertyDetails.setIsPropertyCovered(mortgageRequestDto.getIsPropertyCovered());
		propertyDetails.setTenureType(mortgageRequestDto.getTenureType());
		
		propertyDetails=mortgageRepository.save(propertyDetails);
		
		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();
		mortgageResponseDto.setUserId(propertyDetails.getUserId().intValue());
		mortgageResponseDto.setMessage("Property Details saved successfully");
		
		return mortgageResponseDto;
	}


}
