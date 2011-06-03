package org.springframework.samples.mvc.data.custom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomArgumentController {

	@ModelAttribute
	void beforeInvokingHandlerMethod(HttpServletRequest request) {
		request.setAttribute("foo", "bar");
	}
	
	@RequestMapping(value="/data/custom", method=RequestMethod.GET)
	public @ResponseBody String custom(@RequestAttribute("foo") String foo) {
		return "Got 'foo' request attribute value '" + foo + "'";
	}

}
