package org.springframework.samples.mvc.fileupload;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.samples.mvc.AjaxUtils;
import org.springframework.samples.mvc.flash.FlashMap.Message;
import org.springframework.samples.mvc.flash.FlashMap.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@RequestMapping(method=RequestMethod.GET)
	public void fileUploadForm(@RequestHeader(value="X-Requested-With", required=false) String requestedWith, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(requestedWith));	
	}

	@RequestMapping(method=RequestMethod.POST)
	public void processUpload(@RequestParam MultipartFile file, HttpServletRequest request, Model model) throws IOException {
		String message = "File '" + file.getOriginalFilename() + "' uploaded successfully";
		// prepare model for rendering success message in this request
		model.addAttribute("message", new Message(MessageType.success, message));
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxUploadRequest(request));			
	}
	
}
