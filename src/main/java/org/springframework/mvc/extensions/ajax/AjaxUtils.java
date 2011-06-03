package org.springframework.mvc.extensions.ajax;

import javax.servlet.http.HttpServletRequest;

public class AjaxUtils {

	public static boolean isAjaxRequest(String requestedWith) {
		return requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;
	}

	public static boolean isAjaxUploadRequest(HttpServletRequest request) {
		return request.getParameter("ajaxUpload") != null;
	}
	
	private AjaxUtils() {}

}
