package org.springframework.samples.mvc.form;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.mvc.extensions.flash.FlashMap;
import org.springframework.mvc.extensions.flash.FlashMap.Message;
import org.springframework.mvc.extensions.flash.FlashMap.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("/form")
public class FormController {

	@RequestMapping(method=RequestMethod.GET)
	public void form(WebRequest webRequest, HttpSession session, Model model) {
		FormBean form = (FormBean) session.getAttribute("form");
		model.addAttribute(form != null ? form : new FormBean());
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(webRequest));
	}

	@RequestMapping(method=RequestMethod.POST)
	public String processSubmit(@Valid FormBean form, BindingResult result, WebRequest webRequest, HttpSession session, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(webRequest));
			return null;
		}
		// simply store form bean in the session for demo purposes, typically you would save form bean values to a db
		session.setAttribute("form", form);
		String message = "Form submitted successfully.  Bound " + form;
		// success response handling
		if (AjaxUtils.isAjaxRequest(webRequest)) {
			// prepare model for rendering success message in this request
			model.addAttribute("message", new Message(MessageType.success, message));
			model.addAttribute("ajaxRequest", true);
			return null;
		} else {
			// store a success message for rendering on the next request after redirect
			FlashMap.setSuccessMessage(message);
			// redirect back to the form to render the success message along with newly bound values
			return "redirect:/form";			
		}
	}
	
}
