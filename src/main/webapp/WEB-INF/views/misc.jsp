<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<body>

  <div class="tabbable" id="demo-tab"> <!-- Only required for left/right tabs -->
    <!-- Tab Definitions-->               
    <ul class="nav nav-tabs">
      <li><a href="#messageconverters" data-toggle="tab">Message Converters</a></li>
      <li><a href="#convert" data-toggle="tab">Type Conversion</a></li>
    </ul>  

    <!-- Tab Content-->
    <div class="tab-content">                  
    	<div class="tab-pane" id="messageconverters">
        <h2>Http Message Converters</h2>
        <p>
          See the <code>org.springframework.samples.mvc.messageconverters</code> package for the @Controller code
        </p>  
        <div id="stringMessageConverter">
          <h3>StringHttpMessageConverter</h3>
          <ul>
            <li>
              <form id="readString" class="textForm" action="<c:url value="/messageconverters/string" />" method="post">
                <input id="readStringSubmit" type="submit" class="btn btn-primary" value="Read a String" />
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
                <input id="readFormSubmit" type="submit" value="Read Form Data" class="btn btn-primary" />    
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
                <input id="readXmlSubmit" type="submit" value="Read XML" class="btn btn-primary"/>   
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
                <input id="readJsonSubmit" type="submit" value="Read JSON" class="btn btn-primary" /> 
              </form>
            </li>
            <li>
              <form id="readJsonInvalid" class="readJsonForm invalid" action="<c:url value="/messageconverters/json" />" method="post">
                <input id="readInvalidJsonSubmit" type="submit" value="Read invalid JSON (400 response code)" class="btn btn-primary" />  
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
                <input id="readAtomSubmit" type="submit" value="Read Atom" class="btn btn-primary"/>   
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
                <input id="readRssSubmit" type="submit" value="Read Rss" class="btn btn-primary"/> 
              </form>
            </li>
            <li>
              <a id="writeRss" href="<c:url value="/messageconverters/rss" />">Write Rss</a>
            </li>
          </ul>   
        </div>
      </div>	

      <div class="tab-pane" id="convert">
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

    </div> <!--tab-content-->
  </div> <!--tabbable-->   

</body>
</html>