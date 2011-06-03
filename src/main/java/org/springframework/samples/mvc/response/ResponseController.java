package org.springframework.samples.mvc.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseController {

	@RequestMapping(value="/response/annotation", method=RequestMethod.GET)
	public @ResponseBody String responseBody() {
		return "The String ResponseBody";
	}

	@RequestMapping(value="/response/entity/status", method=RequestMethod.GET)
	public ResponseEntity<String> responseEntityStatusCode() {
		return new ResponseEntity<String>("The String ResponseBody with custom status code (403 Forbidden)",
				HttpStatus.FORBIDDEN);
	}

	@RequestMapping(value="/response/entity/headers", method=RequestMethod.GET)
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
				headers, HttpStatus.OK);
	}

}
