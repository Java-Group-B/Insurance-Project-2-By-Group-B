package com.insuranceproject2.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.insuranceproject2.exception.IncompleteDetailsFilledException;
import com.insuranceproject2.exception.UserNotFoundException;
import com.insuranceproject2.model.Policy;
import com.insuranceproject2.model.User;
import com.insuranceproject2.model.User795;
import com.insuranceproject2.model.User802;
import com.insuranceproject2.model.User807;
import com.insuranceproject2.model.User808;
import com.insuranceproject2.model.UserCto;
import com.insuranceproject2.repository.UserRepository;
import com.insuranceproject2.repository.UserRepository795;
import com.insuranceproject2.repository.UserRepository802;
import com.insuranceproject2.repository.UserRepository807;
import com.insuranceproject2.repository.UserRepository808;
import com.insuranceproject2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository795 userRepository795;

	@Autowired
	private UserRepository807 userRepository807;

	@Autowired
	private UserRepository808 userRepository808;

	@Autowired
	private UserRepository802 userRepository802;
	@Autowired
	private UserRepository userRepository;

	@Override
	
	public User saveUser(User user) {
		if (user.getFirstName() == null && user.getLastName() == null && user.getEmailId() == null) {
			throw new IncompleteDetailsFilledException("User Details cannot be blank.Please Enter User Details");
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
		User user2= userRepository.save(user);
		return user2;
	}
	@Override
	public LinkedHashMap getById(Integer id) {
		//List<User> userFirst=userRepository.getByFirstName(firstName);
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new IncompleteDetailsFilledException("Id is not present in Database."));
		LinkedHashMap map=new LinkedHashMap<>();
		
	//List<Policy> policies=new ArrayList<Policy>();
		 
			 map.put("id",user.getId());
			 map.put("firstName",user.getFirstName());
			 map.put("lastName",user.getLastName());
			 map.put("email",user.getEmailId());
			 map.put("policies",user.getPolicylist());
			 map.put("claim",user.getClaimlist());
		 
		 
		/*
		 * List<User802> userFirstName = userRepository802.findByFirstName(firstName);
		 * return userFirstName;
		 */
		return map;
	}
	@Override
	public User795 saveUser795(User795 user) {
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
		if (user.getClaimList() == null) {
			throw new IncompleteDetailsFilledException(
					"Claim should not be blank. Please enter at least one Claim request");

		}
		User795 user1 = userRepository795.save(user);
		return user1;
	}

	@Override
	public User795 getUserWithClaimById(Integer id) {
		User795 user = null;
		try {

			user = userRepository795.findById(id).get();
		} catch (Exception e) {
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
		User807 user1 = userRepository807.findById(userId).get();
		return user1;
	}

	@Override
	public List<User802> getUserByFirstName(String firstName) {
		List<User802> userFirstName = userRepository802.findByFirstName(firstName);
		return userFirstName;
	}

	@Override
	public List<User802> getUserByLastName(String lastName) {
		List<User802> userLastName = userRepository802.findByLastName(lastName);
		return userLastName;
	}

	@Override
	public List<User802> getUserByEmail(String email) {
		List<User802> userEmail = userRepository802.findByEmail(email);
		return userEmail;
	}

	@Override
	public User802 saveUser802(User802 user802) {
		return userRepository802.save(user802);
	}

	@Override
	public User808 setSaveUser(User808 user808) {
		User808 userDataInsert = userRepository808.save(user808);
		return userDataInsert;
	}

	@Override
	public User808 getUserPolicyDetails(Integer userId) {
		User808 user = userRepository808.findByUserId(userId);
		if (user == null) { // 1==null-F , null==null-T
			throw new UserNotFoundException("User id is not present into database.");
		}
		return user;
	}

	

}
