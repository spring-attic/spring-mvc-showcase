<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${!ajaxRequest}">
<html>
<body>
</c:if>

	<div class="row">        
        <div class="col-md-12" id="fileuploadContent">
	    	<h2> File Upload </h2>	           	        
			<p>
				See the <code>org.springframework.samples.mvc.fileupload</code> package for the @Controller code	
			</p>
	       
         	<form id="fileuploadForm" action="fileupload" method="POST" enctype="multipart/form-data" class="cleanform">
				<div class="header">
			  		<c:if test="${not empty message}">
						<div id="message" class="success">${message}</div>	  		
			  		</c:if>
				</div>

				<input type="file" id="file" name="file" />
				
                <div style="padding-top:20px;"></div>

                <div>
                  <button type="submit" class="btn btn-primary">Upload</button>
                </div>					
				<p></p>		
			</form>			
        </div>       
    </div>  	
	
	<c:if test="${!ajaxRequest}">

	<script type="text/javascript">
		$(document).ready(function() {
			$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
			$("#fileuploadForm").ajaxForm({ success: function(html) {
					$("#fileuploadContent").replaceWith(html);
				}
			});
		});
	</script> 

</body>
</html>
</c:if>