package com.santander.mortgage.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santander.mortgage.dto.MortgageRequestDto;
import com.santander.mortgage.dto.MortgageResponseDto;
import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.repository.PropertyDetailsRepository;
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
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MortgageService mortgageService;

	/*
	 * @MockBean private PropertyDetailsRepository propertyDetailsRepository;
	 */
	
	
	
	@Test
	public void testPostValuation() throws Exception {
		
		ValuationResponseDto response = new ValuationResponseDto();
		response.setMessage("Added Successfully");
		response.setUserId(2L);
		when(valuationService.postValuation(Mockito.any(ValuationRequestDto.class))).thenReturn(response);
	
		mockMvc.perform(post("/api/valuation").contentType(MediaType.APPLICATION_JSON).param("contactPerson","nrj")
                .param("contactName", "123456").param("contactNumber", "Anny").param("isPropertyInScotland", "1"))
                .andExpect(status().is(200));
		
		
	}
	
	
	@Test // (expected = InvalidInputException.class)
	public void propertyDetailsTest() throws Exception {
		//Date d1 = new Date(2017, 12, 12);
		
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
	
	@Test // (expected = InvalidInputException.class)
	public void propertyDetailsErrorTest() throws Exception {
		//Date d1 = new Date(2017, 12, 12);
		
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
			mortgageRequestDto.setTenureType("100 years");

			String request = this.mapper(mortgageRequestDto);


			mockMvc.perform(MockMvcRequestBuilders.post("/api/propertyDetails").contentType(MediaType.APPLICATION_JSON_VALUE)
					.content(request)).andExpect(status().isBadRequest());
	}


	private String mapper(MortgageRequestDto mortgageRequestDto) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		String request = objectMapper.writeValueAsString(mortgageRequestDto);
		return request;
	}

}
