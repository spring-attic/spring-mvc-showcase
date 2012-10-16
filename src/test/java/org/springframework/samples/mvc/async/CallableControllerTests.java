package org.springframework.samples.mvc.async;

import static org.hamcrest.Matchers.instanceOf;
import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.mock.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
public class CallableControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void responseBody() throws Exception {
		this.mockMvc.perform(get("/async/callable/response-body"))
			.andExpect(status().isOk())
			.andExpect(request().asyncStarted())
			.andExpect(request().asyncResult("Callable result"));
	}

	@Test
	public void view() throws Exception {
		this.mockMvc.perform(get("/async/callable/view"))
			.andExpect(status().isOk())
			.andExpect(request().asyncStarted())
			.andExpect(request().asyncResult("views/html"));
	}

	@Test
	public void exception() throws Exception {
		this.mockMvc.perform(get("/async/callable/exception"))
			.andExpect(status().isOk())
			.andExpect(request().asyncStarted())
			.andExpect(request().asyncResult(instanceOf(IllegalStateException.class)));
	}

}
