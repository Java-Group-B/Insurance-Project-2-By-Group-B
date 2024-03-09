package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.User;
import com.insuranceproject2.repository.ClaimRepository;
import com.insuranceproject2.repository.UserRepository;
import com.insuranceproject2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		

		User user1 = userRepository.save(user);
		return user1;
	}

}
