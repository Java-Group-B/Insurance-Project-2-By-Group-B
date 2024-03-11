package com.insuranceproject2.repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.insuranceproject2.model.User802;



@Repository
public interface UserRepository802 extends CrudRepository<User802, Serializable>{
	
	@Query(value="select * from user802 u where first_name=?1",nativeQuery=true)
	public List<User802> findByFirstName(String firstName);
	
	@Query(value="select * from user802 u where last_name=?1",nativeQuery=true)
	public List<User802> findByLastName(String lastName);
	
	@Query(value="select * from user802 u where email_id=?1",nativeQuery=true)
	public List<User802> findByEmail(String email);
}


