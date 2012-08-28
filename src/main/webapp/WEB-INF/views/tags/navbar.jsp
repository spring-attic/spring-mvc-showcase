<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
  <span class="icon-bar"></span>
  <span class="icon-bar"></span>
  <span class="icon-bar"></span>
</a>
<a class="brand" href="#">Spring Framework 3</a>
<div class="nav-collapse collapse">  
  <ul class="nav">
    <li class="active"><a href="<c:url value="/" />">Home</a></li>
    <li><a href="<c:url value="/getstarted" />">Get started</a></li>
    <li><a href="<c:url value="/errors-validations" />">Errors &amp; Validations</a></li>
    <li><a href="<c:url value="/form" />">Forms</a></li>
    <li><a href="<c:url value="/fileupload" />">File Upload</a></li>
    <li><a href="<c:url value="/misc" />">Misc</a></li>
  </ul>
</div>
