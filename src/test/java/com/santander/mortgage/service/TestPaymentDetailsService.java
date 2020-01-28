package com.santander.mortgage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santander.mortgage.dto.GetPaymentDetailResponseDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.dto.UserRegistration;
import com.santander.mortgage.exception.PaymentAlreadyDoneException;
import com.santander.mortgage.exception.PaymentDetailsNotFoundException;
import com.santander.mortgage.model.PaymentDetails;
import com.santander.mortgage.proxy.RegistrationProxy;
import com.santander.mortgage.repository.PaymentDetailsRepository;
import com.santander.mortgage.serviceImpl.MortgageServiceImpl;

@ExtendWith(SpringExtension.class)
class TestPaymentDetailsService {
	
	@InjectMocks
	private MortgageServiceImpl mortgageServiceImpl;
	
	@Mock
	private PaymentDetailsRepository paymentDetailsRepository;
	
	@Mock
	private RegistrationProxy registrationProxy;
	
	@Test
	void testSavePaymentDetails() {
		PaymentDetailsRequestDto paymentDetailsRequestDto = new PaymentDetailsRequestDto();
		paymentDetailsRequestDto.setUserId(1L);
		
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setUserId(1L);
		
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAccountHolderName("asdfaf");
		paymentDetails.setUserId(1L);
		
		Mockito.when(registrationProxy.getUserDetails(Mockito.any(Long.class))).thenReturn(new ResponseEntity<>(userRegistration,HttpStatus.OK));
		Mockito.when(paymentDetailsRepository.findByUserId(Mockito.any(Long.class))).thenReturn(null);
		
		Mockito.when(paymentDetailsRepository.save(Mockito.any(PaymentDetails.class))).thenReturn(paymentDetails);
		PaymentDetailsResponseDto paymentDetailsResponseDto=new PaymentDetailsResponseDto();
		paymentDetailsResponseDto.setMessage("payment done Successfully");
		paymentDetailsResponseDto.setUserId(1L);
		
		PaymentDetailsResponseDto paymentDetailsResponse = mortgageServiceImpl.savePaymentDetails(paymentDetailsRequestDto);
		
		assertEquals(paymentDetailsResponse.getUserId(),paymentDetailsResponseDto.getUserId());
	}
	
	@Test
	void testSavePaymentDetailsError() {
		PaymentDetailsRequestDto paymentDetailsRequestDto = new PaymentDetailsRequestDto();
		paymentDetailsRequestDto.setUserId(145L);
	
		Mockito.when(registrationProxy.getUserDetails(Mockito.any(Long.class))).thenThrow(RuntimeException.class);
		
		Assertions.assertThrows(RuntimeException.class, () -> mortgageServiceImpl.savePaymentDetails(paymentDetailsRequestDto));
	}
	
	@Test
	void testPaymentAlreadyDoneError() {
		PaymentDetailsRequestDto paymentDetailsRequestDto = new PaymentDetailsRequestDto();
		paymentDetailsRequestDto.setUserId(1L);
		
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setUserId(1L);
		
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAccountHolderName("asdfaf");
		paymentDetails.setUserId(1L);
		
		Mockito.when(registrationProxy.getUserDetails(Mockito.any(Long.class))).thenReturn(new ResponseEntity<>(userRegistration,HttpStatus.OK));
		Mockito.when(paymentDetailsRepository.findByUserId(Mockito.any(Long.class))).thenReturn(paymentDetails);
		
		Assertions.assertThrows(PaymentAlreadyDoneException.class, () -> mortgageServiceImpl.savePaymentDetails(paymentDetailsRequestDto));
	}
	
	@Test
	void testUpdatePaymentDetails() {
		PaymentDetailsRequestDto paymentDetailsRequestDto = new PaymentDetailsRequestDto();
		paymentDetailsRequestDto.setUserId(1L);
		
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setUserId(1L);
		
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAccountHolderName("Alex");
		paymentDetails.setUserId(1L);
		
		PaymentDetails newPaymentDetails = new PaymentDetails();
		newPaymentDetails.setAccountHolderName("Peter");
		newPaymentDetails.setUserId(1L);
		
		Mockito.when(registrationProxy.getUserDetails(Mockito.any(Long.class))).thenReturn(new ResponseEntity<>(userRegistration,HttpStatus.OK));
		Mockito.when(paymentDetailsRepository.findByUserId(Mockito.any(Long.class))).thenReturn(paymentDetails);
		Mockito.when(paymentDetailsRepository.save(Mockito.any(PaymentDetails.class))).thenReturn(newPaymentDetails);
		
		PaymentDetailsResponseDto paymentDetailsResponseDto=new PaymentDetailsResponseDto();
		paymentDetailsResponseDto.setMessage("payment updated Successfully");
		paymentDetailsResponseDto.setUserId(1L);
		
		PaymentDetailsResponseDto paymentDetailsResponse = mortgageServiceImpl.updatePaymentDetails(paymentDetailsRequestDto);
		
		assertEquals(paymentDetailsResponse.getUserId(),paymentDetailsResponseDto.getUserId());
	}
	
	@Test
	void testPaymentDetailNotFoundError() {
		PaymentDetailsRequestDto paymentDetailsRequestDto = new PaymentDetailsRequestDto();
		paymentDetailsRequestDto.setUserId(1L);
		
		UserRegistration userRegistration=new UserRegistration();
		userRegistration.setUserId(1L);
		
		Mockito.when(registrationProxy.getUserDetails(Mockito.any(Long.class))).thenReturn(new ResponseEntity<>(userRegistration,HttpStatus.OK));
		Mockito.when(paymentDetailsRepository.findByUserId(Mockito.any(Long.class))).thenReturn(null);
				
		Assertions.assertThrows(PaymentDetailsNotFoundException.class, () -> mortgageServiceImpl.updatePaymentDetails(paymentDetailsRequestDto));
	}
	
	@Test
	void testUpdatePaymentDetailsError() {
		PaymentDetailsRequestDto paymentDetailsRequestDto = new PaymentDetailsRequestDto();
		paymentDetailsRequestDto.setUserId(145L);
	
		Mockito.when(registrationProxy.getUserDetails(Mockito.any(Long.class))).thenThrow(RuntimeException.class);
		
		Assertions.assertThrows(RuntimeException.class, () -> mortgageServiceImpl.updatePaymentDetails(paymentDetailsRequestDto));
	}
	
	@Test
	void testGetPaymentDetailsById() {
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAccountHolderName("Alex");
		paymentDetails.setUserId(1L);
		
		Mockito.when(paymentDetailsRepository.findByUserId(Mockito.any(Long.class))).thenReturn(paymentDetails);
		
		GetPaymentDetailResponseDto getPaymentDetailResponseDto = mortgageServiceImpl.getPaymentDetailsById(1L);
		
		assertEquals(getPaymentDetailResponseDto.getAccountHolderName(), paymentDetails.getAccountHolderName());
	}
	
	@Test
	void testGetPaymentDetailsByIdError() {
		Mockito.when(paymentDetailsRepository.findByUserId(Mockito.any(Long.class))).thenReturn(null);		
		Assertions.assertThrows(PaymentDetailsNotFoundException.class, () -> mortgageServiceImpl.getPaymentDetailsById(1L));
	}

}
