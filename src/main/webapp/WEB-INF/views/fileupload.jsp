<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!ajaxRequest}">
<html>
<head>
	<title>fileupload | mvc-showcase</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.4/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.4/jquery.form.js" />"></script>	
</head>
<body>
</c:if>
	<div id="fileupload">
		<h2>File Upload</h2>
		<p>
			See the <code>org.springframework.samples.mvc.fileupload</code> package for the @Controller code	
		</p>
		<form id="fileuploadForm" action="fileupload" method="POST" enctype="multipart/form-data" class="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="${message.type}">${message.text}</div>	  		
		  		</c:if>
			</div>
			<label for="file">File</label>
			<input id="file" type="file" name="file" />
			<p><button type="submit">Upload</button></p>		
		</form>
		<script type="text/javascript">
			$(document).ready(function() {
				$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
				$("#fileuploadForm").ajaxForm({ success: function(html) {
						$("#fileupload").replaceWith(html);
					}
				});
			});
		</script>	
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>