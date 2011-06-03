package org.springframework.samples.mvc.data.custom;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

public class CustomArgumentResolver implements WebArgumentResolver {

	public Object resolveArgument(MethodParameter param, NativeWebRequest request) throws Exception {
		RequestAttribute attr = param.getParameterAnnotation(RequestAttribute.class);
		if (attr != null) {
			return request.getAttribute(attr.value(), WebRequest.SCOPE_REQUEST);
		} else {
			return WebArgumentResolver.UNRESOLVED;
		}
	}
	
}
