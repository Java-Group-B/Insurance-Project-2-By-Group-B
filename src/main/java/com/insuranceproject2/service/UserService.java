package com.insuranceproject2.service;

import com.insuranceproject2.model.User795;
import com.insuranceproject2.model.User807;

public interface UserService {
	public User795 saveUser(User795 user);
	public User795 getUserWithClaimById(Integer id);
	
	public User807 saveUser807(User807 user807);
	public User807 getUser807(Integer userId);
}
