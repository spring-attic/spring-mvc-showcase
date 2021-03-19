package org.springframework.samples.mvc.views;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/*")
public class ViewsController {

	@GetMapping("html")
	public String prepare(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
		return "views/html";
	}
	
	@GetMapping("/viewName")
	public void usingRequestToViewNameTranslator(Model model) {
		model.addAttribute("foo", "bar");
		model.addAttribute("fruit", "apple");
	}

	@GetMapping("pathVariables/{foo}/{fruit}")
	public String pathVars(@PathVariable String foo, @PathVariable String fruit) {
		// No need to add @PathVariables "foo" and "fruit" to the model
		// They will be merged in the model before rendering
		return "views/html";
	}

	@GetMapping("dataBinding/{foo}/{fruit}")
	public String dataBinding(@Valid JavaBean javaBean, Model model) {
		// JavaBean "foo" and "fruit" properties populated from URI variables 
		return "views/dataBinding";
	}

}
