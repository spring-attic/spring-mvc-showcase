<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>spring-mvc-showcase</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.core.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.theme.css" />" rel="stylesheet" type="text/css"/>
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.tabs.css" />" rel="stylesheet" type="text/css"/>
	
	<!--
		Used for including CSRF token in JSON requests
		Also see bottom of this file for adding CSRF token to JQuery AJAX requests
	-->
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
<h1><a href="<c:url value="/" />">spring-mvc-showcase</a></h1>
<p>Recommended: Using a Web Developer tool such a Firebug to inspect the client/server interaction</p>
<div id="tabs">
	<ul>
		<li><a href="#simple">Simple</a></li>
		<li><a href="#mapping">Request Mapping</a></li>
		<li><a href="#data">Request Data</a></li>
		<li><a href="#responses">Response Writing</a></li>
		<li><a href="#messageconverters">Message Converters</a></li>
		<li><a href="#views">View Rendering</a></li>
		<li><a href="#convert">Type Conversion</a></li>
		<li><a href="#validation">Validation</a></li>
		<li><a href="<c:url value="/form" />" title="forms">Forms</a></li>
		<li><a href="<c:url value="/fileupload" />" title="fileupload">File Upload</a></li>
		<li><a href="#exceptions">Exception Handling</a></li>
		<li><a href="#redirect">Redirecting</a></li>
        <li><a href="#async">Async Requests</a></li>
    </ul>
    <div id="simple">
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
	<div id="mapping">
		<h2>Request Mapping</h2>
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
					<input id="byConsumesSubmit" type="submit" value="By consumes" />
				</form>
			</li>
			<li>
				<a id="byProducesAcceptJson" class="writeJsonLink" href="<c:url value="/mapping/produces" />">By produces via Accept=application/json</a>
			</li>
            <li>
                <a id="byProducesAcceptXml" class="writeXmlLink" href="<c:url value="/mapping/produces" />">By produces via Accept=application/xml</a>
            </li>
            <li>
              <a id="byProducesJsonExt" class="writeJsonLink" href="<c:url value="/mapping/produces.json" />">By produces via ".json"</a>
            </li>
            <li>
                <a id="byProducesXmlExt" class="writeXmlLink" href="<c:url value="/mapping/produces.xml" />">By produces via ".xml"</a>
            </li>
		</ul>
	</div>
	<div id="data">
		<h2>Request Data</h2>
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
				<a id="matrixVar" class="textLink" href="<c:url value="/data/matrixvars;foo=bar/simple" />">Matrix variable</a>
			</li>
			<li>
				<a id="matrixVarMultiple" class="textLink" href="<c:url value="/data/matrixvars;foo=bar1/multiple;foo=bar2" />">Matrix variables (multiple)</a>
			</li>
			<li>
				<a id="header" class="textLink" href="<c:url value="/data/header" />">Header</a>
			</li>
			<li>
				<form id="requestBody" class="textForm" action="<c:url value="/data/body" />" method="post">
					<input id="requestBodySubmit" type="submit" value="Request Body" />
				</form>
			</li>				
			<li>
				<form id="requestBodyAndHeaders" class="textForm" action="<c:url value="/data/entity" />" method="post">
					<input id="requestBodyAndHeadersSubmit" type="submit" value="Request Body and Headers" />
				</form>
			</li>
		</ul>	
		<div id="standardArgs">
			<h3>Standard Resolvable Web Arguments</h3>
			<p>
			    See the <code>org.springframework.samples.mvc.data.standard</code> package for the @Controller code
			</p>
			<ul>
				<li>
					<a id="request" class="textLink" href="<c:url value="/data/standard/request" />">Request arguments</a>				
				</li>
				<li>
					<form id="requestReader" class="textForm" action="<c:url value="/data/standard/request/reader" />" method="post">
						<input id="requestReaderSubmit" type="submit" value="Request Reader" />
					</form>
				</li>			
				<li>
					<form id="requestIs" class="textForm" action="<c:url value="/data/standard/request/is" />" method="post">
						<input id="requestIsSubmit" type="submit" value="Request InputStream" />
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
			<p>
				See the <code>org.springframework.samples.mvc.data.custom</code> package for the @Controller code
			</p>
			<ul>
				<li>
					<a id="customArg" class="textLink" href="<c:url value="/data/custom" />">Custom</a>			
				</li>
			</ul>
		</div>
	</div>
	<div id="responses">
		<h2>Response Writing</h2>
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
	<div id="messageconverters">
		<h2>Http Message Converters</h2>
		<p>
			See the <code>org.springframework.samples.mvc.messageconverters</code> package for the @Controller code
		</p>	
		<div id="stringMessageConverter">
			<h3>StringHttpMessageConverter</h3>
			<ul>
				<li>
					<form id="readString" class="textForm" action="<c:url value="/messageconverters/string" />" method="post">
						<input id="readStringSubmit" type="submit" value="Read a String" />
					</form>
				</li>
				<li>
					<a id="writeString" class="textLink" href="<c:url value="/messageconverters/string" />">Write a String</a>
				</li>
			</ul>
			<h3>FormHttpMessageConverter</h3>
			<ul>
				<li>
					<form id="readForm" action="<c:url value="/messageconverters/form" />" method="post">
						<input id="readFormSubmit" type="submit" value="Read Form Data" />		
					</form>
				</li>
				<li>
					<a id="writeForm" href="<c:url value="/messageconverters/form" />">Write Form Data</a>
				</li>
			</ul>
			<h3>Jaxb2RootElementHttpMessageConverter</h3>
			<ul>
				<li>
					<form id="readXml" class="readXmlForm" action="<c:url value="/messageconverters/xml" />" method="post">
						<input id="readXmlSubmit" type="submit" value="Read XML" />		
					</form>
				</li>
				<li>
					<a id="writeXmlAccept" class="writeXmlLink" href="<c:url value="/messageconverters/xml" />">Write XML via Accept=application/xml</a>
				</li>
                <li>
                    <a id="writeXmlExt" class="writeXmlLink" href="<c:url value="/messageconverters/xml.xml" />">Write XML via ".xml"</a>
                </li>
			</ul>
			<h3>MappingJacksonHttpMessageConverter</h3>
			<ul>
				<li>
					<form id="readJson" class="readJsonForm" action="<c:url value="/messageconverters/json" />" method="post">
						<input id="readJsonSubmit" type="submit" value="Read JSON" />	
					</form>
				</li>
				<li>
					<form id="readJsonInvalid" class="readJsonForm invalid" action="<c:url value="/messageconverters/json" />" method="post">
						<input id="readInvalidJsonSubmit" type="submit" value="Read invalid JSON (400 response code)" />	
					</form>
				</li>
				<li>
					<a id="writeJsonAccept" class="writeJsonLink" href="<c:url value="/messageconverters/json" />">Write JSON via Accept=application/json</a>
				</li>
                <li>
                    <a id="writeJsonExt" class="writeJsonLink" href="<c:url value="/messageconverters/json.json" />">Write JSON via ".json"</a>
                </li>
			</ul>
			<h3>AtomFeedHttpMessageConverter</h3>
			<ul>
				<li>
					<form id="readAtom" action="<c:url value="/messageconverters/atom" />" method="post">
						<input id="readAtomSubmit" type="submit" value="Read Atom" />		
					</form>
				</li>
				<li>
					<a id="writeAtom" href="<c:url value="/messageconverters/atom" />">Write Atom</a>
				</li>
			</ul>
			<h3>RssChannelHttpMessageConverter</h3>
			<ul>
				<li>
					<form id="readRss" action="<c:url value="/messageconverters/rss" />" method="post">
						<input id="readRssSubmit" type="submit" value="Read Rss" />	
					</form>
				</li>
				<li>
					<a id="writeRss" href="<c:url value="/messageconverters/rss" />">Write Rss</a>
				</li>
			</ul>		
		</div>
	</div>
	<div id="views">
		<h2>View Rendering</h2>
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
	<div id="convert">
		<h2>Type Conversion</h2>
		<p>
			See the <code>org.springframework.samples.mvc.convert</code> package for the @Controller code
		</p>
		<ul>
			<li>
				<a id="primitive" class="textLink" href="<c:url value="/convert/primitive?value=3" />">Primitive</a>
			</li>
			<li>
				<a id="date" class="textLink" href="<c:url value="/convert/date/2010-07-04" />">Date</a>
			</li>
			<li>
				<a id="collection" class="textLink" href="<c:url value="/convert/collection?values=1&values=2&values=3&values=4&values=5" />">Collection 1 (multi-value parameter)</a>
			</li>
			<li>
				<a id="collection2" class="textLink" href="<c:url value="/convert/collection?values=1,2,3,4,5" />">Collection 2 (single comma-delimited parameter value)</a>
			</li>
			<li>
				<a id="formattedCollection" class="textLink" href="<c:url value="/convert/formattedCollection?values=2010-07-04,2011-07-04" />">@Formatted Collection</a>
			</li>		
			<li>
				<a id="valueObject" class="textLink" href="<c:url value="/convert/value?value=123456789" />">Custom Value Object</a>
			</li>
			<li>
				<a id="customConverter" class="textLink" href="<c:url value="/convert/custom?value=123-45-6789" />">Custom Converter</a>
			</li>		
		</ul>
		<div id="convert-bean">
			<h3>JavaBean Property Binding</h3>
			<ul>
				<li>
					<a id="primitiveProp" class="textLink" href="<c:url value="/convert/bean?primitive=3" />">Primitive</a>
				</li>	
				<li>
					<a id="dateProp" class="textLink" href="<c:url value="/convert/bean?date=2010-07-04" />">Date</a>
				</li>	
				<li>
					<a id="maskedProp" class="textLink" href="<c:url value="/convert/bean?masked=(205) 333-3333" />">Masked</a>
				</li>	
				<li>
					<a id="listProp" class="textLink" href="<c:url value="/convert/bean?list[0]=1&list[1]=2&list[2]=3" />">List Elements</a>
				</li>
				<li>
					<a id="formattedListProp" class="textLink" href="<c:url value="/convert/bean?formattedList[0]=2010-07-04&formattedList[1]=2011-07-04" />">@Formatted List Elements</a>
				</li>
				<li>
					<a id="mapProp" class="textLink" href="<c:url value="/convert/bean?map[0]=apple&map[1]=pear" />">Map Elements</a>
				</li>
				<li>
					<a id="nestedProp" class="textLink" href="<c:url value="/convert/bean?nested.foo=bar&nested.list[0].foo=baz&nested.map[key].list[0].foo=bip" />">Nested</a>
				</li>
			</ul>
		</div>
	</div>
	<div id="validation">
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
	<div id="exceptions">
		<h2>Exception Handling</h2>
		<p>
			See the <code>org.springframework.samples.mvc.exceptions</code> package for the @Controller code	
		</p>
		<ul>
			<li>
				<a id="exception" class="textLink" href="<c:url value="/exception" />">@ExceptionHandler in Controller</a>
			</li>
			<li>
				<a id="globalException" class="textLink" href="<c:url value="/global-exception" />">Global @ExceptionHandler</a>
			</li>
		</ul>
	</div>
	<div id="redirect">
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
	<div id="async">
		<h2>Async Requests</h2>
		<p>
			<em>Note: Links may take 2-3 seconds to complete.</em>
		</p>
		<p>
		  See the <code>org.springframework.samples.mvc.async</code> package for the @Controller code.
		</p>
		<ul>
		<li>
			<a id="callableResponseBodyLink" class="textLink"
				href="<c:url value="/async/callable/response-body" />">GET /async/callable/response-body</a>
		</li>
		<li>
			<a id="callableViewLink" class="textLink"
				href="<c:url value="/async/callable/view" />">GET /async/callable/view</a>
		</li>
		<li>
			<a id="callableExceptionLink" class="textLink"
				href="<c:url value="/async/callable/exception" />">GET /async/callable/exception</a>
		</li>
		<li>
			<a id="callableUnhandledExceptionLink" class="textLink"
				href="<c:url value="/async/callable/exception?handled=false" />">GET /async/callable/exception?handled=false</a>
				(500 Error expected)
		</li>
		<li>
			<a id="callableCustomTimeoutLink" class="textLink"
				href="<c:url value="/async/callable/custom-timeout-handling" />">GET /async/callable/custom-timeout-handling</a>
		</li>
		<li>
			<a id="deferredResultSuccessLink" class="textLink"
				href="<c:url value="/async/deferred-result/response-body" />">GET /async/deferred-result/response-body</a>
		</li>
		<li>
			<a id="deferredResultModelAndViewLink" class="textLink"
				href="<c:url value="/async/deferred-result/model-and-view" />">GET /async/deferred-result/model-and-view</a>
		</li>
		<li>
			<a id="deferredResultErrorLink" class="textLink"
				href="<c:url value="/async/deferred-result/exception" />">GET /async/deferred-result/exception</a>
		</li>
		<li>
			<a id="deferredResultTimeoutValueLink" class="textLink"
				href="<c:url value="/async/deferred-result/timeout-value" />">GET /async/deferred-result/timeout-value</a>
		</li>
		</ul>
	</div>
