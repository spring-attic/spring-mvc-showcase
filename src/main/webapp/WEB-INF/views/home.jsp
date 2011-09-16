<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>spring-mvc-showcase</title>
	<link href="<c:url value="/resources/form.css" />" rel="stylesheet"  type="text/css" />		
	<link href="<c:url value="/resources/jqueryui/1.8/themes/base/jquery.ui.all.css" />" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1><a href="<c:url value="/"/>">spring-mvc-showcase</a></h1>
<p>Recommended: Using a Web Developer tool such a Firebug to inspect the client/server interaction</p>
<div id="tabs">
	<ul>
		<li><a href="#simple">Simple</a></li>
		<li><a href="#mapping">Mapping Requests</a></li>
		<li><a href="#data">Obtaining Request Data</a></li>
		<li><a href="#responses">Writing Responses</a></li>
		<li><a href="#messageconverters">Message Converters</a></li>
		<li><a href="#views">Rendering Views</a></li>
		<li><a href="#convert">Type Conversion</a></li>
		<li><a href="#validation">Validation</a></li>
		<li><a href="<c:url value="/form" />">Forms</a></li>
		<li><a href="<c:url value="/fileupload" />">File Upload</a></li>
		<li><a href="#exceptions">Exception Handling</a></li>
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
				<a id="byNotParameter" class="textLink" href="<c:url value="/mapping/parameter" />">By path, method, and absence of parameter</a>
			</li>
			<li>
				<a id="byHeader" href="<c:url value="/mapping/header" />">By presence of header</a>
			</li>
			<li>
				<a id="byHeaderNegation" class="textLink" href="<c:url value="/mapping/header" />">By absence of header</a>
			</li>
			<li>
				<form id="byConsumes" class="readJsonForm" action="<c:url value="/mapping/consumes" />" method="post">
					<input id="byConsumesSubmit" type="submit" value="By consumes JSON" />
				</form>
			</li>
            <li>
				<a id="byConsumes2" class="textLink" href="<c:url value="/mapping/consumes2?foo=json&fruit=cherry"/>">By consumes JSON - GET</a>
			</li>
			<li>
				<a id="byProduces" class="writeJsonLink" href="<c:url value="/mapping/produces" />">By produces JSON</a>
			</li>
		</ul>
	</div>
	<div id="data">
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
			<ul>
				<li>
					<a id="customArg" class="textLink" href="<c:url value="/data/custom" />">Custom</a>			
				</li>
			</ul>
		</div>
	</div>
	<div id="responses">
		<h2>Writing Responses</h2>
		<p>
			See the <code>org.springframework.samples.mvc.response</code> package for the @Controller code
		</p>		
		<ul>
			<li>
				<a id="responseBody" class="textLink" href="<c:url value="/response/annotation" />">@ResponseBody</a>			
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
					<a id="writeXml" class="writeXmlLink" href="<c:url value="/messageconverters/xml" />">Write XML</a>
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
						<input id="readInvalidJsonSubmit" type="submit" value="Read JSON (Validation Error)" />	
					</form>
				</li>
				<li>
					<a id="writeJson" class="writeJsonLink" href="<c:url value="/messageconverters/json" />">Write JSON</a>
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
				<a href="<c:url value="/views/pathVars/bar/apple" />">Using path variables in a view template</a>
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
				<a id="exception" class="textLink" href="<c:url value="/exception" />">@Controller Exception handling</a>
			</li>
		</ul>
	</div>
</div>
<%@include file="homescripts.jsp"%>
</body>
</html>