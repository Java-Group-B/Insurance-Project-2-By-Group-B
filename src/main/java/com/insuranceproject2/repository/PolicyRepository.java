package com.insuranceproject2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insuranceproject2.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Serializable>{

}
