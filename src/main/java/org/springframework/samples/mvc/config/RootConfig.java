package org.springframework.samples.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

// Root Context: defines shared resources visible to all other web components

@Configuration
public class RootConfig {

	// CSRF protection. Here we only include the CsrfFilter instead of all of Spring Security.
	// See https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#csrf
	// for more information on Spring Security's CSRF protection

	@Bean
	public CsrfFilter csrfFilter() {
		return new CsrfFilter(new HttpSessionCsrfTokenRepository());
	}

	// Provides automatic CSRF token inclusion when using Spring MVC Form tags or Thymeleaf.
	// See http://localhost:8080/#forms and form.jsp for examples

	@Bean
	public RequestDataValueProcessor requestDataValueProcessor() {
		return new CsrfRequestDataValueProcessor();
	}
}
