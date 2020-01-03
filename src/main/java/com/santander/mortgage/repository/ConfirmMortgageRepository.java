package com.santander.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.mortgage.model.ConfirmMortgageDetails;

import feign.Param;

@Repository
public interface ConfirmMortgageRepository extends JpaRepository<ConfirmMortgageDetails, Integer> {

public ConfirmMortgageDetails findByUserId(@Param(value = "UserId") Long UserId);
}
