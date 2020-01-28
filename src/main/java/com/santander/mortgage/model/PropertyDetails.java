package com.santander.mortgage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PropertyDetails")

@Entity
public class PropertyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "property_id")
	private Long propertyId;

	@Column(name = "UserId")
	private Long userId;

	@Column(name = "PropertyAddress")
	private String propertyAddress;

	@Column(name = "PostCode")
	private String postCode;

	@Column(name = "PropertyType")
	private String propertyType;

	@Column(name = "NumberOfBedrooms")
	private int numberOfBedrooms;

	@Column(name = "PropertyBuilt")
	private String propertyBuilt;

	@Column(name = "PropertyAge")
	private int propertyAge;

	@Column(name = "isPropertyCovered")
	private String isPropertyCovered;

	@Column(name = "TenureType")
	private String tenureType;

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

	public int getNumberOfBedrooms() {
		return numberOfBedrooms;
	}

	public void setNumberOfBedrooms(int numberOfBedrooms) {
		this.numberOfBedrooms = numberOfBedrooms;
	}

	public String getPropertyBuilt() {
		return propertyBuilt;
	}

	public void setPropertyBuilt(String propertyBuilt) {
		this.propertyBuilt = propertyBuilt;
	}

	public int getPropertyAge() {
		return propertyAge;
	}

	public void setPropertyAge(int propertyAge) {
		this.propertyAge = propertyAge;
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

}
