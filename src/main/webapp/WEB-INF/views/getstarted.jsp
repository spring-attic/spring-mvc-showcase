<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<body>

  <div class="tabbable" id="demo-tab"> <!-- Only required for left/right tabs -->
    <!-- Tab Definitions-->               
    <ul class="nav nav-tabs" id="getStartedTab">
      <li class="active"><a href="#simple" data-toggle="tab">Simple Ajax</a></li>
      <li><a href="#mapping" data-toggle="tab">Mapping Requests</a></li>
      <li><a href="#data" data-toggle="tab">Obtaining Request Data</a></li>
      <li><a href="#responses" data-toggle="tab">Writing Responses</a></li>
      <li><a href="#redirect" data-toggle="tab">Redirecting</a></li>  
      <li><a href="#views" data-toggle="tab">Rendering Views</a></li>
    </ul>  

    <!-- Tab Content-->
    <div class="tab-content">                  
      <div class="tab-pane" id="simple">
        <h2>Simple</h2>
        <p>
          See the <code>org.springframework.samples.mvc.simple</code> package for the @Controller code
        </p>
        <ul>
          <li>
            <a id="simpleLink" class="textLink" href="<c:url value="/simple" />">GET /simple</a>
          </li>
          <li>
            <a id="simpleRevisited" class="textLink" href="<c:url value="/simple/revisited" />">GET /simple/revisited</a>
          </li>
        </ul>
      </div>

      <div class="tab-pane" id="mapping">
        <h2>Mapping Requests</h2>
        <p>
          See the <code>org.springframework.samples.mvc.mapping</code> package for the @Controller code
        </p>
        <ul>
          <li>
            <a id="byPath" class="textLink" href="<c:url value="/mapping/path" />">By path</a>
          </li>
          <li>
            <a id="byPathPattern" class="textLink" href="<c:url value="/mapping/path/wildcard" />">By path pattern</a>
          </li>
          <li>
            <a id="byMethod" class="textLink" href="<c:url value="/mapping/method" />">By path and method</a>
          </li>
          <li>
            <a id="byParameter" class="textLink" href="<c:url value="/mapping/parameter?foo=bar" />">By path, method, and presence of parameter</a>
          </li>
          <li>
            <a id="byNotParameter" class="textLink" href="<c:url value="/mapping/parameter" />">By path, method, and not presence of parameter</a>
          </li>
          <li>
            <a id="byHeader" href="<c:url value="/mapping/header" />">By presence of header</a>
          </li>
          <li>
            <a id="byHeaderNegation" class="textLink" href="<c:url value="/mapping/header" />">By absence of header</a>
          </li>
          <li>
            <form id="byConsumes" class="readJsonForm" action="<c:url value="/mapping/consumes" />" method="post">
              <input id="byConsumesSubmit" type="submit" value="By consumes" class="btn btn-primary"/>
            </form>
          </li>
          <li>
            <a id="byProduces" class="writeJsonLink" href="<c:url value="/mapping/produces" />">By produces</a>
          </li>
        </ul>
      </div>

      <div class="tab-pane" id="data">
        <h2>Obtaining Request Data</h2>
        <p>
          See the <code>org.springframework.samples.mvc.data</code> package for the @Controller code
        </p>
        <ul>
          <li>
            <a id="param" class="textLink" href="<c:url value="/data/param?foo=bar" />">Query parameter</a>
          </li>
          <li>
            <a id="group" class="textLink" href="<c:url value="/data/group?param1=foo&param2=bar&param3=baz" />">Group of query parameters</a>
          </li>
          <li>
            <a id="var" class="textLink" href="<c:url value="/data/path/foo" />">Path variable</a>
          </li>
          <li>
            <a id="header" class="textLink" href="<c:url value="/data/header" />">Header</a>
          </li>
          <li>
            <form id="requestBody" class="textForm" action="<c:url value="/data/body" />" method="post">
              <input id="requestBodySubmit" type="submit" value="Request Body" class="btn btn-primary"/>
            </form>
          </li>       
          <li>
            <form id="requestBodyAndHeaders" class="textForm" action="<c:url value="/data/entity" />" method="post">
              <input id="requestBodyAndHeadersSubmit" type="submit" value="Request Body and Headers" class="btn btn-primary" />
            </form>
          </li>
        </ul> 
        <div id="standardArgs">
          <h3>Standard Resolvable Web Arguments</h3>
          <ul>
            <li>
              <a id="request" class="textLink" href="<c:url value="/data/standard/request" />">Request arguments</a>        
            </li>
            <li>
              <form id="requestReader" class="textForm" action="<c:url value="/data/standard/request/reader" />" method="post">
                <input id="requestReaderSubmit" type="submit" value="Request Reader" class="btn btn-primary" />
              </form>
            </li>     
            <li>
              <form id="requestIs" class="textForm" action="<c:url value="/data/standard/request/is" />" method="post">
                <input id="requestIsSubmit" type="submit" value="Request InputStream" class="btn btn-primary"/>
              </form>
            </li>
            <li>
              <a id="response" class="textLink" href="<c:url value="/data/standard/response" />">Response arguments</a>       
            </li>     
            <li>
              <a id="writer" class="textLink" href="<c:url value="/data/standard/response/writer" />">Response Writer</a>
            </li>
            <li>
              <a id="os" class="textLink" href="<c:url value="/data/standard/response/os" />">Response OutputStream</a>       
            </li>
            <li>
              <a id="session" class="textLink" href="<c:url value="/data/standard/session" />">Session</a>      
            </li>     
          </ul>
        </div>
        <div id="customArgs">
          <h3>Custom Resolvable Web Arguments</h3>  
          <ul>
            <li>
              <a id="customArg" class="textLink" href="<c:url value="/data/custom" />">Custom</a>     
            </li>
          </ul>
        </div>
      </div>

      <div class="tab-pane" id="responses">
        <h2>Writing Responses</h2>
        <p>
          See the <code>org.springframework.samples.mvc.response</code> package for the @Controller code
        </p>    
        <ul>
          <li>
            <a id="responseBody" class="textLink" href="<c:url value="/response/annotation" />">@ResponseBody</a>     
          </li>
          <li>
            <a id="responseCharsetAccept" class="utf8TextLink" href="<c:url value="/response/charset/accept" />">@ResponseBody (UTF-8 charset requested)</a>
          </li>
          <li>
            <a id="responseCharsetProduce" class="textLink" href="<c:url value="/response/charset/produce" />">@ResponseBody (UTF-8 charset produced)</a>
          </li>
          <li>
            <a id="responseEntityStatus" class="textLink" href="<c:url value="/response/entity/status" />">ResponseEntity (custom status)</a>     
          </li>
          <li>
            <a id="responseEntityHeaders" class="textLink" href="<c:url value="/response/entity/headers" />">ResponseEntity (custom headers)</a>      
          </li>
        </ul> 
      </div>

      <div class="tab-pane" id="views">
        <h2>Rendering Views</h2>
        <p>
          See the <code>org.springframework.samples.mvc.views</code> package for the @Controller code
        </p>
        <ul>
          <li>
            <a href="<c:url value="/views/html" />">HTML generated by JSP template</a>
          </li>
        </ul> 
        <ul>
          <li>
            <a href="<c:url value="/views/viewName" />">DefaultRequestToViewNameTranslator convention</a>
          </li>
        </ul> 
        <ul>
          <li>
            <a href="<c:url value="/views/pathVariables/bar/apple" />">Using path variables in a view template</a>
          </li>
        </ul>
        <ul>
          <li>
            <a href="<c:url value="/views/dataBinding/bar/apple" />">Data binding with URI variables</a>
          </li>
        </ul>
      </div>
           
      <div class="tab-pane" id="redirect">
        <h2>Redirecting</h2>
        <p>
          See the <code>org.springframework.samples.mvc.redirect</code> package for the @Controller code  
        </p>
        <ul>
          <li>
            <a href="<c:url value="/redirect/uriTemplate" />">URI Template String</a>
          </li>
          <li>
            <a href="<c:url value="/redirect/uriComponentsBuilder" />">UriComponentsBuilder</a>
          </li>
        </ul>
      </div>    
    </div> <!--tab-content-->
  </div> <!--tabbable-->   

  <script type="text/javascript">
    // Load initial tab
    $(function () {
      $('#getStartedTab a[href="#simple"]').tab('show');
    })
  </script>

</body>
</html>