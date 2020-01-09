package com.santander.mortgage.dto;


public class MortgageOptionsResponseDto {

	private String description;
	private float initialRate;
	private String monthlyRepayment;
	private long productFee;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getInitialRate() {
		return initialRate;
	}
	public void setInitialRate(float initialRate) {
		this.initialRate = initialRate;
	}
	public String getMonthlyRepayment() {
		return monthlyRepayment;
	}
	public void setMonthlyRepayment(String monthlyRepayment) {
		this.monthlyRepayment = monthlyRepayment;
	}
	public long getProductFee() {
		return productFee;
	}
	public void setProductFee(long productFee) {
		this.productFee = productFee;
	}
	


}
