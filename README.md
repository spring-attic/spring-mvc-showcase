# Spring Bootstrap Showcase

The unofficial Spring MVC Showcase with Bootstrap.

A fork of [Spring MVC Showcase](https://github.com/SpringSource/spring-mvc-showcase), replacing JQuery-UI with [Bootstrap](http://twitter.github.com/bootstrap/),
Tomcat with Jetty, Tiles with [Sitemesh](http://www.sitemesh.org/), and other goodies.

For a complex use of Spring/JQuery/Bootstrap/Ajax, see my [Spring Best Practices App](https://github.com/priyatam/spring-best-practices).

Branches:

- Spring 4.1.0 / Bootstrap 3.2 - Master
- Spring 3.2.5 / Bootstrap 3.0 - [Branch 3.X](https://github.com/priyatam/springmvc-bootstrap-showcase/tree/3.x))
- Spring 3.1.0 / Bootstrap 2.3 - [Branch 2.X](https://github.com/priyatam/springmvc-bootstrap-showcase/tree/2.x))

Live Demo on Heroku.

> http://spring-bootstrap.herokuapp.com/

## Usage

1. mvn clean install
2. mvn jetty:run
3. http://localhost:8080/spring-mvc-showcase/

Note that the user-interface in these example are basic and don't' utilize the full power of Bootstrap and Less. If you're interested in a modern,
minimalist frontend development without Java, and with GulpJs, Bootstrap and Less, checkout [Lesser](https://github.com/priyatam/lesser).

## Tutorials
- [The original blog](http://blog.springsource.com/2010/07/22/spring-mvc-3-showcase/)
- [Screencast](http://s3.springsource.org/MVC/mvc-showcase-screencast.mov) showing the showcase in action

## Status

I now code primarily in Clojure and Nodejs and no longer active in Java. 

If you're interested in maintaining this repo, including a complete refactor of the frontend with Backbone/Angular and Bootstrap/Less,
please email me.