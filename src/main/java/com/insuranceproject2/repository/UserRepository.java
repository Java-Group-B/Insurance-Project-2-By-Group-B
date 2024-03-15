package com.insuranceproject2.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.insuranceproject2.model.User;

public interface UserRepository extends JpaRepository<User, Serializable> {
	@Query(value= "select * from user where first_name=?1", nativeQuery=true)
	public List<User> findUserByFirstName(String firstName);
	
	@Query(value="select * from user u where last_name=?1",nativeQuery=true)
	public List<User> findUserByLastName(String lastName);
	
	@Query(value="select * from user u where email_id=?1",nativeQuery=true)
	public List<User> findUserByEmail(String email);


}
