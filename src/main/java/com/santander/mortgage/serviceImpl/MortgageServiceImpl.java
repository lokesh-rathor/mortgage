package com.santander.mortgage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.MortgageOptionsResponseDto;
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;
import com.santander.mortgage.exception.UserNotFoundException;
import com.santander.mortgage.model.ConfirmMortgageDetails;
import com.santander.mortgage.model.MortgageOptionsDetail;
import com.santander.mortgage.model.PaymentDetails;
import com.santander.mortgage.model.PropertyDetails;
import com.santander.mortgage.model.UserRegistration;
import com.santander.mortgage.proxy.RegistrationProxy;
import com.santander.mortgage.repository.ConfirmMortgageRepository;
import com.santander.mortgage.repository.MortgageOptionsRepository;
import com.santander.mortgage.repository.PaymentDetailsRepository;
import com.santander.mortgage.repository.PropertyDetailsRepository;
import com.santander.mortgage.service.MortgageService;

@Service
public class MortgageServiceImpl implements MortgageService {

	@Autowired
	private PropertyDetailsRepository propertyDetailsRepository;

	@Autowired
	private PaymentDetailsRepository paymentDetailsRepository;

	@Autowired
	private ConfirmMortgageRepository confirmMortgageRepository;

	@Autowired
	private MortgageOptionsRepository mortgageOptionsRepository;

	@Autowired
	private RegistrationProxy registrationProxy;

