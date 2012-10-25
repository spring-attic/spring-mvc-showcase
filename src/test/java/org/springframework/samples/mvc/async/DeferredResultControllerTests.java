package org.springframework.samples.mvc.async;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
public class DeferredResultControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}

	@Test
	public void responseBody() throws Exception {
		this.mockMvc.perform(get("/async/deferred-result/response-body"))
			.andExpect(status().isOk())
			.andExpect(request().asyncStarted())
			.andExpect(request().asyncResult("Deferred result"));
	}

	@Test
	public void view() throws Exception {

		MvcResult mvcResult = this.mockMvc.perform(get("/async/deferred-result/model-and-view"))
			.andExpect(status().isOk())
			.andExpect(request().asyncStarted())
			.andExpect(request().asyncResult(instanceOf(ModelAndView.class)))
			.andReturn();

		ModelAndView mav = (ModelAndView) mvcResult.getAsyncResult();
		assertEquals("views/html", mav.getViewName());
	}

	@Test
	public void exception() throws Exception {
		this.mockMvc.perform(get("/async/deferred-result/exception"))
			.andExpect(status().isOk())
			.andExpect(request().asyncStarted())
			.andExpect(request().asyncResult(instanceOf(IllegalStateException.class)));
	}

}
