<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css"
	href="/webjars/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
<script type="text/javascript"
	src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container text-center">
		<div>
			<h1>Player Registration - Sign Up</h1>
		</div>
		<form:form action="/process_register" method="post"
			modelAttribute="user" style="max-width: 600px; margin: 0 auto;">
			<div class="m-3">
				<div class="form-group row">
					<form:label path="player_email">E-mail:</form:label>
					<form:input path="player_email" />
					<br />
				</div>
				<div class="form-group row">
					<form:label path="player_password">Password:</form:label>
					<form:password path="player_password" />
					<br />
				</div>
				<div class="form-group row">
					<form:label path="player_name">Full Name:</form:label>
					<form:input path="player_name" />
					<br />
				</div>
				<div>
					<button type="submit" class="btn btn-primary">Sign Up</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>