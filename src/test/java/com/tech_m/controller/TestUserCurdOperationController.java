package com.tech_m.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech_m.entity.User;
import com.tech_m.repositry.IUser;
import com.tech_m.service.UserCurdOperationService;


public class TestUserCurdOperationController {

	@Autowired(required=true)
	private UserCurdOperationService service;

	@MockBean
	private IUser repositry;

	@Test
	public void getAllUsersTest() {


		when(repositry.findAll()).thenReturn(Stream
				.of(new User("krishna", "pulusu", "krish@gmail.com"), new User("kiran", "bora", "kiran@gmail.com"), new User("datta", "devi", "DATTA@gmail.com"))
				.collect(Collectors.toList()));

		assertEquals(3, service.getAllUsers().size());
		
	}

}
