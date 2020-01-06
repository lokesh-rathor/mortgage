package com.santander.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.mortgage.model.PropertyDetails;

@Repository
public interface MortgageRepository extends JpaRepository<PropertyDetails, Long> {

}
