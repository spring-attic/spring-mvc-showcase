package org.springframework.samples.mvc.data;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.mock.servlet.MockMvc;

public class DataControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(new RequestDataController()).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void param() throws Exception {
		this.mockMvc.perform(get("/data/param?foo=bar"))
				.andExpect(content().string("Obtained 'foo' query parameter value 'bar'"));
	}

	@Test
	public void group() throws Exception {
		this.mockMvc.perform(get("/data/group?param1=foo&param2=bar&param3=baz"))
				.andExpect(content().string(startsWith(
						"Obtained parameter group org.springframework.samples.mvc.data.JavaBean@")));
	}

	@Test
	public void pathvar() throws Exception {
		this.mockMvc.perform(get("/data/path/foo"))
				.andExpect(content().string("Obtained 'var' path variable value 'foo'"));
	}

	@Test
	public void header() throws Exception {
		this.mockMvc.perform(get("/data/header").accept(MediaType.ALL))
				.andExpect(content().string("Obtained 'Accept' header '*/*'"));
	}

	@Test
	public void requestBody() throws Exception {
		this.mockMvc.perform(
				post("/data/body")
					.contentType(MediaType.TEXT_PLAIN)
					.content("foo".getBytes()))
				.andExpect(content().string("Posted request body 'foo'"));
	}

	@Test
	public void requestBodyAndHeaders() throws Exception {
		this.mockMvc.perform(
				post("/data/entity")
					.contentType(MediaType.TEXT_PLAIN)
					.content("foo".getBytes()))
				.andExpect(content().string(
						"Posted request body 'foo'; headers = {Content-Type=[text/plain], Content-Length=[3]}"));
	}

}
