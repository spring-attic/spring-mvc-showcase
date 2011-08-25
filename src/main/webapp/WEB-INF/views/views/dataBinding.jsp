<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>My HTML View (Data Binding)</title>
</head>
<body>
<h1>foo = ${javaBean.foo}</h1>
<h1>fruit = ${javaBean.fruit}</h1>
</body>
</html>