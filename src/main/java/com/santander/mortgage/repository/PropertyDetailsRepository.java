package com.santander.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.mortgage.model.PropertyDetails;

import feign.Param;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails, Long> {

	public PropertyDetails findByUserId(@Param(value = "UserId") Long UserId);
}
