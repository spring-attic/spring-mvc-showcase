package org.springframework.samples.mvc.mapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/class-mapping/*")
public class ClasslevelMappingController {

	@RequestMapping("/path")
	public @ResponseBody String byPath() {
		return "Mapped by path!";
	}

	@RequestMapping(value="/method", method=RequestMethod.GET)
	public @ResponseBody String byMethod() {
		return "Mapped by path + method";
	}

	@RequestMapping(value="/parameter", method=RequestMethod.GET, params="foo")
	public @ResponseBody String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@RequestMapping(value="/parameter", method=RequestMethod.GET, params="!foo")
	public @ResponseBody String byParameterNegation() {
		return "Mapped by path + method + not presence of query!";
	}

	@RequestMapping(value="/header", method=RequestMethod.GET, headers="Accept=text/plain")
	public @ResponseBody String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@RequestMapping(value="/notheader", method=RequestMethod.GET, headers="!FooHeader")
	public @ResponseBody String byHeaderNegation() {
		return "Mapped by path + method + not presence header!";
	}
	
	@RequestMapping(value="/*", method=RequestMethod.GET)
	public @ResponseBody String regexp() {
		return "Mapped by regexp!";
	}

}
