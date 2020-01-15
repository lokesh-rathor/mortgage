package com.santander.mortgage.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.PropertyDetailsDto;
import com.santander.mortgage.dto.PaymentDetailsRequestDto;
import com.santander.mortgage.dto.PaymentDetailsResponseDto;
import com.santander.mortgage.model.UserRegistration;
import com.santander.mortgage.service.MortgageService;
import com.santander.mortgage.service.ValuationService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MortgageController.class)
public class MortgageControllerTest {

	@InjectMocks
	private MortgageController mortgageController;

	@Mock
	MortgageControllerTest mortgageControllerTest;

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
	 * when(valuationService.postValuation(Mockito.any(ValuationRequestDto.class
	 * ))). thenReturn(response);
	 * 
	 * mockMvc.perform(post("/api/valuation").contentType(MediaType.
	 * APPLICATION_JSON ).param("contactPerson", "nrj") .param("contactName",
	 * "123456").param("contactNumber", "Anny").param("isPropertyInScotland",
	 * "1")) .andExpect(status().is(200));
	 * 
	 * }
	 */

	/*
	 * @MockBean private PropertyDetailsRepository propertyDetailsRepository;
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

	@Test
	public void testPaymentDetailsError() throws Exception {

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

	@Test // (expected = InvalidInputException.class)
	public void propertyDetailsTest() throws Exception {
		// Date d1 = new Date(2017, 12, 12);

		MortgageResponseDto mortgageResponseDto = new MortgageResponseDto();

		mortgageResponseDto.setUserId((int) 1L);
		mortgageResponseDto.setMessage("Property Details Saved Succefully");

		MortgageRequestDto mortgageRequestDto = new MortgageRequestDto();
		mortgageRequestDto.setPropertyAddress("ljkhlkj");
		mortgageRequestDto.setPropertyType("Property_3");
		mortgageRequestDto.setNumberOfBedrooms(4);
		mortgageRequestDto.setPropertyBuilt("1");
		mortgageRequestDto.setPropertyAge(20);
		mortgageRequestDto.setIsPropertyCovered("Yes");
		mortgageRequestDto.setTenureType("100 years");

		String request = this.mapper(mortgageRequestDto);

		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/api/propertyDetails")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(request)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}

	@Test
	public void testGetpropertyById() throws Exception {
		Long userId = (long) 1.0F;
		MortgageService mockMortgageService = Mockito.mock(MortgageService.class);
		Mockito.when(mockMortgageService.getPropertyDetailsById(Mockito.any())).thenReturn(getPropertyById());
		PropertyDetailsDto propertyDetailsDto = mockMortgageService.getPropertyDetailsById(userId);
		assertEquals("H.No 77 , UK London", propertyDetailsDto.getPropertyAddress());
		assertEquals("Property_1", propertyDetailsDto.getPropertyType());
		assertEquals(4, propertyDetailsDto.getNumberOfBedrooms());
		assertEquals("After 1980", propertyDetailsDto.getPropertyBuilt());
		assertEquals(10, propertyDetailsDto.getPropertyAge());
		assertEquals("N", propertyDetailsDto.getIsPropertyCovered());
		assertEquals("Leasehold", propertyDetailsDto.getTenureType());
	}

	@Test // (expected = InvalidInputException.class)
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

		String request = this.mapper(mortgageRequestDto);

		mockMvc.perform(MockMvcRequestBuilders.post("/api/propertyDetails")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(request)).andExpect(status().isBadRequest());
	}

	private String mapper(MortgageRequestDto mortgageRequestDto) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String request = objectMapper.writeValueAsString(mortgageRequestDto);
		return request;
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

	private String jsonToString(PaymentDetailsRequestDto request) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(request);
	}
}
