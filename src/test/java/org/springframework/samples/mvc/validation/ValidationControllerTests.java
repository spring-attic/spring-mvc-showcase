package org.springframework.samples.mvc.validation;

import org.junit.Before;
import org.junit.Test;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class ValidationControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new ValidationController()).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void validateSuccess() throws Exception {
		this.mockMvc.perform(get("/validate?number=3&date=2029-07-04"))
				.andExpect(content().string("No errors"));
	}

	@Test
	public void validateErrors() throws Exception {
		this.mockMvc.perform(get("/validate?number=3&date=2010-07-01"))
				.andExpect(content().string("Object has validation errors"));
	}

}
