package org.springframework.samples.mvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;

@SpringBootApplication
public class Application extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(Application.class);
    }

    /**
     * @param args Used to Start web application as standalone application
     */
    public static void main(String[] args)
    {
        new SpringApplicationBuilder(Application.class).run(args);
    }

    /**
     * CSRF protection. Here we only include the CsrfFilter instead of all of Spring
     * Security. See
     * http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#csrf
     * for more information on Spring Security's CSRF protection
     */
    @Bean
    public CsrfFilter csrfFilter()
    {
        CsrfFilter csrfFilter = new CsrfFilter(new HttpSessionCsrfTokenRepository());
        return csrfFilter;
    }
    
    /**
    Provides automatic CSRF token inclusion when using Spring MVC Form tags or Thymeleaf. See
    http://localhost:8080/#forms and form.jsp for examples
     * @return 
    */
    @Bean
    public CsrfRequestDataValueProcessor requestDataValueProcessor(){
        return new CsrfRequestDataValueProcessor();
    }

}
