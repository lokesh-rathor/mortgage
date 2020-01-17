package com.santander.mortgage.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ValuationRequestDto {
	
	@NotNull
	private Long userId;
	@NotNull
	private Integer isPropertyInScotland;
	@NotNull
	private String contactPerson;
	@NotNull
	@Size(min=2)
	private String contactName;
	@NotNull
	private Long contactNumber;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setIsPropertyInScotland(Integer isPropertyInScotland) {
		this.isPropertyInScotland = isPropertyInScotland;
	}
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
	
}
