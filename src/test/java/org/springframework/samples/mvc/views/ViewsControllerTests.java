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
package org.springframework.samples.mvc.views;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.mock.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
public class ViewsControllerTests extends AbstractContextControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
	}

	@Test
	public void htmlView() throws Exception {
		this.mockMvc.perform(get("/views/html"))
				.andExpect(view().name(containsString("views/html")))
				.andExpect(model().attribute("foo", "bar"))
				.andExpect(model().attribute("fruit", "apple"))
				.andExpect(model().size(2));
	}

	@Test
	public void viewName() throws Exception {
		this.mockMvc.perform(get("/views/viewName"))
				.andExpect(view().name(containsString("views/viewName")))
				.andExpect(model().attribute("foo", "bar"))
				.andExpect(model().attribute("fruit", "apple"))
				.andExpect(model().size(2));
	}

	@Test
	public void uriTemplate() throws Exception {
		this.mockMvc.perform(get("/views/pathVariables/bar/apple"))
				.andExpect(view().name(containsString("views/html")));
	}
}
