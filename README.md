# SpringMVC Twitter Bootstrap Showcase

## Overview
[Spring MVC Showcase](https://github.com/SpringSource/spring-mvc-showcase) built with JQuery-UI is a great start. It demonstrates the capabilities of the Spring MVC web framework through small, simple examples. After reviewing this showcase, you should have a good understanding of what Spring MVC can do and get a feel for how easy it is to use. 

 However [Bootstrap](http://twitter.github.com/bootstrap/) is awesome. 

 This fork brings them together, along with other goals:

- Use only embedded servers (jetty, h2, etc.,)
- Decorate Layouts with [Sitemesh](http://www.sitemesh.org/)
- Move page-specific js into a commmon js
- Incorporate Themes from [Bootswatch](http://bootswatch.com)
- Build the tutorial into the app?
- Extend showcase with more features, gotchas, best practices?     
- Integrate [Spring Social](http://www.springsource.org/spring-social) and [Spring Data](http://www.springsource.org/spring-data)?

## Live Demo
http://springmvc-twbootstrap-showcase.cloudfoundry.com

## Run locally with Maven
1. Build 
> $ mvn clean install
2. Run
> $ mvn jetty:run
3. Access the deployed web application at: http://localhost:8080/spring-mvc-showcase/

## Tutorials
- [The original blog](http://blog.springsource.com/2010/07/22/spring-mvc-3-showcase/)
- A [screencast](http://s3.springsource.org/MVC/mvc-showcase-screencast.mov) showing the showcase in action
- The presentation is located in this directory (MasteringSpringMVC3.pdf)

