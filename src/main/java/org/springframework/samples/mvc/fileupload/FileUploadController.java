package org.springframework.samples.mvc.fileupload;

import java.io.IOException;

import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.mvc.extensions.flash.FlashMap.Message;
import org.springframework.mvc.extensions.flash.FlashMap.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@RequestMapping(method=RequestMethod.GET)
	public void fileUploadForm(WebRequest webRequest, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(webRequest));	
	}

	@RequestMapping(method=RequestMethod.POST)
	public void processUpload(@RequestParam MultipartFile file, WebRequest webRequest, Model model) throws IOException {
		String message = "File '" + file.getOriginalFilename() + "' uploaded successfully";
		// prepare model for rendering success message in this request
		model.addAttribute("message", new Message(MessageType.success, message));
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxUploadRequest(webRequest));			
	}
	
}
