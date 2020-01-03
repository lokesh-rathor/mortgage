package com.santander.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.mortgage.model.PropertyDetails;

public interface MortgageRepository extends JpaRepository<PropertyDetails, Long> {

}
