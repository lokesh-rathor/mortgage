package com.santander.mortgage.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santander.mortgage.dto.GetPaymentDetailResponseDto;
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;
import com.santander.mortgage.dto.UserRegistration;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.service.MortgageService;
import com.santander.mortgage.service.ValuationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MortgageController.class)
public class MortgageControllerTest {

	@MockBean
	private MortgageService mortgageService;

	@MockBean
	private ValuationService valuationService;

	@Autowired
	private MockMvc mockMvc;

	/*
	 * public void testPostValuation() throws Exception { ValuationRequestDto
	 * request = new ValuationRequestDto(); request.setContactName("nrj");
	 * request.setContactNumber(5658846);
	 * request.setContactPerson("Current Account"); //
	 * request.setIsPropertyInScotland(0);
	 * 
	 * String requestJson = jsonToString(request);
	 * 
	 * ValuationResponseDto response = new ValuationResponseDto();
	 * response.setMessage("Added Successfully"); response.setUserId(2L);
	 * 
	 * //when(valuationService.postValuation(Mockito.any(ValuationRequestDto.class))
	 * ).thenReturn(response);
	 * 
	 * mockMvc.perform(post("/api/valuation").contentType(MediaType.APPLICATION_JSON
	 * ).content(requestJson)) .andExpect(status().is(200));
	 * 
	 * }
	 */

	@Disabled
	@Test
	public void testPostValuation() throws Exception {

		ValuationResponseDto response = new ValuationResponseDto();
		response.setContactName("amit");
		response.setContactNumber(8285619131L);
		response.setContactPerson("Rahul");
		response.setIsPropertyInScotland(1);
		response.setUserId(1L);

		ValuationRequestDto valuationRequestDto = new ValuationRequestDto();
		valuationRequestDto.setContactName("amit");
		valuationRequestDto.setContactNumber(8285619131L);
		valuationRequestDto.setContactPerson("Rahul");
		valuationRequestDto.setIsPropertyInScotland(1);
		valuationRequestDto.setUserId(1L);

		when(mortgageService.postValuation(Mockito.any(ValuationRequestDto.class))).thenReturn(response);

		String request = this.mapper(valuationRequestDto);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/valuation")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(request)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);

	}

	@Disabled
	@Test
	public void testPostValuationError() throws Exception {

		ValuationRequestDto valuationRequestDto = new ValuationRequestDto();
		valuationRequestDto.setContactName(null);
		valuationRequestDto.setContactNumber(82856191L);
		valuationRequestDto.setContactPerson("Rahul");
		valuationRequestDto.setIsPropertyInScotland(1);

		String request = this.mapper(valuationRequestDto);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/valuation").contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(request)).andExpect(status().isBadRequest());
	}

