package org.springframework.samples.mvc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

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

}
