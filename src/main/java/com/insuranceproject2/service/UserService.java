package com.insuranceproject2.service;

import com.insuranceproject2.model.User;

public interface UserService {
	public User saveUser(User user);
	public User getUserWithClaimById(Integer id);
}
