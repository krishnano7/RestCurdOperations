package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.tech_m.entity.User;
import com.tech_m.repositry.IUser;
import com.tech_m.service.UserCurdOperationService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.tech_m.controller.TestUserCurdOperationController.class)
@SpringBootApplication(scanBasePackages = "com.tech_m")// because of this one line scanBasePackages = "com.tech_m" was not present we got error as 
//Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
class YoutubeSpringBootCurdOpApplicationTests {
	
	@Autowired(required=true)
	private UserCurdOperationService service;

	@MockBean
	private IUser repositry;

	@Test
    public void contextLoads()
    {
		System.out.println("test started");
    }

	
	@Test
	public void getAllUsersTest() {

		System.out.println("started test getall");
		when(repositry.findAll()).thenReturn(Stream
				.of(new User("rishna", "pulusu", "krish@gmail.com"), new User("iran", "bora", "kiran@gmail.com"), new User("datta", "devi", "DATTA@gmail.com"))
				.collect(Collectors.toList()));

		assertEquals(3, service.getAllUsers().size());
		assertNotEquals(2, service.getAllUsers().size());
		System.out.println("ended test getall");
		
		
		
	}
	
	/*
	 * @Test public void getUserbynameTest() {
	 * System.out.println("started test saveall");
	 * 
	 * String firstname= "krishna"; when(repositry.findByfirstName(firstname))
	 * .thenReturn(Stream.of(new User("krish", "pu", "kri@gmail.com"))
	 * .collect(Collectors.toList()));
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	 


}
