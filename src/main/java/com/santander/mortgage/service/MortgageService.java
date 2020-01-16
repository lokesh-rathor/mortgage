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

public interface MortgageService {

	public MortgageResponseDto savePropertyDetails(MortgageRequestDto mortgageRequestDto);

	public ConfirmMortgageResponseDto confirmMortgage(Long userId);

	public List<MortgageOptionsResponseDto> mortgageOptions();
	
	public PropertyDetailsDto getPropertyDetailsById(Long userId);
	
	public PaymentDetailsResponseDto updatePaymentDetails(PaymentDetailsRequestDto paymentDetailsRequestDto);
	
	public GetPaymentDetailResponseDto getPaymentDetailsById(Long userId) ;

}
