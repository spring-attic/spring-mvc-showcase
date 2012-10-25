package org.springframework.samples.mvc.async;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.async.WebAsyncManager;
import org.springframework.web.context.request.async.WebAsyncUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CustomTimeoutHandlerInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(CustomTimeoutHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			final HttpServletResponse response, final Object handler) throws Exception {

		WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
		asyncManager.setTimeoutHandler(new Runnable() {
			@Override
			public void run() {
				try {
					logger.debug("Custom time out handler called");
					response.sendError(503, "Async execution of [" + handler + "] did not complete on time");
				}
				catch (IOException e) {
					logger.error("Timeout not handled", e);
				}
			}
		});

		logger.debug("Registered custom timeout handler");

		return true;
	}

}
