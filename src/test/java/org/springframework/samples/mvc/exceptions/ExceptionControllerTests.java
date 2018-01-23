package org.springframework.samples.mvc.exceptions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
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
