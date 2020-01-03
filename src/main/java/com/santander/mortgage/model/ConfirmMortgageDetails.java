package com.santander.mortgage.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="ConfirmMortgageDetails")
@Entity
public class ConfirmMortgageDetails {
	@Id
	@Column(name="Id")
	private Long Id;
	
	@Column(name="UserId")
	private Long userId;
	
	@Column(name="BuyerType")
	private String buyerType;
	
	@Column (name="RepaymentMethod")
	private String repaymentMethod;
	
	@Column (name="MortgageTerm")
	private String mortgageTerm;
	
	@Column (name="EstimatedPropertyValue")
	private long estimatedPropertyValue;
	
	@Column (name="BorrowingAmount")
	private long borrowingAmount;
	
	@Column (name="LoanToValue")
	private long loanToValue;
	
	@Column (name="FollowOnRate")
	private long followOnRate;
	
	@Column (name="RateFinishedDate")
	private Date rateFinishedDate;
	
	@Column (name="ProductFeeAddedToLoanAmt")
	private int productFeeAddedToLoanAmt;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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

	public long getLoanToValue() {
		return loanToValue;
	}

	public void setLoanToValue(long loanToValue) {
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