	@Override
	public ConfirmMortgageResponseDto confirmMortgage(Long userId) { 
		ConfirmMortgageDetails confirmMortgageDetails = confirmMortgageRepository.findByUserId(userId);
		if (confirmMortgageDetails == null) {
			throw new UserNotFoundException("User not found");
		}
		ConfirmMortgageResponseDto confirmMortgageResponseDto = new ConfirmMortgageResponseDto();

		confirmMortgageResponseDto.setBorrowingAmount(confirmMortgageDetails.getBorrowingAmount());
		confirmMortgageResponseDto.setBuyerType(confirmMortgageDetails.getBuyerType());
		confirmMortgageResponseDto.setEstimatedPropertyValue(confirmMortgageDetails.getEstimatedPropertyValue());
		confirmMortgageResponseDto.setFollowOnRate(confirmMortgageDetails.getFollowOnRate());
		confirmMortgageResponseDto.setLoanToValue(confirmMortgageDetails.getLoanToValue());
		confirmMortgageResponseDto.setMortgageTerm(confirmMortgageDetails.getMortgageTerm());
		confirmMortgageResponseDto.setProductFeeAddedToLoanAmt(confirmMortgageDetails.getProductFeeAddedToLoanAmt());
		confirmMortgageResponseDto.setRateFinishedDate(confirmMortgageDetails.getRateFinishedDate());
		confirmMortgageResponseDto.setRepaymentMethod(confirmMortgageDetails.getRepaymentMethod());
		confirmMortgageResponseDto.setInitialRate(confirmMortgageDetails.getInitialRate());
		confirmMortgageResponseDto.setProductFee(confirmMortgageDetails.getProductFee());
		confirmMortgageResponseDto.setMonthlyRepayment(confirmMortgageDetails.getMonthlyRepayment());

		return confirmMortgageResponseDto;
	}


	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto){
		
		PropertyDetails propertyDetails = propertyDetailsRepository.findByUserId(mortgageRequestDto.getUserId());
		
		if(propertyDetails == null) {
			PropertyDetails propertyDetail = new PropertyDetails();
			propertyDetail.setUserId(mortgageRequestDto.getUserId());
			propertyDetail.setPropertyAddress(mortgageRequestDto.getPropertyAddress());
			propertyDetail.setPropertyType(mortgageRequestDto.getPropertyType());
			propertyDetail.setNumberOfBedrooms(mortgageRequestDto.getNumberOfBedrooms());
			propertyDetail.setPropertyBuilt(mortgageRequestDto.getPropertyBuilt());
			propertyDetail.setPropertyAge(mortgageRequestDto.getPropertyAge());
			propertyDetail.setIsPropertyCovered(mortgageRequestDto.getIsPropertyCovered());
			propertyDetail.setTenureType(mortgageRequestDto.getTenureType());
			propertyDetail.setPostCode(mortgageRequestDto.getPostCode());
			propertyDetails=propertyDetailsRepository.save(propertyDetail);

		} else {
			propertyDetails.setPropertyAddress(mortgageRequestDto.getPropertyAddress());
			propertyDetails.setPropertyType(mortgageRequestDto.getPropertyType());
			propertyDetails.setNumberOfBedrooms(mortgageRequestDto.getNumberOfBedrooms());
			propertyDetails.setPropertyBuilt(mortgageRequestDto.getPropertyBuilt());
			propertyDetails.setPropertyAge(mortgageRequestDto.getPropertyAge());
			propertyDetails.setIsPropertyCovered(mortgageRequestDto.getIsPropertyCovered());
			propertyDetails.setTenureType(mortgageRequestDto.getTenureType());
			propertyDetails.setPostCode(mortgageRequestDto.getPostCode());
			propertyDetails=propertyDetailsRepository.save(propertyDetails);

		}
		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();
		mortgageResponseDto.setUserId(propertyDetails.getUserId().intValue());
		mortgageResponseDto.setMessage("Property Details saved successfully");

		return mortgageResponseDto;
		
	}

	/*
	 * @Override public PropertyDetailsDto confirmMortgage(Long userId) {
	 * PropertyDetails properDetails =
	 * propertyDetailsRepository.findByUserId(userId); // ConfirmMortgageResponseDto
	 * confirmMortgageResponseDto = new ConfirmMortgageResponseDto(); // //
	 * confirmMortgageResponseDto.setBorrowingAmount(confirmMortgageDetails.
	 * getBorrowingAmount()); //
	 * confirmMortgageResponseDto.setBuyerType(confirmMortgageDetails.getBuyerType()
	 * ); //
	 * confirmMortgageResponseDto.setEstimatedPropertyValue(confirmMortgageDetails.
	 * getEstimatedPropertyValue()); //
	 * confirmMortgageResponseDto.setFollowOnRate(confirmMortgageDetails.
	 * getFollowOnRate()); //
	 * confirmMortgageResponseDto.setLoanToValue(confirmMortgageDetails.
	 * getLoanToValue()); //
	 * confirmMortgageResponseDto.setMortgageTerm(confirmMortgageDetails.
	 * getMortgageTerm()); //
	 * confirmMortgageResponseDto.setProductFeeAddedToLoanAmt(confirmMortgageDetails
	 * .getProductFeeAddedToLoanAmt()); //
	 * confirmMortgageResponseDto.setRateFinishedDate(confirmMortgageDetails.
	 * getRateFinishedDate()); //
	 * confirmMortgageResponseDto.setRepaymentMethod(confirmMortgageDetails.
	 * getRepaymentMethod()); // return confirmMortgageResponseDto; //
	 * 
	 * PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
	 * 
	 * propertyDetailsDto.setUserId(properDetails.getUserId());
	 * propertyDetailsDto.setPropertyAddress(properDetails.getPropertyAddress());
	 * propertyDetailsDto.setPropertyType(properDetails.getPropertyType());
	 * propertyDetailsDto.setNumberOfBedrooms(properDetails.getNumberOfBedrooms());
	 * propertyDetailsDto.setPropertyBuilt(properDetails.getPropertyBuilt());
	 * propertyDetailsDto.setPropertyAge(properDetails.getPropertyAge());
	 * propertyDetailsDto.setIsPropertyCovered(properDetails.getIsPropertyCovered())
	 * ; propertyDetailsDto.setTenureType(properDetails.getTenureType()); return
	 * propertyDetailsDto; }
	 * 
	 * }
	 */

	@Override
	public List<MortgageOptionsResponseDto> mortgageOptions() {
		List<MortgageOptionsDetail> mortgageOptionsDetailList = mortgageOptionsRepository.findAll();
		List<MortgageOptionsResponseDto> mortgageOptionsResponseDtoList = mortgageOptionsDetailList.stream().map(e -> {
			MortgageOptionsResponseDto mortgageOptionsResponseDto = new MortgageOptionsResponseDto();
			mortgageOptionsResponseDto.setDescription(e.getDescription());
			mortgageOptionsResponseDto.setInitialRate(e.getInitialRate());
			mortgageOptionsResponseDto.setMonthlyRepayment(e.getMonthlyRepayment());
			mortgageOptionsResponseDto.setProductFee(e.getProductFee());
			return mortgageOptionsResponseDto;
		}).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		return mortgageOptionsResponseDtoList;
	}
	
	  @Override
	  public PropertyDetailsDto getPropertyDetailsById(Long userId) {
	  PropertyDetails propertyDetails = propertyDetailsRepository.findByUserId(userId);
	  PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
	  
	  System.out.println("In get property");
	  propertyDetailsDto.setUserId(propertyDetails.getUserId());
	  propertyDetailsDto.setPostCode(propertyDetails.getPostCode());
	  propertyDetailsDto.setPropertyId(propertyDetails.getPropertyId());
	  propertyDetailsDto.setPropertyAddress(propertyDetails.getPropertyAddress());
	  propertyDetailsDto.setPropertyType(propertyDetails.getPropertyType());
	  propertyDetailsDto.setNumberOfBedrooms(propertyDetails.getNumberOfBedrooms())
	  ; propertyDetailsDto.setPropertyBuilt(propertyDetails.getPropertyBuilt());
	  propertyDetailsDto.setPropertyAge(propertyDetails.getPropertyAge());
	  propertyDetailsDto.setIsPropertyCovered(propertyDetails.getIsPropertyCovered(
	  )); propertyDetailsDto.setTenureType(propertyDetails.getTenureType());
	  
	  return propertyDetailsDto; }

