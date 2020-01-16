package com.santander.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.mortgage.model.PaymentDetails;

import feign.Param;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {

	public PaymentDetails findByUserId(@Param("userId") Long userId);

}
