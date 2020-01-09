package com.santander.mortgage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "valuation")
@Entity
public class Valuation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserId")
	private Long userId;
	@Column(name = "IsPropertyInScotland")
	private Integer isPropertyInScotland;
	@Column(name = "ContactPerson")
	private String contactPerson;
	@Column(name = "ContactName")
	private String contactName;
	@Column(name = "ContactNumber")
	private Integer contactNumber;
	

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
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

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	

}
