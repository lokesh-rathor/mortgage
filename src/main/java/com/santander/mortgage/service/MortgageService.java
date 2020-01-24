package com.santander.mortgage.service;

import java.util.List;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.GetPaymentDetailResponseDto;
import com.santander.mortgage.dto.MortgageOptionsResponseDto;
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;

public interface MortgageService {

	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto);
	
	public MortgageResponseDto updatePropertyDetails(MortgageRequestDto mortgageRequestDto);

	public ConfirmMortgageResponseDto confirmMortgage(Long userId);

	public List<MortgageOptionsResponseDto> mortgageOptions();
	

	
	public List<PropertyDetailsDto> getPropertyDetailsById(Long userId); 
	
	public PaymentDetailsResponseDto savePaymentDetails(PaymentDetailsRequestDto paymentDetailsRequestDto);
	
	public PaymentDetailsResponseDto updatePaymentDetails(PaymentDetailsRequestDto paymentDetailsRequestDto);
	
	
	public List<GetPaymentDetailResponseDto> getPaymentDetailsById(Long userId) ;
	

	public ValuationResponseDto postValuation(ValuationRequestDto valuationRequestDto);

	
	public List<ValuationRequestDto> getValuation(Long userId);

}
