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
package org.springframework.samples.mvc.fileupload;

import static org.springframework.test.web.mock.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.mock.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.mock.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.samples.mvc.AbstractContextControllerTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class FileUploadControllerTests extends AbstractContextControllerTests {

	@Test
	public void readString() throws Exception {

		MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());

		webAppContextSetup(this.wac).build()
				.perform(fileUpload("/fileupload").file(file))
				.andExpect(model().attribute("message", "File 'orig' uploaded successfully"));
	}

}
