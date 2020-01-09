package com.santander.mortgage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santander.mortgage.model.Valuation;

@Repository
public interface ValuationRepository extends JpaRepository<Valuation,Integer>{

}
