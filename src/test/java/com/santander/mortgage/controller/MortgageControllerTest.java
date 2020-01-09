package com.santander.mortgage.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.santander.mortgage.dto.ValuationRequestDto;
import com.santander.mortgage.dto.ValuationResponseDto;
import com.santander.mortgage.service.ValuationService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(MortgageController.class)
public class MortgageControllerTest {

	@InjectMocks
	private MortgageController mortgageController;
	@MockBean
	private ValuationService valuationService;
	
	@Autowired
	private MockMvc mockMvc;
	
	
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

}
