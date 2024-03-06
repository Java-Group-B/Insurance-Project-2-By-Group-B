package com.insuranceproject2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insuranceproject2.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

}
