package com.santander.mortgage.dto;

public class ValuationResponseDto {

	private Long userId;
	
	private String message;


	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
