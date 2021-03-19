package org.springframework.samples.mvc.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.samples.mvc.async.TimeoutCallableProcessingInterceptor;
import org.springframework.samples.mvc.convert.MaskFormatAnnotationFormatterFactory;
import org.springframework.samples.mvc.data.custom.CustomArgumentResolver;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

// DispatcherServlet context: defines Spring MVC infrastructure
// and web application components

@Configuration
@ComponentScan(basePackages = "org.springframework.samples.mvc")
@EnableWebMvc
@EnableScheduling
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldAnnotation(new MaskFormatAnnotationFormatterFactory());
	}

	/* Equivalent XML Configuration is
      @// @formatter:off
      <argument-resolvers>
            <beans:bean class="org.springframework.samples.mvc.data.custom.CustomArgumentResolver"/>
        </argument-resolvers>
        // @formatter:on
     */
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new CustomArgumentResolver());
	}

	// Handle HTTP GET requests for /resources/** by efficiently serving
	// static resources under ${webappRoot}/resources/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		UrlPathHelper pathHelper = new UrlPathHelper();
		pathHelper.setRemoveSemicolonContent(false); // For @MatrixVariable's
		configurer.setUrlPathHelper(pathHelper);
	}

	/* Equivalent XML Configuration is
    @// @formatter:off

        <async-support default-timeout="3000">
            <callable-interceptors>
                <beans:bean class="org.springframework.samples.mvc.async.TimeoutCallableProcessingInterceptor" />
            </callable-interceptors>
        </async-support>

    // @formatter:on
    */
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		configurer.setDefaultTimeout(3000);
		configurer.registerCallableInterceptors(new TimeoutCallableProcessingInterceptor());
	}

	/*
     * Only needed because we require fileupload in the
     * org.springframework.samples.mvc.fileupload package
     * Bean name must be "multipartResolver", by default Spring uses method name as bean name.
     *
     * Spring uses MultipartResolver interface to handle the file uploads in web application, two of the implementation :
        1. StandardServletMultipartResolver – Servlet 3.0 multipart request parsing.
        2. CommonsMultipartResolver – Classic commons-fileupload.jar
     */
	@Bean
	public MultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}
