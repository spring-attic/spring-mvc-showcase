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
import org.springframework.samples.mvc.data.standard.StandardArgumentsController;
import org.springframework.test.web.mock.servlet.MockMvc;

public class StandardArgumentsControllerTests {
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(new StandardArgumentsController()).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void request() throws Exception {
		this.mockMvc.perform(get("/data/standard/request"))
				.andExpect(content().string(startsWith(
						"request = org.springframework.test.web.mock.servlet.request.Servlet3MockHttpServletRequest@")));
	}

	@Test
	public void requestReader() throws Exception {
		this.mockMvc.perform(
				post("/data/standard/request/reader")
					.contentType(MediaType.TEXT_PLAIN)
					.content("foo".getBytes()))
				.andExpect(content().string("Read char request body = foo"));
	}

	@Test
	public void requestIs() throws Exception {
		this.mockMvc.perform(
				post("/data/standard/request/is")
					.contentType(MediaType.TEXT_PLAIN)
					.content("foo".getBytes()))
				.andExpect(content().string("Read binary request body = foo"));
	}

	@Test
	public void response() throws Exception {
		this.mockMvc.perform(get("/data/standard/response"))
				.andExpect(content().string(startsWith(
						"response = org.springframework.mock.web.MockHttpServletResponse@")));
	}

	@Test
	public void writer() throws Exception {
		this.mockMvc.perform(get("/data/standard/response/writer"))
				.andExpect(content().string("Wrote char response using Writer"));
	}

	@Test
	public void os() throws Exception {
		this.mockMvc.perform(get("/data/standard/response/os"))
				.andExpect(content().string("Wrote binary response using OutputStream"));
	}

	@Test
	public void session() throws Exception {
		this.mockMvc.perform(get("/data/standard/session"))
				.andExpect(content().string(startsWith(
						"session=org.springframework.mock.web.MockHttpSession@")));
	}

}
