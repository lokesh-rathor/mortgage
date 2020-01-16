package com.santander.mortgage.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PaymentDetailsRequestDto {
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Integer currentCircumstances;
	
	@NotNull
	//@Size(min=12)
	@Min(12)
	private Long sortCode;
	
	@NotNull
	@Min(12)
	private Long accountNumber;
	
	@NotNull
	@Size(min=2)
	private String accountHolderName;
	
	@NotNull
	private Integer dayOfPayment;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCurrentCircumstances() {
		return currentCircumstances;
	}

	public void setCurrentCircumstances(Integer currentCircumstances) {
		this.currentCircumstances = currentCircumstances;
	}

	public Long getSortCode() {
		return sortCode;
	}

	public void setSortCode(Long sortCode) {
		this.sortCode = sortCode;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getDayOfPayment() {
		return dayOfPayment;
	}

	public void setDayOfPayment(Integer dayOfPayment) {
		this.dayOfPayment = dayOfPayment;
	}
	
	

}
