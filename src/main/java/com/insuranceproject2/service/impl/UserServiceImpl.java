package com.insuranceproject2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.model.User795;
import com.insuranceproject2.model.User807;
import com.insuranceproject2.repository.ClaimRepository795;
import com.insuranceproject2.repository.UserRepository795;
import com.insuranceproject2.repository.UserRepository807;
import com.insuranceproject2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository795 userRepository795;
	
	@Autowired
	private UserRepository807 userRepository807;

	@Override
	public User795 saveUser(User795 user) {
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

		User795 user1 = userRepository795.save(user);
		return user1;
	}

	@Override
	public User795 getUserWithClaimById(Integer id) {
		System.out.println("abc---"+id);
		User795 user=null;
		try {
		
			 user=userRepository795.findById(id).get();
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new IncompleteDetailsFilledException("Id is not present in Database");
			
		}
		
		return user;
	}
	
	

	@Override
	public User807 saveUser807(User807 user807) {
		User807 user1 = userRepository807.save(user807);
		return user1;
	}

	@Override
	public User807 getUser807(Integer userId) {
		User807 user1= userRepository807.findById(userId).get();
		return user1;
	}

}
