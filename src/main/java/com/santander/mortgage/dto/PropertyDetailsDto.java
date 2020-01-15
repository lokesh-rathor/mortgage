/**
 * 
 */
package com.santander.mortgage.dto;

/**
 * @author Harpreet.Bagga
 *
 */
public class PropertyDetailsDto {
	
	private Long userId;
	private Long propertyId;
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	private String propertyAddress;
	private String propertyType;
	private int numberOfBedrooms;
	private String propertyBuilt; 
	private int propertyAge;
	private String isPropertyCovered; 
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
