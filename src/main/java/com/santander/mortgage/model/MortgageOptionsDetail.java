package com.santander.mortgage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="MortgageOptions")
@Entity
public class MortgageOptionsDetail {

	@Id
	@Column(name="OptionId")
	private Long optionId;
	
	@Column(name="Description")
	private String description;
	
	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getInitialRate() {
		return initialRate;
	}

	public void setInitialRate(int initialRate) {
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

	@Column(name="InitialRate")
	private int initialRate;
	
	@Column (name="MonthlyRepayment")
	private String monthlyRepayment;
	
	@Column (name="ProductFee")
	private long productFee;
}
