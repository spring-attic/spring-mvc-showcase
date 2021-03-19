package org.springframework.samples.mvc.exceptions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.web.servlet.MockMvc;

public class ExceptionControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void controllerExceptionHandler() throws Exception {
		this.mockMvc.perform(get("/exception"))
				.andExpect(status().isOk())
				.andExpect(content().string("IllegalStateException handled!"));
	}

	@Test
	public void globalExceptionHandler() throws Exception {
		this.mockMvc.perform(get("/global-exception"))
				.andExpect(status().isOk())
				.andExpect(content().string("Handled BusinessException"));
	}

}
