Spring MVC Showcase
-------------------
Demonstrates the capabilities of the Spring MVC web framework through small, simple examples.
After reviewing this showcase, you should have a good understanding of what Spring MVC can do and get a feel for how easy it is to use.
Includes project code along with a supporting slideshow and screen cast.

In this showcase you'll see the following in action:

* The simplest possible @Controller
* Mapping Requests
* Obtaining Request Data
* Generating Responses
* Message Converters
* Rendering Views
* Type Conversion
* Validation
* Forms
* File Upload
* Exception Handling

To get the code:
-------------------
Clone the repository:

    $ git clone git://github.com/SpringSource/spring-mvc-showcase.git

If this is your first time using Github, review http://help.github.com to learn the basics.

To run the application:
-------------------	
From the command line with Maven:

    $ cd spring-mvc-showcase
    $ mvn tomcat:run
    
   or to use The Apache Tomcat Maven Plugin 2 (http://tomcat.apache.org/maven-plugin-2.0/)
   
    $ mvn tomcat7:run
    
or

In your preferred IDE such as SpringSource Tool Suite (STS) or IDEA:

* Import spring-mvc-showcase as a Maven Project
* Drag-n-drop the project onto the "SpringSource tc Server Developer Edition" or another Servlet 2.5 or > Server to run, such as Tomcat.

Access the deployed web application at: 
   
    http://localhost:8080/spring-mvc-showcase/ 


Other info:
-------------------
Framework version illustrated: Spring MVC 3.2

The slide presentation is located in this directory and named MasteringSpringMVC3.pdf.

A screen cast showing the showcase in action is [available in QuickTime format](http://s3.springsource.org/MVC/mvc-showcase-screencast.mov).

This showcase originated from a [blog post](http://blog.springsource.com/2010/07/22/spring-mvc-3-showcase/) and was adapted into a SpringOne presentation called [Mastering MVC 3](http://www.infoq.com/presentations/Mastering-Spring-MVC-3).

---  raw ---

add this to .m2/settings.xml
  <pluginGroups>
    <!-- pluginGroup
     | Specifies a further group identifier to use for plugin lookup.
    <pluginGroup>com.your.plugins</pluginGroup>
    -->
	 <!-- http://tomcat.apache.org/maven-plugin-2.0/ -->
	 <pluginGroup>org.apache.tomcat.maven</pluginGroup>
     <!-- http://docs.codehaus.org/display/JETTY/Maven+Jetty+Plugin -->
     <pluginGroup>org.mortbay.jetty</pluginGroup>
  </pluginGroups>

run tomcat or Jetty via maven
  
 $ mvn tomcat7:run
 
 or 
 
 $ mvn jetty:run
