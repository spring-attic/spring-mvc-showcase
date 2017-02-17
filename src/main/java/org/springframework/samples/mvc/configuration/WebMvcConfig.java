package org.springframework.samples.mvc.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.samples.mvc.async.TimeoutCallableProcessingInterceptor;
import org.springframework.samples.mvc.convert.MaskFormatAnnotationFormatterFactory;
import org.springframework.samples.mvc.data.custom.CustomArgumentResolver;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableScheduling // XML Equivalent of task:annotation-driven
public class WebMvcConfig extends WebMvcConfigurerAdapter
{
    /* Maps '/' requests to the 'home' view */
    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/home").setViewName("home");
        registry.addRedirectViewController("/", "/home");
        super.addViewControllers(registry);
    }

    /*
     * In order to enable Spring MVC Matrix Variables equivalent xml config is
     * annotation-driven enable-matrix-variables="true"
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer)
    {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    /* Equivalent XML Configuration is 
      @// @formatter:off
      <argument-resolvers>
            <beans:bean class="org.springframework.samples.mvc.data.custom.CustomArgumentResolver"/>
        </argument-resolvers>
        // @formatter:on
     */
    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers)
    {
        // equivalent to <mvc:argument-resolvers>
        argumentResolvers.add(new CustomArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
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
    public void configureAsyncSupport(AsyncSupportConfigurer configurer)
    {
        configurer.setDefaultTimeout(3000);
        configurer.registerCallableInterceptors(timeoutInterceptor());
        super.configureAsyncSupport(configurer);
    }

    @Bean
    public CallableProcessingInterceptor timeoutInterceptor()
    {
        return new TimeoutCallableProcessingInterceptor();
    }

    /*
     * Only needed because we install custom converters to support the examples in the
     * org.springframewok.samples.mvc.convert package
     */
    @Override
    public void addFormatters(FormatterRegistry registry)
    {
        registry.addFormatterForFieldAnnotation(
                new MaskFormatAnnotationFormatterFactory());
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
    public MultipartResolver multipartResolver()
    {
        return new StandardServletMultipartResolver();
    }

}
