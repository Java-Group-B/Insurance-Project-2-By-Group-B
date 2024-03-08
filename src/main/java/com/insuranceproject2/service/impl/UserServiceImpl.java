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
		if (user.getFirstName() == null && user.getLastName() == null && user.getEmailId() == null) {
			throw new IncompleteDetailsFilledException("Please Enter User Details");
		}
		if (user.getFirstName() == null) {
			throw new IncompleteDetailsFilledException("FirstName cannot be blank.Please enter Firstname");

		}
		if (user.getLastName() == null) {
			throw new IncompleteDetailsFilledException("LastName cannot be blank.Please enter Lastname");
		}
		if (user.getEmailId() == null) {
			throw new IncompleteDetailsFilledException("Email id cannot blank.Please Enter valid mail id.");
		}

		User user1 = userRepository.save(user);
		return user1;
	}

}