	private String mapper(ValuationRequestDto valuationRequestDto) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(valuationRequestDto);

	}

	@Test
	public void testSavePaymentDetails() throws Exception {

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

		when(mortgageService.savePaymentDetails(Mockito.any(PaymentDetailsRequestDto.class),Mockito.anyString())).thenReturn(response);
		mockMvc.perform(post("/api/payment-details").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().is(200));
	}

	@Test
	public void testSavePaymentDetailsError() throws Exception {

		UserRegistration registrationRequest = new UserRegistration();
		registrationRequest.setUserId(1L);
		registrationRequest.setEmail("test@test.com");

		PaymentDetailsRequestDto request = new PaymentDetailsRequestDto();
		request.setUserId(1L);
		request.setCurrentCircumstances(1);
		request.setSortCode(15455L);
		request.setAccountNumber(124521L);
		request.setAccountHolderName("t");
		request.setDayOfPayment(1);

		String requestJson = jsonToString(request);

		mockMvc.perform(post("/api/payment-details").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void testUpdatePaymentDetails() throws Exception {

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
		response.setMessage("Payment updated Successfully");
		response.setUserId(1L);

		when(mortgageService.updatePaymentDetails(Mockito.any(PaymentDetailsRequestDto.class), Mockito.anyString())).thenReturn(response);
		mockMvc.perform(put("/api/update/payment-details").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isOk());
	}

	@Test
	public void testUpdatePaymentDetailsError() throws Exception {

		UserRegistration registrationRequest = new UserRegistration();
		registrationRequest.setUserId(1L);
		registrationRequest.setEmail("test@test.com");

		PaymentDetailsRequestDto request = new PaymentDetailsRequestDto();
		request.setUserId(1L);
		request.setCurrentCircumstances(1);
		request.setSortCode(15455L);
		request.setAccountNumber(124521L);
		request.setAccountHolderName("t");
		request.setDayOfPayment(1);

		String requestJson = jsonToString(request);

		mockMvc.perform(put("/api/update/payment-details").contentType(MediaType.APPLICATION_JSON).content(requestJson))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void testGetPaymentDetailsError() throws Exception {

		mockMvc.perform(get("/api/getPaymentDetailsById/-1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}
	
	@Test
	public void testGetPaymentDetails() throws Exception {
		
		GetPaymentDetailResponseDto paymentDetailResponse=new GetPaymentDetailResponseDto();
		paymentDetailResponse.setAccountHolderName("peter");
		paymentDetailResponse.setPaymentId(1);

		when(mortgageService.getPaymentDetailsById(Mockito.any(Long.class))).thenReturn(paymentDetailResponse);
		
		mockMvc.perform(get("/api/getPaymentDetailsById/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Disabled
	@Test
	public void propertyDetailsTest() throws Exception {
		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();

		mortgageResponseDto.setUserId((int) 1L);
		mortgageResponseDto.setMessage("Property Details Saved Succefully");

		MortgageRequestDto mortgageRequestDto = new MortgageRequestDto();
		mortgageRequestDto.setPropertyAddress("H.No 77 , UK London");
		mortgageRequestDto.setPropertyType("Property_3");
		mortgageRequestDto.setNumberOfBedrooms(4);
		mortgageRequestDto.setPropertyBuilt("After 1980");
		mortgageRequestDto.setPropertyAge(20);
		mortgageRequestDto.setIsPropertyCovered("Y");
		mortgageRequestDto.setTenureType("100 years");

		String request = this.jsonToString(mortgageRequestDto);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/propertyDetails")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(request)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	/*
	 * @Test public void testGetpropertyById() throws Exception { Long userId =
	 * (long) 1.0F; MortgageService mockMortgageService =
	 * Mockito.mock(MortgageService.class);
	 * Mockito.when(mockMortgageService.getPropertyDetailsById(Mockito.any())).
	 * thenReturn(getPropertyById()); PropertyDetailsDto propertyDetailsDto =
	 * mockMortgageService.getPropertyDetailsById(userId);
	 * assertEquals("H.No 77 , UK London", propertyDetailsDto.getPropertyAddress());
	 * assertEquals("Property_1", propertyDetailsDto.getPropertyType());
	 * assertEquals(4, propertyDetailsDto.getNumberOfBedrooms());
	 * assertEquals("After 1980", propertyDetailsDto.getPropertyBuilt());
	 * assertEquals(10, propertyDetailsDto.getPropertyAge()); assertEquals("N",
	 * propertyDetailsDto.getIsPropertyCovered()); assertEquals("Leasehold",
	 * propertyDetailsDto.getTenureType()); }
	 */

	@Disabled
	@Test
	public void propertyDetailsErrorTest() throws Exception {
		// Date d1 = new Date(2017, 12, 12);

		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();

		mortgageResponseDto.setUserId((int) 1L);
		mortgageResponseDto.setMessage("Bad Request");

		MortgageRequestDto mortgageRequestDto = new MortgageRequestDto();
		mortgageRequestDto.setPropertyAddress("ljkhlkj");
		mortgageRequestDto.setPropertyType("Property_3");
		mortgageRequestDto.setNumberOfBedrooms(4);
		mortgageRequestDto.setPropertyBuilt("1");
		mortgageRequestDto.setPropertyAge(20);
		mortgageRequestDto.setIsPropertyCovered("Yes");
		mortgageRequestDto.setTenureType(null);

		String request = this.jsonToString(mortgageRequestDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/propertyDetails")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(request)).andExpect(status().isBadRequest());
	}

	private PropertyDetailsDto getPropertyById() {
		PropertyDetailsDto propertyDetailsDto = new PropertyDetailsDto();
		propertyDetailsDto.setPropertyAddress("H.No 77 , UK London");
		propertyDetailsDto.setPropertyType("Property_1");
		propertyDetailsDto.setNumberOfBedrooms(4);
		propertyDetailsDto.setPropertyBuilt("After 1980");
		propertyDetailsDto.setPropertyAge(10);
		propertyDetailsDto.setIsPropertyCovered("N");
		propertyDetailsDto.setTenureType("Leasehold");
		return propertyDetailsDto;
	}

	private String jsonToString(Object request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(request);
	}
}
