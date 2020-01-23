package com.santander.mortgage.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.santander.mortgage.exception.InvalidInputException;
import com.santander.mortgage.service.MortgageService;
import com.santander.mortgage.service.ValuationService;

@CrossOrigin
@RestController
@RequestMapping("/api")

public class MortgageController {
	@Autowired
	private MortgageService mortgageService;

//<<<<<<< HEAD
//	// @GetMapping("get-data")
//	// public String getData() {
//	// return proxy.sayHello();
//	// } 
//=======
	@Autowired
	private ValuationService valuationService;
	
	@Autowired
    private CacheManager cacheManager; 

	private static final Logger logger = LoggerFactory.getLogger(MortgageController.class);


	@GetMapping("/confirmMortgage/{userId}")
	public ResponseEntity<ConfirmMortgageResponseDto> confirmMortgage(@PathVariable("userId") Long userId) {
		ConfirmMortgageResponseDto confirmMortgageResponseDto = null;
		confirmMortgageResponseDto = mortgageService.confirmMortgage(userId);
		return new ResponseEntity<>(confirmMortgageResponseDto, HttpStatus.OK);
	}

	@PostMapping("/propertyDetails")
	public ResponseEntity<MortgageResponseDto> mortgage(@RequestBody @Valid MortgageRequestDto mortgageRequestDto,
			Errors errors) throws InvalidInputException {

		if (errors.hasErrors()) {
			throw new InvalidInputException("Invalid Input is missing");
		}

		logger.info("Inside Property Details method: --");
		MortgageResponseDto mortgageResponseDto = mortgageService.savePropertyDetails(mortgageRequestDto);
		return new ResponseEntity<MortgageResponseDto>(mortgageResponseDto, HttpStatus.OK);

	}
	
	@PutMapping("/propertyDetails/{userId}")
	public ResponseEntity<MortgageResponseDto> updateMortgage(@RequestBody @Valid MortgageRequestDto mortgageRequestDto,
			Errors errors) throws InvalidInputException {

		if (errors.hasErrors()) {
			throw new InvalidInputException("Invalid Input is missing");
		}

		logger.info("Inside Property Details method: --");
		MortgageResponseDto mortgageResponseDto = mortgageService.updatePropertyDetails(mortgageRequestDto);
		return new ResponseEntity<MortgageResponseDto>(mortgageResponseDto, HttpStatus.OK);

	}


	@GetMapping("/propertyDetailsById/{userId}")
	public ResponseEntity<PropertyDetailsDto> getPropertyDetailsById(@PathVariable("userId") Long userId) {
		PropertyDetailsDto propertyDetailsDto = null; 
		try {
			propertyDetailsDto = mortgageService.getPropertyDetailsById(userId);
		} catch (NullPointerException npe) {
			if (npe.getMessage() == null) {
				System.out.println("Error Message : No Record found for this User Id " + userId);
			}
		}
		return new ResponseEntity<PropertyDetailsDto>(propertyDetailsDto, HttpStatus.OK);
	}

	/*
	 * @GetMapping("/confirmMortgage/{userId}") public
	 * ResponseEntity<PropertyDetailsDto> confirmMortgage(@PathVariable("userId")
	 * Long userId){ PropertyDetailsDto confirmMortgageResponseDto =
	 * mortgageService.confirmMortgage(userId); return new
	 * ResponseEntity<>(confirmMortgageResponseDto, HttpStatus.OK); }
	 */

	/*
	 * @GetMapping("/confirmMortgage/{userId}") public
	 * ResponseEntity<PropertyDetailsDto> confirmMortgage(@PathVariable("userId")
	 * Long userId){ PropertyDetailsDto confirmMortgageResponseDto =
	 * mortgageService.confirmMortgage(userId); return new
	 * ResponseEntity<>(confirmMortgageResponseDto, HttpStatus.OK); }
	 */

	@GetMapping("/mortgageOptions")
	public ResponseEntity<List<MortgageOptionsResponseDto>> mortgageOptions() {
		List<MortgageOptionsResponseDto> mortgageOptionsResponseDtoList = null;

		mortgageOptionsResponseDtoList = mortgageService.mortgageOptions();

		if (mortgageOptionsResponseDtoList.size() == 0) {
			System.out.println("Error Message : No Mortgage options available in DB");
		}

		return new ResponseEntity<>(mortgageOptionsResponseDtoList, HttpStatus.OK);
	}

	@PostMapping("/valuation")
	ResponseEntity<ValuationRequestDto> postValuation(@RequestBody ValuationRequestDto valuationRequestDto) {
		ValuationRequestDto valuationRequestDto2 = valuationService.postValuation(valuationRequestDto);
		return new ResponseEntity<ValuationRequestDto>(valuationRequestDto2, HttpStatus.OK);
	}
	
	@GetMapping("/valuation/{userId}")
	public ResponseEntity<ValuationRequestDto> getValuation(@PathVariable("userId") Long userId) {
		ValuationRequestDto valuationRequestDto = null;
		valuationRequestDto = valuationService.getValuation(userId);
		return new ResponseEntity<>(valuationRequestDto, HttpStatus.OK);
	}

	@PostMapping("/payment-details")
	ResponseEntity<PaymentDetailsResponseDto> payemtDetails(
			@RequestBody @Valid PaymentDetailsRequestDto paymentDetailsRequestDto, Errors errors) {

		if (errors.hasErrors()) {
			throw new InvalidInputException("Invalid Input.");
		}

		PaymentDetailsResponseDto paymentDetailsResponseDto = mortgageService
				.updatePaymentDetails(paymentDetailsRequestDto);

		return new ResponseEntity<PaymentDetailsResponseDto>(paymentDetailsResponseDto, HttpStatus.OK);
	}
	
	@GetMapping("/getPaymentDetailsById/{userId}")
	ResponseEntity<GetPaymentDetailResponseDto> getPaymentDetails(@PathVariable("userId") Long userId) {
		GetPaymentDetailResponseDto paymentDetailResponse = mortgageService.getPaymentDetailsById(userId);
		return new ResponseEntity<GetPaymentDetailResponseDto>(paymentDetailResponse, HttpStatus.OK);
	}
	
	// clear all cache using cache manager
    @RequestMapping(value = "clearCache")
    public void clearCache(){
        for(String name:cacheManager.getCacheNames()){
        	System.out.println(cacheManager.getCache(name));
            cacheManager.getCache(name).clear();            // clear cache by name
        }
    }

}
