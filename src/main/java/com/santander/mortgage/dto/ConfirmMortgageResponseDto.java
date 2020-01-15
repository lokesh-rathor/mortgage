package com.santander.mortgage.dto;

import java.sql.Date;

public class ConfirmMortgageResponseDto {

	private String buyerType;
	private String repaymentMethod;
	private String mortgageTerm;
	private long estimatedPropertyValue;
	private long borrowingAmount;
	private float loanToValue;   
	private float initialRate;
	private long followOnRate;
	private Date rateFinishedDate;
	private int productFee;
	private int productFeeAddedToLoanAmt;
	private int monthlyRepayment;
	
	
	public String getBuyerType() {
		return buyerType;
	}
	public void setBuyerType(String buyerType) {
		this.buyerType = buyerType;
	}
	public String getRepaymentMethod() {
		return repaymentMethod;
	}
	public void setRepaymentMethod(String repaymentMethod) {
		this.repaymentMethod = repaymentMethod;
	}
	public String getMortgageTerm() {
		return mortgageTerm;
	}
	public void setMortgageTerm(String mortgageTerm) {
		this.mortgageTerm = mortgageTerm;
	}
	public float getInitialRate() {
		return initialRate;
	}
	public void setInitialRate(float initialRate) {
		this.initialRate = initialRate;
	}
	public int getProductFee() {
		return productFee;
	}
	public void setProductFee(int productFee) {
		this.productFee = productFee;
	}
	public int getMonthlyRepayment() {
		return monthlyRepayment;
	}
	public void setMonthlyRepayment(int monthlyRepayment) {
		this.monthlyRepayment = monthlyRepayment;
	}
	public long getEstimatedPropertyValue() {
		return estimatedPropertyValue;
	}
	public void setEstimatedPropertyValue(long estimatedPropertyValue) {
		this.estimatedPropertyValue = estimatedPropertyValue;
	}
	public long getBorrowingAmount() {
		return borrowingAmount;
	}
	public void setBorrowingAmount(long borrowingAmount) {
		this.borrowingAmount = borrowingAmount;
	}
	public float getLoanToValue() {
		return loanToValue;
	}
	public void setLoanToValue(float loanToValue) {
		this.loanToValue = loanToValue;
	}
	public long getFollowOnRate() {
		return followOnRate;
	}
	public void setFollowOnRate(long followOnRate) {
		this.followOnRate = followOnRate;
	}
	public Date getRateFinishedDate() {
		return rateFinishedDate;
	}
	public void setRateFinishedDate(Date rateFinishedDate) {
		this.rateFinishedDate = rateFinishedDate;
	}
	public int getProductFeeAddedToLoanAmt() {
		return productFeeAddedToLoanAmt;
	}
	public void setProductFeeAddedToLoanAmt(int productFeeAddedToLoanAmt) {
		this.productFeeAddedToLoanAmt = productFeeAddedToLoanAmt;
	}
}
