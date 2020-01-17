package com.santander.mortgage.dto;

public class ValuationResponseDto {

	private String userId;
	private Integer isPropertyInScotland;
	private String contactPerson;
	private String contactName;
	private Long contactNumber;
	private Long valuationId;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getValuationId() {
		return valuationId;
	}
	public void setValuationId(Long valuationId) {
		this.valuationId = valuationId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getIsPropertyInScotland() {
		return isPropertyInScotland;
	}
	public void setIsPropertyInScotland(Integer isPropertyInScotland) {
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
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	
	
}
