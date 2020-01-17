package com.santander.mortgage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.santander.mortgage.controller.MortgageController;
import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.GetPaymentDetailResponseDto;
import com.santander.mortgage.dto.MortgageOptionsResponseDto;
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;
import com.santander.mortgage.dto.UserRegistration;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.exception.PaymentDetailsNotFoundException;
import com.santander.mortgage.exception.UserNotFoundException;
import com.santander.mortgage.model.ConfirmMortgageDetails;
import com.santander.mortgage.model.MortgageOptionsDetail;
import com.santander.mortgage.model.PaymentDetails;
import com.santander.mortgage.model.PropertyDetails;
import com.santander.mortgage.model.Valuation;
import com.santander.mortgage.proxy.RegistrationProxy;
import com.santander.mortgage.repository.ConfirmMortgageRepository;
import com.santander.mortgage.repository.MortgageOptionsRepository;
import com.santander.mortgage.repository.PaymentDetailsRepository;
import com.santander.mortgage.repository.PropertyDetailsRepository;
import com.santander.mortgage.repository.ValuationRepository;
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
	
	@Autowired
	private ValuationRepository valuationRespository;
	
	private static final Logger logger = LoggerFactory.getLogger(MortgageServiceImpl.class);

	@Override
	 @Cacheable(value="mortgageConfirmCache")
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

	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto) {

		PropertyDetails propertyDetails = propertyDetailsRepository.findByUserId(mortgageRequestDto.getUserId());

		if (propertyDetails == null) {
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
			propertyDetails = propertyDetailsRepository.save(propertyDetail);

		} else {
			propertyDetails.setPropertyAddress(mortgageRequestDto.getPropertyAddress());
			propertyDetails.setPropertyType(mortgageRequestDto.getPropertyType());
			propertyDetails.setNumberOfBedrooms(mortgageRequestDto.getNumberOfBedrooms());
			propertyDetails.setPropertyBuilt(mortgageRequestDto.getPropertyBuilt());
			propertyDetails.setPropertyAge(mortgageRequestDto.getPropertyAge());
			propertyDetails.setIsPropertyCovered(mortgageRequestDto.getIsPropertyCovered());
			propertyDetails.setTenureType(mortgageRequestDto.getTenureType());
			propertyDetails.setPostCode(mortgageRequestDto.getPostCode());
			propertyDetails = propertyDetailsRepository.save(propertyDetails);

		}
		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();
		mortgageResponseDto.setUserId(propertyDetails.getUserId().intValue());
		mortgageResponseDto.setMessage("Property Details saved successfully");

		return mortgageResponseDto;

	}

	@Override
	@Cacheable(value="mortgageOptionsCache")
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
	@Cacheable(value = "mortgagePropertyCache")
	public PropertyDetailsDto getPropertyDetailsById(Long userId) {
		PropertyDetails propertyDetails = propertyDetailsRepository.findByUserId(userId);
		PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();

		System.out.println("In get property");
		propertyDetailsDto.setUserId(propertyDetails.getUserId());
		propertyDetailsDto.setPostCode(propertyDetails.getPostCode());
		propertyDetailsDto.setPropertyId(propertyDetails.getPropertyId());
		propertyDetailsDto.setPropertyAddress(propertyDetails.getPropertyAddress());
		propertyDetailsDto.setPropertyType(propertyDetails.getPropertyType());
		propertyDetailsDto.setNumberOfBedrooms(propertyDetails.getNumberOfBedrooms());
		propertyDetailsDto.setPropertyBuilt(propertyDetails.getPropertyBuilt());
		propertyDetailsDto.setPropertyAge(propertyDetails.getPropertyAge());
		propertyDetailsDto.setIsPropertyCovered(propertyDetails.getIsPropertyCovered());
		propertyDetailsDto.setTenureType(propertyDetails.getTenureType());

		return propertyDetailsDto;
	}

	@Override
	public PaymentDetailsResponseDto updatePaymentDetails(PaymentDetailsRequestDto paymentDetailsRequestDto) {
		ResponseEntity<UserRegistration> user = registrationProxy.getUserDetails(paymentDetailsRequestDto.getUserId());
		PaymentDetails paymentDetailsResponse = paymentDetailsRepository.findByUserId(user.getBody().getUserId());
		PaymentDetails payment = new PaymentDetails();
		if (paymentDetailsResponse != null) {
			payment.setPaymentId(paymentDetailsResponse.getPaymentId());
		}
		payment.setUserId(user.getBody().getUserId());
		payment.setSortCode(paymentDetailsRequestDto.getSortCode());
		payment.setAccountHolderName(paymentDetailsRequestDto.getAccountHolderName());
		payment.setAccountNumber(paymentDetailsRequestDto.getAccountNumber());
		payment.setCurrentcircumstances(paymentDetailsRequestDto.getCurrentCircumstances());
		payment.setDayOfPayment(paymentDetailsRequestDto.getDayOfPayment());
		PaymentDetails paymentDetails = paymentDetailsRepository.save(payment);

		PaymentDetailsResponseDto paymentDetailsResponseDto = new PaymentDetailsResponseDto();
		paymentDetailsResponseDto.setMessage("payment done Successfully");
		paymentDetailsResponseDto.setUserId(paymentDetails.getUserId());

		return paymentDetailsResponseDto;

	}

	@Override
	@Cacheable(value = "mortgagePaymentCache")//, key = "T(java.util.Objects).hash(#p0,#p1, #p2)")
	public GetPaymentDetailResponseDto getPaymentDetailsById(Long userId) {
		PaymentDetails paymentDetailResponseDto = paymentDetailsRepository.findByUserId(userId);
		if (paymentDetailResponseDto == null) {
			throw new PaymentDetailsNotFoundException("Payment details not found.");
		}
		GetPaymentDetailResponseDto getPaymentDetailResponseDto = new GetPaymentDetailResponseDto();
		getPaymentDetailResponseDto.setPaymentId(paymentDetailResponseDto.getPaymentId());
		getPaymentDetailResponseDto.setAccountHolderName(paymentDetailResponseDto.getAccountHolderName());
		getPaymentDetailResponseDto.setAccountNumber(paymentDetailResponseDto.getAccountNumber());
		getPaymentDetailResponseDto.setCurrentcircumstances(paymentDetailResponseDto.getCurrentcircumstances());
		getPaymentDetailResponseDto.setDayOfPayment(paymentDetailResponseDto.getDayOfPayment());
		getPaymentDetailResponseDto.setSortCode(paymentDetailResponseDto.getSortCode());

		return getPaymentDetailResponseDto;

	}
	
	

	@Override
	public ValuationResponseDto postValuation(ValuationRequestDto valuationRequestDto) {
		
		Valuation valuation = new Valuation();
		valuation.setContactName(valuationRequestDto.getContactName());
		valuation.setContactNumber(valuationRequestDto.getContactNumber());
		valuation.setContactPerson(valuationRequestDto.getContactPerson());
		valuation.setIsPropertyInScotland(valuationRequestDto.getIsPropertyInScotland());
		valuation.setUserId(valuationRequestDto.getUserId());
		
		valuation = valuationRespository.save(valuation);
		
		ValuationResponseDto valuationResponseDto = new ValuationResponseDto();
		valuationResponseDto.setContactName(valuation.getContactName());
		valuationResponseDto.setContactPerson(valuation.getContactPerson());
		valuationResponseDto.setContactNumber(valuation.getContactNumber());
		valuationResponseDto.setIsPropertyInScotland(valuation.getIsPropertyInScotland());
		valuationResponseDto.setValuationId(valuation.getContactNumber());
		valuationResponseDto.setUserId(valuation.getUserId());
		valuationResponseDto.setMessage("Valuation details added");
		
		return valuationResponseDto;
	}
	
	@Override
	public ValuationResponseDto getValuation(Long userId) {
		Valuation valuation = valuationRespository.findByUserId(userId);
		if (valuation == null) {
			throw new UserNotFoundException("User not found");
		}
		
		ValuationResponseDto valuationResponseDto = new ValuationResponseDto();
		valuationResponseDto.setContactName(valuation.getContactName());
		valuationResponseDto.setContactPerson(valuation.getContactPerson());
		valuationResponseDto.setContactNumber(valuation.getContactNumber());
		valuationResponseDto.setIsPropertyInScotland(valuation.getIsPropertyInScotland());
		valuationResponseDto.setValuationId(valuation.getContactNumber());
		valuationResponseDto.setUserId(valuation.getUserId());
		
		return valuationResponseDto;
     
	}

}
