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
	<h3>Start A New Experiment</h3>
	<form:form action="/exp/new" method="post" modelAttribute="exp" class="create-form">
		<div class="form-group row">
			<form:label path="expName" class="col-sm-3 col-form-label">Experiment Name</form:label>
			<div class="col-sm-9 input-error-container">
				<form:input path="expName" class="form-control"/>
				<form:errors path="expName" class="error-message"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="expDate" class="col-sm-3 col-form-label">Experiment Date</form:label>
			<div class="col-sm-9 input-error-container">
				<form:input path="expDate" class="form-control" type="date"/>
				<form:errors path="expDate" class="error-message"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="temp" class="col-sm-3 col-form-label">Experiment Temp</form:label>
			<div class="col-sm-9 input-error-container">
				<form:input path="temp" class="form-control"/>
				<form:errors path="temp" class="error-message"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="steps" class="col-sm-3 col-form-label">Steps</form:label>
			<div class="col-sm-9 input-error-container">
				<form:textarea path="steps" class="form-control" rows = "5" cols = "30"/>
				<form:errors path="steps" class="error-message"/>
			</div>
		</div>
		<div class="form-group row">
			<form:label path="comments" class="col-sm-3 col-form-label">Comments</form:label>
			<div class="col-sm-9 input-error-container">
				<form:textarea path="comments" class="form-control" rows = "5" cols = "30"/>
				<form:errors path="comments" class="error-message"/>
			</div>
		</div>
		<div class="button-container">
			<input type="submit" value="Submit" class="btn btn-primary" />
		</div>
	</form:form>
</body>
</html>