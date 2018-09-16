package com.revature.pageTest;

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
public class CreatePageTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	

	
	@Test
	public void testCreatePage() throws Exception {
		
		String json = "{\r\n" + 
				"    \"pageId\": 386,\r\n" + 
				"    \"pageComments\": [],\r\n" + 
				"    \"creatorId\": 1,\r\n" + 
				"    \"title\": \"Java\",\r\n" + 
				"    \"summary\": \"sweet\",\r\n" + 
				"    \"body\": \"la la.\",\r\n" + 
				"    \"pageStatus\": 1,\r\n" + 
				"    \"time\": \"2018-09-16T12:17:24.33\",\r\n" + 
				"    \"tags\": []\r\n" + 
				"}";
		
		mockMvc.perform(post("/create/page")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.pageId").value(386))
				.andExpect(jsonPath("$.creatorId").value(1))
				.andExpect(jsonPath("$.title").value("Java"))
				.andExpect(jsonPath("$.summary").value("sweet"))
				.andExpect(jsonPath("$.body").value("la la."))
				.andExpect(jsonPath("$.pageStatus").value(1));
		
	}

	
}
