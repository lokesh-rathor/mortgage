package com.santander.mortgage.dto;

public class ValuationRequestDto {
	
	private Boolean isPropertyInScotland;
	private String contactPerson;
	private String contactName;
	private Integer contactNumber;
	

	public Boolean getIsPropertyInScotland() {
		return isPropertyInScotland;
	}
	public void setIsPropertyInScotland(Boolean isPropertyInScotland) {
		this.isPropertyInScotland = isPropertyInScotland;
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
	public Integer getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	

}
