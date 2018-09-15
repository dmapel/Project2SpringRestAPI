package com.revature.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.User;
import com.revature.service.UserService;


public class LoginCtrlTest {
    
	@Autowired
	UserService us;
	
	@Test
	public void findUsers() {
		
		User u = new User();
		
		u.setfName("Bill");
		u.setuId(62);
		u.setlName("Nye");
		u.setUsername("science");
		u.setPassword("guy");
		u.setPosId(1);
		System.out.println("Testing find users! " + u);
		assertEquals(u, us.getUser(62));
		
	}
}
