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
package org.springframework.samples.mvc.validation;

import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.mock.servlet.MockMvc;

public class ValidationControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
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
				.andDo(print())
				.andExpect(content().string("Object has validation errors"));
	}

}