//		propertyDetailsDto.setUserId(propertyDetails.getUserId());
//		propertyDetailsDto.setPropertyId(propertyDetails.getPropertyId());
//		propertyDetailsDto.setPropertyAddress(propertyDetails.getPropertyAddress());
//		propertyDetailsDto.setPropertyType(propertyDetails.getPropertyType());
//		propertyDetailsDto.setNumberOfBedrooms(propertyDetails.getNumberOfBedrooms());
//		propertyDetailsDto.setPropertyBuilt(propertyDetails.getPropertyBuilt());
//		propertyDetailsDto.setPropertyAge(propertyDetails.getPropertyAge());
//		propertyDetailsDto.setIsPropertyCovered(propertyDetails.getIsPropertyCovered());
//		propertyDetailsDto.setTenureType(propertyDetails.getTenureType());
//
//		return propertyDetailsDto;
//	}


	@Override
	public PaymentDetailsResponseDto updatePaymentDetails(PaymentDetailsRequestDto paymentDetailsRequestDto) {

		ResponseEntity<UserRegistration> user = registrationProxy.getUserDetails(paymentDetailsRequestDto.getUserId());

		PaymentDetails payment = new PaymentDetails();
		payment.setUser(user.getBody());
		payment.setSortCode(paymentDetailsRequestDto.getSortCode());
		payment.setAccountHolderName(paymentDetailsRequestDto.getAccountHolderName());
		payment.setAccountNumber(paymentDetailsRequestDto.getAccountNumber());
		payment.setCurrentcircumstances(paymentDetailsRequestDto.getCurrentCircumstances());
		payment.setDayOfPayment(paymentDetailsRequestDto.getDayOfPayment());
		PaymentDetails paymentDetails = paymentDetailsRepository.save(payment);

		PaymentDetailsResponseDto paymentDetailsResponseDto = new PaymentDetailsResponseDto();
		paymentDetailsResponseDto.setMessage("payment done Successfully");
		paymentDetailsResponseDto.setUserId(paymentDetails.getUser().getUserId());

		return paymentDetailsResponseDto;
	}

}
