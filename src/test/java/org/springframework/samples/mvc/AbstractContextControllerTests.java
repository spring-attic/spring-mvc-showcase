package org.springframework.samples.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.mvc.config.WebMvcConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration(classes = WebMvcConfig.class)
public class AbstractContextControllerTests {

	@Autowired
	protected WebApplicationContext wac;

}
