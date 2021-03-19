package org.springframework.samples.mvc.data.custom;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomArgumentResolver implements HandlerMethodArgumentResolver {

	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.getParameterAnnotation(RequestAttribute.class) != null;
	}

	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
			throws Exception {

		RequestAttribute attr = parameter.getParameterAnnotation(RequestAttribute.class);
		return webRequest.getAttribute(attr.value(), WebRequest.SCOPE_REQUEST);
	}
	
}
