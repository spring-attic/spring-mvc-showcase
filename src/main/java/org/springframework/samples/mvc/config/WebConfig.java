package org.springframework.samples.mvc.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
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
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableScheduling
public class WebConfig extends WebMvcConfigurerAdapter
{
    /* In order to enable Spring MVC Matrix Variables */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer)
    {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/home").setViewName("home");
        registry.addRedirectViewController("/", "/home");
        super.addViewControllers(registry);
    }

    @Override
    public void addArgumentResolvers(
            List<HandlerMethodArgumentResolver> argumentResolvers)
    {
        // equivalent to <mvc:argument-resolvers>
        argumentResolvers.add(new CustomArgumentResolver());
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer)
    {
        super.configureAsyncSupport(configurer);
        configurer.registerCallableInterceptors(timeoutInterceptor());
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

    @Bean
    public TimeoutCallableProcessingInterceptor timeoutInterceptor()
    {
        return new TimeoutCallableProcessingInterceptor();
    }

    /*
     * Only needed because we require fileupload in the
     * org.springframework.samples.mvc.fileupload package
     */
    @Bean
    public MultipartResolver multipartResolver()
    {
        return new CommonsMultipartResolver();
    }

}
