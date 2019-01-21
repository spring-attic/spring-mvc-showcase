package org.springframework.samples.mvc.mapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class-mapping/*")
public class ClasslevelMappingController {

	@GetMapping("/path")
	public String byPath() {
		return "Mapped by path!";
	}

	@GetMapping("/path/*")
	public String byPathPattern(HttpServletRequest request) {
		return "Mapped by path pattern ('" + request.getRequestURI() + "')";
	}

	@GetMapping("/method")
	public String byMethod() {
		return "Mapped by path + method";
	}

	@GetMapping(path="/parameter", params="foo")
	public String byParameter() {
		return "Mapped by path + method + presence of query parameter!";
	}

	@GetMapping(path="/parameter", params="!foo")
	public String byParameterNegation() {
		return "Mapped by path + method + not presence of query!";
	}

	@GetMapping(path="/header", headers="FooHeader=foo")
	public String byHeader() {
		return "Mapped by path + method + presence of header!";
	}

	@GetMapping(path="/notheader", headers="!FooHeader")
	public String byHeaderNegation() {
		return "Mapped by path + method + absence of header!";
	}


	@PostMapping(path="/consumes", consumes="application/json")
	public String byConsumes(@RequestBody JavaBean javaBean) {
		return "Mapped by path + method + consumable media type (javaBean '" + javaBean + "')";
	}

	@GetMapping(path="/produces", produces="application/json")
	public JavaBean byProduces() {
		return new JavaBean();
	}

}
