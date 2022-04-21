package com.tech_m.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import com.tech_m.entity.User;
import com.tech_m.exception.ResourceNotFoundException;
import com.tech_m.repositry.IUser;
import com.tech_m.request.UserRequest;

@Configuration
public class UserCurdOperationService {
	
	@Autowired
	private IUser userRep;


	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		User savedUser = userRep.save(user);
		//if(savedUser =! null &&)
		
		return savedUser;
	}

	
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		User exstingUser = this.userRep.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found with id:" + id));
		return exstingUser;
	}


	public Optional<UserRequest> getUserByName(String firstName) {
		Optional<User> byfirstName = userRep.findByfirstName(firstName);
		if(byfirstName.isPresent()) {
			
			User user = byfirstName.get();
			UserRequest userRequestDetails = new UserRequest();
			userRequestDetails.setId(user.getId());
			userRequestDetails.setFirstName(user.getFirstName());
			userRequestDetails.setEmail(user.getEmail());
			
			return Optional.ofNullable(userRequestDetails);
		}else {
			 throw new ResourceNotFoundException("Empty");
			
		}
	}

	public List<User> getAllUsers() {
		
		List<User> userData = userRep.findAll();
		
		return userData;
	}

	public User updateUser(User user,long id) {
		// TODO Auto-generated method stub
		
		System.out.println("entered into the updateUser service");
		User exstingRecord = userRep.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("record not foud to Update with:" + id));
		
		
		
		//exstingRecord.setId(user.getId());
		exstingRecord.setFirstName(user.getFirstName());
		exstingRecord.setLastName(user.getLastName());
		exstingRecord.setEmail(user.getEmail());
		
		User updatedData = userRep.save(exstingRecord);
		
		return updatedData;
		
		
	}
	public ResponseEntity<Object> deleteUser(long id) {
		// TODO Auto-generated method stub
		System.out.println("intered in service deleteUser");
		User exstingUser = this.userRep.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("resource not found with id:" + id));
		
		this.userRep.delete(exstingUser);
		
		System.out.println("exist from service deleteUser");
		return ResponseEntity.ok().build();
	}
	

}
