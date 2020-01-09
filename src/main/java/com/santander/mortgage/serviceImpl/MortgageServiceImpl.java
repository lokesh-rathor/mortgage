package com.santander.mortgage.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;
import com.santander.mortgage.model.PropertyDetails;
import com.santander.mortgage.repository.ConfirmMortgageRepository;
import com.santander.mortgage.repository.PropertyDetailsRepository;
import com.santander.mortgage.service.MortgageService;

@Service
public class MortgageServiceImpl implements MortgageService{
	
	@Autowired
	private PropertyDetailsRepository propertyDetailsRepository;
	

	@Autowired
	private ConfirmMortgageRepository confirmMortgageRepository;

	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto) {
		
		PropertyDetails propertyDetails = new PropertyDetails();
		propertyDetails.setPropertyAddress(mortgageRequestDto.getPropertyAddress());
		propertyDetails.setPropertyType(mortgageRequestDto.getPropertyType());
		propertyDetails.setNumberOfBedrooms(mortgageRequestDto.getNumberOfBedrooms());
		propertyDetails.setPropertyBuilt(mortgageRequestDto.getPropertyBuilt());
		propertyDetails.setPropertyAge(mortgageRequestDto.getPropertyAge());
		propertyDetails.setIsPropertyCovered(mortgageRequestDto.getIsPropertyCovered());
		propertyDetails.setTenureType(mortgageRequestDto.getTenureType());
		
		propertyDetails=propertyDetailsRepository.save(propertyDetails);
		
		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();
		mortgageResponseDto.setUserId(propertyDetails.getUserId().intValue());
		mortgageResponseDto.setMessage("Property Details saved successfully");
		
		return mortgageResponseDto;
	}




	@Override
	public PropertyDetailsDto confirmMortgage(Long userId) {
		PropertyDetails properDetails = propertyDetailsRepository.findByUserId(userId);
//		ConfirmMortgageResponseDto confirmMortgageResponseDto = new ConfirmMortgageResponseDto();
//		
//		confirmMortgageResponseDto.setBorrowingAmount(confirmMortgageDetails.getBorrowingAmount());
//		confirmMortgageResponseDto.setBuyerType(confirmMortgageDetails.getBuyerType());
//		confirmMortgageResponseDto.setEstimatedPropertyValue(confirmMortgageDetails.getEstimatedPropertyValue());
//		confirmMortgageResponseDto.setFollowOnRate(confirmMortgageDetails.getFollowOnRate());
//		confirmMortgageResponseDto.setLoanToValue(confirmMortgageDetails.getLoanToValue());
//		confirmMortgageResponseDto.setMortgageTerm(confirmMortgageDetails.getMortgageTerm());
//		confirmMortgageResponseDto.setProductFeeAddedToLoanAmt(confirmMortgageDetails.getProductFeeAddedToLoanAmt());
//		confirmMortgageResponseDto.setRateFinishedDate(confirmMortgageDetails.getRateFinishedDate());
//		confirmMortgageResponseDto.setRepaymentMethod(confirmMortgageDetails.getRepaymentMethod());
//		return confirmMortgageResponseDto;
//		
		
		PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
		
		propertyDetailsDto.setUserId(properDetails.getUserId());
		propertyDetailsDto.setPropertyAddress(properDetails.getPropertyAddress());
		propertyDetailsDto.setPropertyType(properDetails.getPropertyType());
		propertyDetailsDto.setNumberOfBedrooms(properDetails.getNumberOfBedrooms());
		propertyDetailsDto.setPropertyBuilt(properDetails.getPropertyBuilt());
		propertyDetailsDto.setPropertyAge(properDetails.getPropertyAge());
		propertyDetailsDto.setIsPropertyCovered(properDetails.getIsPropertyCovered());
		propertyDetailsDto.setTenureType(properDetails.getTenureType());
		return propertyDetailsDto;
	}
	
	}


