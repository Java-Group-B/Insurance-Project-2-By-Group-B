package com.insuranceproject2.service;

import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.insuranceproject2.model.User;
import com.insuranceproject2.model.User795;
import com.insuranceproject2.model.User802;
import com.insuranceproject2.model.User807;
import com.insuranceproject2.model.User808;
import com.insuranceproject2.model.UserCto;


public interface UserService {
	
	public User saveUser(User user);
	public LinkedHashMap getById(Integer id);
	public User795 saveUser795(User795 user);
	public User795 getUserWithClaimById(Integer id);
	
	public User807 saveUser807(User807 user807);
	public User807 getUser807(Integer userId);
	
	public User808 setSaveUser(User808 user808);
	public User808 getUserPolicyDetails(Integer userId);
	
	public User802 saveUser802(User802 user802);
	public List<User802> getUserByFirstName(String firstName);
	public List<User802> getUserByLastName(String lastName);
	public List<User802> getUserByEmail(String email);
}
