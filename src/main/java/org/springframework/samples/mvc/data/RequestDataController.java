package org.springframework.samples.mvc.data;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/data/*")
public class RequestDataController {

	@RequestMapping(value="param")
	public @ResponseBody String withParam(@RequestParam String foo) {
		return "Obtained 'foo' query parameter value '" + foo + "'";
	}

	@RequestMapping(value="group")
	public @ResponseBody String withParamGroup(JavaBean bean) {
		return "Obtained parameter group " + bean;
	}

	@RequestMapping(value="path/{var}")
	public @ResponseBody String withPathVariable(@PathVariable String var) {
		return "Obtained 'var' path variable value '" + var + "'";
	}

	@RequestMapping(value="header")
	public @ResponseBody String withHeader(@RequestHeader String Accept) {
		return "Obtained 'Accept' header '" + Accept + "'";
	}

	@RequestMapping(value="cookie")
	public @ResponseBody String withCookie(@CookieValue String openid_provider) {
		return "Obtained 'openid_provider' cookie '" + openid_provider + "'";
	}

	@RequestMapping(value="body", method=RequestMethod.POST)
	public @ResponseBody String withBody(@RequestBody String body) {
		return "Posted request body '" + body + "'";
	}

	@RequestMapping(value="entity", method=RequestMethod.POST)
	public @ResponseBody String withEntity(HttpEntity<String> entity) {
		return "Posted request body '" + entity.getBody() + "'; headers = " + entity.getHeaders();
	}

}
