package com.santander.mortgage.dto;

import java.sql.Date;

public class UserRegistration {

	private Long userId;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private Date dateOfBirth;
	
	private String email;
	
	private String forgetPasswordQ;
	
	private String forgetPasswordA;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getForgetPasswordQ() {
		return forgetPasswordQ;
	}

	public void setForgetPasswordQ(String forgetPasswordQ) {
		this.forgetPasswordQ = forgetPasswordQ;
	}

	public String getForgetPasswordA() {
		return forgetPasswordA;
	}

	public void setForgetPasswordA(String forgetPasswordA) {
		this.forgetPasswordA = forgetPasswordA;
	}
	
	
	
}
