package com.santander.mortgage.service;

import java.util.List;

import com.santander.mortgage.dto.ConfirmMortgageResponseDto;
import com.santander.mortgage.dto.MortgageOptionsResponseDto;
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;


public interface MortgageService {

	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto);

	// public PropertyDetailsDto confirmMortgage(Long userId);

	public ConfirmMortgageResponseDto confirmMortgage(Long userId);

	public List<MortgageOptionsResponseDto> mortgageOptions();
	
	public PaymentDetailsResponseDto updatePaymentDetails(PaymentDetailsRequestDto paymentDetailsRequestDto);

}
