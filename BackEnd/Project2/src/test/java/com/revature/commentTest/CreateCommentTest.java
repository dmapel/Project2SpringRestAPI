package com.revature.commentTest;

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
public class CreateCommentTest  {
	
    
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	@Test
	public void testCreateComment() throws Exception {
		
		String exampleCommentJson = "{\r\n" + 
				"    \"cId\": 1,\r\n" + 
				"    \"uId\": 4,\r\n" + 
				"    \"time\": \"2017-03-08T12:30:54\",\r\n" + 
				"    \"pageId\": 241,\r\n" + 
				"    \"content\": \"Go Java\",\r\n" + 
				"    \"commentStatus\": 1\r\n" + 
				"}";

		mockMvc.perform(post("/create/comment")
				.contentType(MediaType.APPLICATION_JSON)
				.content(exampleCommentJson))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.cId").value(1))
				.andExpect(jsonPath("$.uId").value(4))
				.andExpect(jsonPath("$.time").value("2017-03-08T12:30:54"))
				.andExpect(jsonPath("$.pageId").value(241))
				.andExpect(jsonPath("$.content").value("Go Java"))
				.andExpect(jsonPath("$.commentStatus").value(1));
				
}
	

}





