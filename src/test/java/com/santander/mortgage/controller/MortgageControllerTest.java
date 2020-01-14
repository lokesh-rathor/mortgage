package com.santander.mortgage.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.model.UserRegistration;
import com.santander.mortgage.service.MortgageService;
import com.santander.mortgage.service.ValuationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MortgageController.class)
public class MortgageControllerTest {

	@InjectMocks
	private MortgageController mortgageController;
	@MockBean
	private ValuationService valuationService;

	@MockBean
	private MortgageService mortgageService;

	@Autowired
	private MockMvc mockMvc;

	/*
	 * @Test public void testPostValuation() throws Exception {
	 * 
	 * ValuationResponseDto response = new ValuationResponseDto();
	 * response.setMessage("Added Successfully"); response.setUserId(2L);
	 * when(valuationService.postValuation(Mockito.any(ValuationRequestDto.class))).
	 * thenReturn(response);
	 * 
	 * mockMvc.perform(post("/api/valuation").contentType(MediaType.APPLICATION_JSON
	 * ).param("contactPerson", "nrj") .param("contactName",
	 * "123456").param("contactNumber", "Anny").param("isPropertyInScotland", "1"))
	 * .andExpect(status().is(200));
	 * 
	 * }
	 */

	@Test
	public void testPaymentDetails() throws Exception {

		UserRegistration registrationRequest = new UserRegistration();
		registrationRequest.setUserId(1L);
		registrationRequest.setEmail("test@test.com");

		PaymentDetailsRequestDto request = new PaymentDetailsRequestDto();
		request.setUserId(1L);
		request.setCurrentCircumstances(1);
		request.setSortCode(15455L);
		request.setAccountNumber(124521L);
		request.setAccountHolderName("tester");
		request.setDayOfPayment(1);

		String requestJson = jsonToString(request);

		PaymentDetailsResponseDto response = new PaymentDetailsResponseDto();
		response.setMessage("Payment done Successfully");
		response.setUserId(1L);

		when(mortgageService.updatePaymentDetails(Mockito.any(PaymentDetailsRequestDto.class))).thenReturn(response);
		mockMvc.perform(post("/api/payment-details").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().is(200));

	}

	private String jsonToString(PaymentDetailsRequestDto request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(request);
	}
}
