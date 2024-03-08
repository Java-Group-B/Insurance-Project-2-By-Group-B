package com.insuranceproject2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuranceproject2.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{

}
