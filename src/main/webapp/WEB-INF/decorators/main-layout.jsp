<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring-MVC-Showcase</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet"  type="text/css" />    
  <link href="<c:url value="/resources/css/bootstrap-responsive.min.css" />" rel="stylesheet"  type="text/css" />    
  
  <style type="text/css">
    body {
      padding-top: 60px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 9px 0;
    }
  </style>

  <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->

</head>

<body>

   	<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
      	<div class="container-fluid">
      		<c:import url="/WEB-INF/views/tags/navbar.jsp"/> 	
        </div>			      		 
      </div>
   	</div>

   	<div class="container-fluid">
	     <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav">
          	<c:import url="/WEB-INF/views/tags/menu.jsp"/>   
          </div><!--/.well -->
        </div><!--/span-->
        <div class="span10">         
            <div class="hero-unit">
              <c:import url="/WEB-INF/views/tags/banner.jsp"/>       
            </div>
            <div class="row-fluid">
              <div class="span12">
                  <div class="container" align="center">
                    <iframe class="github-btn" src="http://ghbtns.com/github-btn.html?user=priyatam&repo=springmvc-twitterbootstrap-showcase&type=watch&count=true" allowtransparency="true" frameborder="0" scrolling="0" width="100px" height="20px"></iframe>

                    <a href="https://twitter.com/share" class="twitter-share-button" data-url="http://springmvc-twitterbootstrap-showcase.cloudfoundry.com" data-text="Spring MVC Twitter Bootstrap Showcase!">Tweet</a>
                    <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="//platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>                         
                  </div>

                <hr class="soften">
     
                <decorator:body />
                
              </div>
              </div><!--/span-->
            </div><!--/row-->                 
        </div><!--/span-->
      </div><!--/row-->
	   
      <hr>

  	  <footer>
    	 <c:import url="/WEB-INF/views/tags/footer.jsp"/>
  	  </footer>

    </div>

	<!-- Placed at the end of the document so the pages load faster -->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.8.0-min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/demo.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/json2.js" />"></script> 
  <script type="text/javascript" src="<c:url value="/resources/js/date.format.js" />"></script>
</body>
</html>