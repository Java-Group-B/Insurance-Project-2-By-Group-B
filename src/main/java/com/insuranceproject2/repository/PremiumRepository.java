package com.insuranceproject2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuranceproject2.model.Premium;

public interface PremiumRepository extends JpaRepository<Premium, Serializable>{

}
