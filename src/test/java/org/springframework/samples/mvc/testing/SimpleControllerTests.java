package org.springframework.samples.mvc.testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.samples.mvc.simple.SimpleController;

public class SimpleControllerTests {

	@Test
	public void test() {
		SimpleController controller = new SimpleController();
		assertEquals("Hello world!", controller.simple());
	}
}
