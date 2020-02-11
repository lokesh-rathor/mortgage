package com.santander.mortgage.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santander.mortgage.dto.UserRegistration;


@Service
public class ServiceClient {
	
	@Autowired
	private RestTemplate restTemplate;

	public ResponseEntity<UserRegistration> getUserDetails(Long userId, String token){
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Authorization",token);
		
		String Url="http://localhost:8765/user-registration-service/users/details/"+userId;

		

		HttpEntity<UserRegistration> entity = new HttpEntity<>(headers);

		ResponseEntity<UserRegistration> resp = restTemplate.exchange(Url, HttpMethod.GET,
				entity, UserRegistration.class);
		
		return resp;
		
	}
	
}
