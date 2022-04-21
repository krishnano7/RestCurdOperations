package com.tech_m.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech_m.entity.User;
import com.tech_m.request.UserRequest;
import com.tech_m.service.UserCurdOperationService;

import net.bytebuddy.asm.Advice.Return;

@RestController
@RequestMapping(value = "/curdOpe")
public class UserCurdOperationController {


	@Autowired
	private UserCurdOperationService userService;

	@PostMapping("/saveUser")
	public User saveUser(@RequestBody User user) {

		System.out.println("entered in to save user");
		User save = userService.saveUser(user);

		return save;

	}

	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable("id") long id) {

		System.out.println("hi");

		User userById = userService.getUserById(id);

		return userById;
	}

	@GetMapping("/allUserList")
	public List<User> getAllUsers() {

		List<User> allUsersData = userService.getAllUsers();

		return allUsersData;
	}

	@PutMapping("/updateUser/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") long id) {
System.out.println("entered in update user controller");
	User updateUser = userService.updateUser(user,id);
	
	return updateUser;
	
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable("id") long id) {

		ResponseEntity<Object> deleteUser = userService.deleteUser(id);

		return deleteUser;

	}

	@GetMapping("/getUserByName/{firstName}")
	public Optional<UserRequest> getUserByName(@PathVariable("firstName") String firstName) {

		// Optional<User> findById = userRep.findById(id);

		Optional<UserRequest> userByName = userService.getUserByName(firstName);

		return userByName;
	}

}
