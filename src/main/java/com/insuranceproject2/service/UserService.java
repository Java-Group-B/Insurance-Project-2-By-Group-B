package com.insuranceproject2.service;

import java.util.LinkedHashMap;
import java.util.List;
import com.insuranceproject2.model.User;

public interface UserService {

	public User saveUser(User user);

	public LinkedHashMap getUserWithClaimById(Integer id);

	public LinkedHashMap getUserPolicyWithClaimById(Integer id);

	public LinkedHashMap getUserPolicyWithPremiumById(Integer id);

	public List<User> findUserByFirstName(String firstName);

	public List<User> findUserByLastName(String lastName);

	public List<User> findUserByEmail(String emailId);

}
