<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

  <body>  
    <p class="lead">
        <a href="https://github.com/SpringSource/spring-mvc-showcase" target="_blank">Spring MVC Showcase</a> is a great start. However Bootstrap is awesome. This project brings them together, <a href="<c:url value="/faq" />"> among other goals. <a/>
    </p>        
    
    <hr class="soften">
    
    <div class="row-fluid">              
        <div class="span3">         
          <h3>Build with Maven</h3>
            <ul>
                <li>  <code> $ mvn clean install </code> </li>               
            </ul>
        </div>
        <div class="span3">
          
          <h3>Run in Jetty</h3>
             <ul>
                 <li> <code> $ mvn jetty:run </code> </li>  
             </ul>       
        </div>
        <div class="span6">
          <h3> See Spring in action: </br> <code>http://localhost:8080/spring-mvc-showcase/ </code> </li>          
            </h3>
           <ul>
                <li> Simple Ajax @Controller </li>
                <li> Mapping Requests </li>
                <li> Obtaining Request Data </li>
                <li> Generating Responses </li>
                <li> Rendering Views </li>
                <li> Forms </li>
                <li> File Upload </li>
                <li> Validation </li>                
                <li> Exception Handling </li>
                <li> Message Converters </li>
                <li> Type Conversion </li>                
                <li> Layout Decoration (Sitemesh) </li>            
            <ul>  
        </div>
    </div>  
    </br>   
  </body>
</html>