package com.revature.usertest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateUserTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	
	@Test
	public void testCreateUser() throws Exception {
		
		String json = "{\r\n" + 
				"    \"uId\": 121,\r\n" + 
				"    \"fName\": \"Cool beans yo yo yo yo yo yo\",\r\n" + 
				"    \"lName\": \"241\",\r\n" + 
				"    \"username\": \"hey there\",\r\n" + 
				"    \"password\": \"hi\",\r\n" + 
				"    \"posId\": 1\r\n" + 
				"}";
		
		mockMvc.perform(post("/create/user")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.uId").value(121))
				.andExpect(jsonPath("$.fName").value("Cool beans yo yo yo yo yo yo"))
				.andExpect(jsonPath("$.lName").value("241"))
				.andExpect(jsonPath("$.username").value("hey there"))
				.andExpect(jsonPath("$.password").value("hi"))
				.andExpect(jsonPath("$.posId").value(1));
		
	}

}
