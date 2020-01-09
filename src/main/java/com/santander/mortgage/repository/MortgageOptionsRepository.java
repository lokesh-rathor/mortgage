package com.santander.mortgage.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.santander.mortgage.model.MortgageOptionsDetail;

@Repository
public interface MortgageOptionsRepository extends JpaRepository<MortgageOptionsDetail, Integer> {

public List<MortgageOptionsDetail> findAll();
}

