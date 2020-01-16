package com.santander.mortgage.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.exception.UserNotFoundException;
import com.santander.mortgage.model.ConfirmMortgageDetails;
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

//	ResponseEntity<UserRegistration> user = registrationProxy.getUserDetails(paymentDetailsRequestDto.getUserId());
//
//	PaymentDetails payment = new PaymentDetails();
//	payment.setUser(user.getBody());
//	payment.setSortCode(paymentDetailsRequestDto.getSortCode());
//	payment.setAccountHolderName(paymentDetailsRequestDto.getAccountHolderName());
//	payment.setAccountNumber(paymentDetailsRequestDto.getAccountNumber());
//	payment.setCurrentcircumstances(paymentDetailsRequestDto.getCurrentCircumstances());
//	payment.setDayOfPayment(paymentDetailsRequestDto.getDayOfPayment());
//	PaymentDetails paymentDetails = paymentDetailsRepository.save(payment);
//
//	PaymentDetailsResponseDto paymentDetailsResponseDto = new PaymentDetailsResponseDto();
//	paymentDetailsResponseDto.setMessage("payment done Successfully");
//	paymentDetailsResponseDto.setUserId(paymentDetails.getUser().getUserId());
//
//	return paymentDetailsResponseDto;
//}
//	@Override
//	public List<String> getValuation(Long userId) {
//		ResponseEntity<Valuation> 	 valuation = valuationRespository.findByUserId(userId);
//		if (valuation == null) {
//			throw new UserNotFoundException("User not found");
//		}
//		
//		List<String> valuationList = new ArrayList<>();
//		ValuationResponseDto valuationResponseDto = new ValuationResponseDto();
//		valuationResponseDto.setUserId(valuation.getUserId());
//	
//		
//		ValuationRequestDto valuationRequestDto = new ValuationRequestDto();
//		
//		valuationRequestDto.setContactName(valuation.getContactName());
//		valuationRequestDto.setContactNumber(valuation.getContactNumber());
//		valuationRequestDto.setContactPerson(valuation.getContactPerson());
//		valuationRequestDto.setIsPropertyInScotland(valuation.getIsPropertyInScotland());
//		
//		Valuation valuation1 = mergeObjects(valuationResponseDto, valuationRequestDto);
//		valuationList.add("ValuationResponseDto");
//		
//		valuationList.add("valuationRequestDto");
//		
//		return valuationList;
//	}



	@Override
	public ValuationRequestDto getValuation(Long userId) {
		Valuation valuation = valuationRespository.getValuation(userId);
		if (valuation == null) {
			throw new UserNotFoundException("User not found");
		}
		
		ValuationRequestDto valuationRequestDto = new ValuationRequestDto();
		valuationRequestDto.setContactName(valuationRequestDto.getContactName());
		valuationRequestDto.setContactName(valuationRequestDto.getContactPerson());
		valuationRequestDto.setContactNumber(valuationRequestDto.getContactNumber());
		valuationRequestDto.setIsPropertyInScotland(valuationRequestDto.getIsPropertyInScotland());
		return valuationRequestDto;
     
	}

	
	
}
