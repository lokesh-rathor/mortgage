package com.santander.mortgage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="PaymentDetails")
@Entity
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer PaymentId;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private UserRegistration user;
	
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

	public UserRegistration getUser() {
		return user;
	}

	public void setUser(UserRegistration user) {
		this.user = user;
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
