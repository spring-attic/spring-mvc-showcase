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
package org.springframework.samples.mvc.simple;

import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.http.MediaType;

public class SimpleControllerRevisitedTests {

	@Test
	public void simple() throws Exception {
		standaloneSetup(new SimpleControllerRevisited()).build()
			.perform(get("/simple/revisited").accept(MediaType.TEXT_PLAIN))
			.andExpect(status().isOk())
			.andExpect(content().contentType("text/plain"))
			.andExpect(content().string("Hello world revisited!"));
	}

}
