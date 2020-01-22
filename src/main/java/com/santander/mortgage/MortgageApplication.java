package com.santander.mortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.santander.mortgage")
@EnableCaching
public class MortgageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}