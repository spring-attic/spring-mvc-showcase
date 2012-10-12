/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.mvc.response;

import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.mock.servlet.MockMvc;

public class ResponseControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
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
				.andDo(print())
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
