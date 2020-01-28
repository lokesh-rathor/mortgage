package com.santander.mortgage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="payment_details")
@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer PaymentId;
	
	@Column(name = "userId")
	private Long userId;
	
	@Column(name="currentcircumstances")
	private Integer currentcircumstances;
	
	@Column(name="sortCode")
	private Long sortCode;
	
	@Column(name="accountNumber")
	private Long accountNumber;
	
	@Column(name="accountHolderName")
	private String accountHolderName;
	
	@Column(name="dayOfPayment")
	private Integer dayOfPayment;

	public Integer getPaymentId() {
		return PaymentId;
	}

	public void setPaymentId(Integer paymentId) {
		PaymentId = paymentId;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
