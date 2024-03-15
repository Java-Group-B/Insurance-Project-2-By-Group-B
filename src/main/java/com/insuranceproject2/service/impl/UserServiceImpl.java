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
import com.insuranceproject2.repository.UserRepository;
import com.insuranceproject2.service.UserService;

@Service
public class UserServiceImpl implements UserService {

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
		User user2 = userRepository.save(user);
		return user2;
	}

	@Override
	public LinkedHashMap getUserWithClaimById(Integer id) {
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Id is not present in Database."));
		LinkedHashMap map = new LinkedHashMap<>();

		map.put("id", user.getId());
		map.put("firstName", user.getFirstName());
		map.put("lastName", user.getLastName());
		map.put("email", user.getEmailId());
		map.put("claim", user.getClaimlist());

		return map;
	}

	@Override
	public LinkedHashMap getUserPolicyWithPremiumById(Integer id) {

		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Id is not present in Database."));

		LinkedHashMap policyDetails = new LinkedHashMap<>();

		policyDetails.put("id", user.getId());
		policyDetails.put("firstName", user.getFirstName());
		policyDetails.put("lastName", user.getLastName());
		policyDetails.put("email", user.getEmailId());
		policyDetails.put("policies", user.getPolicylist());
		policyDetails.put("premium plans", user.getPremiunlist());

		return policyDetails;
	}

	@Override
	public LinkedHashMap getUserPolicyWithClaimById(Integer id) {
		// List<User> userFirst=userRepository.getByFirstName(firstName);
		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new IncompleteDetailsFilledException("Id is not present in Database."));
		LinkedHashMap map = new LinkedHashMap<>();

		// List<Policy> policies=new ArrayList<Policy>();

		map.put("id", user.getId());
		map.put("firstName", user.getFirstName());
		map.put("lastName", user.getLastName());
		map.put("email", user.getEmailId());
		map.put("policies", user.getPolicylist());
		map.put("claim", user.getClaimlist());

		return map;
	}

	@Override
	public List<User> findUserByFirstName(String firstName) {

		List<User> user = userRepository.findUserByFirstName(firstName);

		if (user.isEmpty()) {
			throw new UserNotFoundException("User with this firstname doesn't exist.");
		}
		return user;
	}

	@Override
	public List<User> findUserByLastName(String lastName) {
		List<User> user = userRepository.findUserByLastName(lastName);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User with this lastname doesn't exist.");
		}
		return user;

	}

	@Override
	public List<User> findUserByEmail(String emailId) {

		List<User> user = userRepository.findUserByEmail(emailId);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User with this emailId doesn't exist.");
		}
		return user;
	}
}
