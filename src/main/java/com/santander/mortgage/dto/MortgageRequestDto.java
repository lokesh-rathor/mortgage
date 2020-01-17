package com.santander.mortgage.dto;

import javax.validation.constraints.NotNull;

public class MortgageRequestDto {

	private Long propertyId;

	private String postCode;

	private Long userId;

	private String propertyAddress;

	private String propertyType;

	private Integer numberOfBedrooms;

	private String propertyBuilt;

	private Integer propertyAge;

	private String isPropertyCovered;
	@NotNull
	private String tenureType;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyBuilt() {
		return propertyBuilt;
	}

	public void setPropertyBuilt(String propertyBuilt) {
		this.propertyBuilt = propertyBuilt;
	}

	public String getIsPropertyCovered() {
		return isPropertyCovered;
	}

	public void setIsPropertyCovered(String isPropertyCovered) {
		this.isPropertyCovered = isPropertyCovered;
	}

	public String getTenureType() {
		return tenureType;
	}

	public void setTenureType(String tenureType) {
		this.tenureType = tenureType;
	}

	public Integer getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(Integer numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public Integer getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(Integer propertyAge) {
		this.propertyAge = propertyAge;
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
