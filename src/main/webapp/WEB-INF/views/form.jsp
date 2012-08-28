<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:if test="${!ajaxRequest}">
<html>
<body>
</c:if>
	<div id="formsContent">
		<h2>Forms</h2>
		<p>
			See the <code>org.springframework.samples.mvc.form</code> package for the @Controller code	
		</p>
		<form:form id="form" method="post" modelAttribute="formBean" class="form-horizontal">
			<div>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>Personal Info</legend>
		  		
		  		<div class="control-group error">
					<form:label class="control-label" path="name"> 
						Name <form:errors path="name" />
					</form:label>
					<div class="controls">
						<form:input path="name" placeholder="Name" />
					</div>
				</div>	
				<div class="control-group warning">
					<form:label class="control-label" path="age">
		  				Age <form:errors path="age" />
					</form:label>
					<div class="controls">
						<form:input path="age" />
					</div>
				</div>
		  		<div class="control-group success">
					<form:label class="control-label" path="birthDate">
		  				Birth Date <form:errors path="birthDate"/>
					</form:label>
					<div class="controls">												 
	                    <form:input path="birthDate" size="16" placeholder="yyyy-mm-dd"/>	                    
					</div>
				</div>
		 		<div class="control-group">
					<form:label class="control-label" path="currency">
		  				Currency <form:errors path="currency" />
					</form:label>
					<div class="controls">
						<div class="input-prepend input-append">
							<span class="add-on">$</span><form:input path="currency" class="input-medium"/><span class="add-on">.00</span>
						</div>
					</div>
				</div>
				<div class="control-group">
					<form:label class="control-label" path="phone">
		  				Phone <form:errors path="phone" />
					</form:label>
					<div class="controls">
						<form:input path="phone" class="input-medium" placeholder="(###) ###-####)"/>
					</div>
				</div>
		  		<div class="control-group">
					<form:label class="control-label" path="percent">
		  				Percentage <form:errors path="percent" />
					</form:label>
					<div class="controls">
						<form:input path="percent" class="input-small" placeholder="##%"/>
					</div>
				</div>		 
		  	</fieldset>
	
			<fieldset>
				<legend>Inquiry</legend>
				<div class="control-group">
					<form:label class="control-label"  path="inquiry">
						Type (select one)
					</form:label>
					<div class="controls">
						<form:select path="inquiry">
							<form:option value="comment">Comment</form:option>
							<form:option value="feedback">Feedback</form:option>
							<form:option value="suggestion">Suggestion</form:option>
						</form:select>
					</div>
				</div>
				<div class="control-group">
					<form:label class="control-label"  path="inquiryDetails">
		  				Details
					</form:label>
					<div class="controls">
						<form:textarea path="inquiryDetails" />
					</div>
				</div>						  	
		  	</fieldset>
	
			<fieldset >
				<legend>Request Additional Info</legend>
				<label class="checkbox inline">					
					<form:checkbox path="additionalInfo[mvc]" value="true" /> on Spring MVC
				</label>
				<label class="checkbox inline">
					<form:checkbox path="additionalInfo[java]" value="true" /> on Java (4-ever)
				</label>
			</fieldset>

		  	</p>	  	
			
			<fieldset >
				<legend>Subscribe to Newsletter?</legend>
				<label class="radio">
					<form:radiobutton path="subscribeNewsletter" value="true" />
					Yes
				</label>
				<label class="radio">
					<form:radiobutton path="subscribeNewsletter" value="false" />
					No
				</label>
			</fieldset>
	
			<p><button type="submit" class="btn btn-primary">Submit</button></p>				
		</form:form>

		<script type="text/javascript">
			$(document).ready(function() {
			$("#form").submit(function() {  
				$.post($(this).attr("action"), $(this).serialize(), function(html) {
					$("#formsContent").replaceWith(html);
					$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
				});
				return false;  
				});			
			});
		</script>
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>