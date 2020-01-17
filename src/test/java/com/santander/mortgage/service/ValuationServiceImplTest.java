package com.santander.mortgage.service;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.model.Valuation;
import com.santander.mortgage.repository.ValuationRepository;
import com.santander.mortgage.serviceImpl.MortgageServiceImpl;

@ExtendWith(SpringExtension.class)
public class ValuationServiceImplTest {
	
	@InjectMocks
	private MortgageServiceImpl valuationService;
	
	@Mock
	private ValuationRepository valuationRepository;

	@Test
	public void testPostValuation() {
		
		
		ValuationRequestDto valuationRequestDto = new ValuationRequestDto();
		valuationRequestDto.setContactName("Dr. Amit");
		valuationRequestDto.setContactNumber(90125423411L);
		valuationRequestDto.setContactPerson("Owner");
		valuationRequestDto.setIsPropertyInScotland(1);
		
		Valuation valuation = new Valuation();
		valuation.setContactName("contactName");
		valuation.setContactNumber(321546768L);
		valuation.setContactPerson("contactPerson");
		valuation.setIsPropertyInScotland(1);
		valuation.setUserId("amitThakur@mail.com");
		
		
		ValuationResponseDto valuationResponseDto = new ValuationResponseDto();
		valuationResponseDto.setMessage("Added Successfully");
		valuationResponseDto.setUserId("amitThakur@mail.com");
		
		Mockito.when(valuationRepository.save(Mockito.any(Valuation.class))).thenReturn(valuation);
		ValuationResponseDto valuationResponse = valuationService.postValuation(valuationRequestDto);
		assertEquals(valuationResponseDto.getUserId(),valuationResponse.getUserId());
		
	}
	


}
