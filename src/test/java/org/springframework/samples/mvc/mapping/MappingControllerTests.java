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
package org.springframework.samples.mvc.mapping;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.mock.servlet.MockMvc;

public class MappingControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(new MappingController()).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void byPath() throws Exception {
		this.mockMvc.perform(get("/mapping/path")).andExpect(content().string("Mapped by path!"));
	}

	@Test
	public void byPathPattern() throws Exception {
		this.mockMvc.perform(get("/mapping/path/wildcard"))
				.andExpect(content().string("Mapped by path pattern ('/mapping/path/wildcard')"));
	}

	@Test
	public void byMethod() throws Exception {
		this.mockMvc.perform(get("/mapping/method"))
				.andExpect(content().string("Mapped by path + method"));
	}

	@Test
	public void byParameter() throws Exception {
		this.mockMvc.perform(get("/mapping/parameter?foo=bar"))
				.andExpect(content().string("Mapped by path + method + presence of query parameter!"));
	}

	@Test
	public void byNotParameter() throws Exception {
		this.mockMvc.perform(get("/mapping/parameter"))
				.andExpect(content().string("Mapped by path + method + not presence of query parameter!"));
	}

	@Test
	public void byHeader() throws Exception {
		this.mockMvc.perform(get("/mapping/header").header("FooHeader", "foo"))
				.andExpect(content().string("Mapped by path + method + presence of header!"));
	}

	@Test
	public void byHeaderNegation() throws Exception {
		this.mockMvc.perform(get("/mapping/header"))
				.andExpect(content().string("Mapped by path + method + absence of header!"));
	}

	@Test
	public void byConsumes() throws Exception {
		this.mockMvc.perform(
				post("/mapping/consumes")
					.contentType(MediaType.APPLICATION_JSON)
					.content("{ \"foo\": \"bar\", \"fruit\": \"apple\" }".getBytes()))
				.andExpect(content().string(startsWith("Mapped by path + method + consumable media type (javaBean")));
	}

	@Test
	public void byProduces() throws Exception {
		this.mockMvc.perform(get("/mapping/produces").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.foo").value("bar"))
				.andExpect(jsonPath("$.fruit").value("apple"));
	}

}
