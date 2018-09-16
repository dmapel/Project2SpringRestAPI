package com.revature.commentTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

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
public class EditCommentTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	
	@Test
	public void testEditComment() throws Exception {
		
				
		String exampleCommentJson = "{\r\n" + 
				"    \"cId\": 123,\r\n" + 
				"    \"uId\": 4,\r\n" + 
				"    \"time\": \"2018-09-16T07:08:41.019\",\r\n" + 
				"    \"pageId\": 241,\r\n" + 
				"    \"content\": \"7 am ya\",\r\n" + 
				"    \"commentStatus\": 1\r\n" + 
				"}";
		
		
		mockMvc.perform(put("/edit/comment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(exampleCommentJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.cId").value(123))
				.andExpect(jsonPath("$.uId").value(4))
				.andExpect(jsonPath("$.pageId").value(241))
				.andExpect(jsonPath("$.content").value("7 am ya"))
				.andExpect(jsonPath("$.commentStatus").value(1));
				
}
		
		
	

}
	
	
	
	
	
	
	
	
	
	
	
	
	
