package com.santander.mortgage.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ValuationRequestDto {
	
	@NotNull
	private String userId;
	@NotNull
	private Integer isPropertyInScotland;
	@NotNull
	private String contactPerson;
	@NotNull
	@Size(min=2)
	private String contactName;
	@NotNull
	private Long contactNumber;
	

	public Integer getIsPropertyInScotland() {
		return isPropertyInScotland;
	}
	public void setIsPropertyInScotland(int i) {
		this.isPropertyInScotland = i;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}
