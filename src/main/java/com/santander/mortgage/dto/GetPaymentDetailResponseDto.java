package com.santander.mortgage.dto;

public class GetPaymentDetailResponseDto {

	private Integer paymentId;
	
	private Integer currentcircumstances;
	
	private Long sortCode;
	
	private Long accountNumber;
	
	private String accountHolderName;
	
	private Integer dayOfPayment;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getCurrentcircumstances() {
		return currentcircumstances;
	}

	public void setCurrentcircumstances(Integer currentcircumstances) {
		this.currentcircumstances = currentcircumstances;
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
