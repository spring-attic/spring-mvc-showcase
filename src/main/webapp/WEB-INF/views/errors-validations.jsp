<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<body>

  <div class="tabbable" id="demo-tab"> <!-- Only required for left/right tabs -->
    <!-- Tab Definitions-->               
    <ul class="nav nav-tabs">
      <li class="active"><a href="#validation" data-toggle="tab">Validation</a></li>
      <li><a href="#exceptions" data-toggle="tab">Exception Handling</a></li>      
    </ul>  

    <!-- Tab Content-->
    <div class="tab-content">                  
      <div class="tab-pane" id="validation">
        <h2>Validation</h2>
        <p>
          See the <code>org.springframework.samples.mvc.validation</code> package for the @Controller code  
        </p>
        <ul>
          <li>
            <a id="validateNoErrors" class="textLink" href="<c:url value="/validate?number=3&date=2029-07-04" />">Validate, no errors</a>
          </li>
          <li>
            <a id="validateErrors" class="textLink" href="<c:url value="/validate?number=3&date=2010-07-01" />">Validate, errors</a>
          </li>
        </ul> 
      </div>
      <div class="tab-pane" id="exceptions">
        <h2>Exception Handling</h2>
        <p>
          See the <code>org.springframework.samples.mvc.exceptions</code> package for the @Controller code  
        </p>
        <ul>
          <li>
            <a id="exception" class="textLink" href="<c:url value="/exception" />">@Controller Exception handling</a>
          </li>
        </ul>
      </div> 
    </div> <!--tab-content-->
  </div> <!--tabbable-->   

</body>
</html>