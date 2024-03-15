package com.insuranceproject2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insuranceproject2.model.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	
}
