package org.springframework.samples.mvc.response;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class ResponseControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new ResponseController()).build();
	}

	@Test
	public void responseBody() throws Exception {
		this.mockMvc.perform(get("/response/annotation"))
				.andExpect(status().isOk())
				.andExpect(content().string("The String ResponseBody"));
	}

	@Test
	public void responseCharsetAccept() throws Exception {
		this.mockMvc.perform(
				get("/response/charset/accept")
					.accept(new MediaType("text", "plain", Charset.forName("UTF-8"))))
				.andExpect(status().isOk())
				.andExpect(content().string(
						"\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)"));
	}

	@Test
	public void responseCharsetProduce() throws Exception {
		this.mockMvc.perform(get("/response/charset/produce"))
				.andExpect(status().isOk())
				.andExpect(content().string(
						"\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)"));
	}

	@Test
	public void responseEntityStatus() throws Exception {
		this.mockMvc.perform(get("/response/entity/status"))
				.andExpect(status().isForbidden())
				.andExpect(content().string(
						"The String ResponseBody with custom status code (403 Forbidden)"));
	}

	@Test
	public void responseEntityHeaders() throws Exception {
		this.mockMvc.perform(get("/response/entity/headers"))
				.andExpect(status().isOk())
				.andExpect(content().string(
						"The String ResponseBody with custom header Content-Type=text/plain"));
	}

}
