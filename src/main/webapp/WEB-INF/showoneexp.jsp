<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%--import c tag --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--import form:from tag --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%-- allow render on a PUT --%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Title</title>
<%--bootstrap --%>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<%--link static files--%>

<link rel="stylesheet" type="text/css" href="/css/style.css">
<%--<script type="text/javascript" src="js/script.js"></script>--%>
</head>

<body class="container">
	<h2 id="expnametext"><c:out value="${theExp.expName}" /></h2>
</body>
<script type="text/javascript" src="/js/src/startedit.js" ></script>
</html>