</div>
<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.core.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.widget.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/jqueryui/1.8/jquery.ui.tabs.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/json2.js" />"></script>
<script>
	MvcUtil = {};
	MvcUtil.showSuccessResponse = function (text, element) {
		MvcUtil.showResponse("success", text, element);
	};
	MvcUtil.showErrorResponse = function showErrorResponse(text, element) {
		MvcUtil.showResponse("error", text, element);
	};
	MvcUtil.showResponse = function(type, text, element) {
		var responseElementId = element.attr("id") + "Response";
		var responseElement = $("#" + responseElementId);
		if (responseElement.length == 0) {
			responseElement = $('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>').insertAfter(element);
		} else {
			responseElement.replaceWith('<span id="' + responseElementId + '" class="' + type + '" style="display:none">' + text + '</span>');
			responseElement = $("#" + responseElementId);
		}
		responseElement.fadeIn("slow");
	};
	MvcUtil.xmlencode = function(xml) {
		//for IE 
		var text;
		if (window.ActiveXObject) {
		    text = xml.xml;
		 }
		// for Mozilla, Firefox, Opera, etc.
		else {
		   text = (new XMLSerializer()).serializeToString(xml);
		}			
		    return text.replace(/\&/g,'&'+'amp;').replace(/</g,'&'+'lt;')
	        .replace(/>/g,'&'+'gt;').replace(/\'/g,'&'+'apos;').replace(/\"/g,'&'+'quot;');
	};
</script>	
<script type="text/javascript">
$(document).ready(function() {
	$("#tabs").tabs();

	// Append '#' to the window location so "Back" returns to the selected tab
	// after a redirect or a full page refresh (e.g. Views tab).

	// However, note this general disclaimer about going back to previous tabs: 
	// https://docs.jquery.com/UI/API/1.8/Tabs#Back_button_and_bookmarking

	$("#tabs").bind("tabsselect", function(event, ui) { window.location.hash = ui.tab.hash; });


	$("a.textLink").click(function(){
		var link = $(this);
		$.ajax({ url: link.attr("href"), dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, link); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, link); }});
		return false;
	});

	$("a.utf8TextLink").click(function(){
		var link = $(this);
		$.ajax({ url: link.attr("href"), dataType: "text", beforeSend: function(req) { req.setRequestHeader("Accept", "text/plain;charset=UTF-8"); }, success: function(text) { MvcUtil.showSuccessResponse(text, link); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, link); }});
		return false;
	});

	$("form.textForm").submit(function(event) {
		var form = $(this);
		var button = form.children(":first");
		$.ajax({ type: "POST", url: form.attr("action"), data: "foo", contentType: "text/plain", dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, button); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, button); }});
		return false;
	});

	$("#readForm").submit(function() {
		var form = $(this);
		var button = form.children(":first");
		$.ajax({ type: "POST", url: form.attr("action"), data: "foo=bar&fruit=apple", contentType: "application/x-www-form-urlencoded", dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, button); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, button); }});
		return false;
	});

	$("#writeForm").click(function() {
		var link = $(this);
		$.ajax({ url: this.href, dataType: "text", beforeSend: function(req) { req.setRequestHeader("Accept", "application/x-www-form-urlencoded"); }, success: function(form) { MvcUtil.showSuccessResponse(form, link); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, link); }});					
		return false;
	});

	$("form.readXmlForm").submit(function() {
		var form = $(this);
		var button = form.children(":first");
		$.ajax({ type: "POST", url: form.attr("action"), data: "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><javaBean><foo>bar</foo><fruit>apple</fruit></javaBean>", contentType: "application/xml", dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, button); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, button); }});
		return false;
	});

	$("a.writeXmlLink").click(function() {
		var link = $(this);
		$.ajax({ url: link.attr("href"),
			beforeSend: function(req) { 
				if (!this.url.match(/\.xml$/)) {
					req.setRequestHeader("Accept", "application/xml");
				}
			},
			success: function(xml) {
				MvcUtil.showSuccessResponse(MvcUtil.xmlencode(xml), link);
			},
			error: function(xhr) { 
				MvcUtil.showErrorResponse(xhr.responseText, link);
			}
		});
		return false;
	});					

	$("form.readJsonForm").submit(function() {
		var form = $(this);
		var button = form.children(":first");
		var data = form.hasClass("invalid") ?
				"{ \"foo\": \"bar\" }" : 
				"{ \"foo\": \"bar\", \"fruit\": \"apple\" }";
		$.ajax({ type: "POST", url: form.attr("action"), data: data, contentType: "application/json", dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, button); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, button); }});
		return false;
	});

	$("a.writeJsonLink").click(function() {
		var link = $(this);
		$.ajax({ url: this.href,
			beforeSend: function(req) {
				if (!this.url.match(/\.json$/)) {
					req.setRequestHeader("Accept", "application/json");
				}
			},
			success: function(json) {
				MvcUtil.showSuccessResponse(JSON.stringify(json), link);
			},
			error: function(xhr) {
				MvcUtil.showErrorResponse(xhr.responseText, link);
			}});
		return false;
	});

	$("#readAtom").submit(function() {
		var form = $(this);
		var button = form.children(":first");
		$.ajax({ type: "POST", url: form.attr("action"), data: '<?xml version="1.0" encoding="UTF-8"?> <feed xmlns="http://www.w3.org/2005/Atom"><title>My Atom feed</title></feed>', contentType: "application/atom+xml", dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, button); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, button); }});
		return false;
	});

	$("#writeAtom").click(function() {
		var link = $(this);
		$.ajax({ url: link.attr("href"),
			beforeSend: function(req) { 
				req.setRequestHeader("Accept", "application/atom+xml");
			},
			success: function(feed) {
				MvcUtil.showSuccessResponse(MvcUtil.xmlencode(feed), link);
			},
			error: function(xhr) { 
				MvcUtil.showErrorResponse(xhr.responseText, link);
			}
		});
		return false;
	});
	
	$("#readRss").submit(function() {
		var form = $(this);
		var button = form.children(":first");
		$.ajax({ type: "POST", url: form.attr("action"), data: '<?xml version="1.0" encoding="UTF-8"?> <rss version="2.0"><channel><title>My RSS feed</title></channel></rss>', contentType: "application/rss+xml", dataType: "text", success: function(text) { MvcUtil.showSuccessResponse(text, button); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, button); }});
		return false;
	});

	$("#writeRss").click(function() {
		var link = $(this);	
		$.ajax({ url: link.attr("href"),
			beforeSend: function(req) { 
				req.setRequestHeader("Accept", "application/rss+xml");
			},
			success: function(feed) {
				MvcUtil.showSuccessResponse(MvcUtil.xmlencode(feed), link);
			},
			error: function(xhr) { 
				MvcUtil.showErrorResponse(xhr.responseText, link);
			}
		});
		return false;
	});

	$("#byHeader").click(function(){
		var link = $(this);
		$.ajax({ url: this.href, dataType: "text", beforeSend: function(req) { req.setRequestHeader("FooHeader", "foo"); }, success: function(form) { MvcUtil.showSuccessResponse(form, link); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, link); }});
		return false;
	});

	// Include CSRF token as header in JQuery AJAX requests
	// See https://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#csrf-include-csrf-token-ajax
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

});
</script>
</body>
</html>
