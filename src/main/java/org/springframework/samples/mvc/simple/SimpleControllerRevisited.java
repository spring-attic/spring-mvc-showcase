package org.springframework.samples.mvc.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleControllerRevisited {

	@GetMapping(path="/simple/revisited", headers="Accept=text/plain")
	public @ResponseBody String simple() {
		return "Hello world revisited!";
	}

}
