package org.springframework.samples.mvc.convert;

import java.util.Collection;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConvertController {

	@GetMapping("primitive")
	public String primitive(@RequestParam Integer value) {
		return "Converted primitive " + value;
	}

	// requires Joda-Time on the classpath
	@GetMapping("date/{value}")
	public String date(@PathVariable @DateTimeFormat(iso=ISO.DATE) Date value) {
		return "Converted date " + value;
	}

	@GetMapping("collection")
	public String collection(@RequestParam Collection<Integer> values) {
		return "Converted collection " + values;
	}

	@GetMapping("formattedCollection")
	public String formattedCollection(@RequestParam @DateTimeFormat(iso=ISO.DATE) Collection<Date> values) {
		return "Converted formatted collection " + values;
	}

	@GetMapping("bean")
	public String bean(JavaBean bean) {
		return "Converted " + bean;
	}

	@GetMapping("value")
	public String valueObject(@RequestParam SocialSecurityNumber value) {
		return "Converted value object " + value;
	}

	@GetMapping("custom")
	public String customConverter(@RequestParam @MaskFormat("###-##-####") String value) {
		return "Converted '" + value + "' with a custom converter";
	}

}
