// Utilities
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

// Ajax Calls
$(document).ready(function() {
	
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
				req.setRequestHeader("Accept", "application/application+xml");
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
		$.ajax({ url: this.href, dataType: "json", success: function(json) { MvcUtil.showSuccessResponse(JSON.stringify(json), link); }, error: function(xhr) { MvcUtil.showErrorResponse(xhr.responseText, link); }});					
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

});