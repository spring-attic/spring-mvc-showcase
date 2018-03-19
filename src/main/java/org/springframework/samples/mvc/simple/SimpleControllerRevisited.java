package org.springframework.samples.mvc.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleControllerRevisited {

	@GetMapping(path="/simple/revisited", headers="Accept=text/plain")
	public String simple() {
		return "Hello world revisited!";
	}

}
