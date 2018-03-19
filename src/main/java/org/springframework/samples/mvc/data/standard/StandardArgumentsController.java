package org.springframework.samples.mvc.data.standard;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.security.Principal;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StandardArgumentsController {

	// request related
	
	@GetMapping("/data/standard/request")
	public String standardRequestArgs(HttpServletRequest request, Principal user, Locale locale) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("request = ").append(request).append(", ");
		buffer.append("userPrincipal = ").append(user).append(", ");
		buffer.append("requestLocale = ").append(locale);
		return buffer.toString();
	}

	@PostMapping("/data/standard/request/reader")
	public String requestReader(Reader requestBodyReader) throws IOException {
		return "Read char request body = " + FileCopyUtils.copyToString(requestBodyReader);
	}

	@PostMapping("/data/standard/request/is")
	public String requestReader(InputStream requestBodyIs) throws IOException {
		return "Read binary request body = " + new String(FileCopyUtils.copyToByteArray(requestBodyIs));
	}
	
	// response related

	@GetMapping("/data/standard/response")
	public String response(HttpServletResponse response) {
		return "response = " + response;
	}

	@GetMapping("/data/standard/response/writer")
	public void availableStandardResponseArguments(Writer responseWriter) throws IOException {
		responseWriter.write("Wrote char response using Writer");
	}
	
	@GetMapping("/data/standard/response/os")
	public void availableStandardResponseArguments(OutputStream os) throws IOException {
		os.write("Wrote binary response using OutputStream".getBytes());
	}
	
	// HttpSession

	@GetMapping("/data/standard/session")
	public String session(HttpSession session) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("session=").append(session);
		return buffer.toString();
	}

}
