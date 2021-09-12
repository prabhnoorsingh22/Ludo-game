<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Choose the Tournament type</h2>
	<ol>
  		<li>START TOURNAMENT</li>
  		<li>JOIN TOURNAMENT</li>
  		<li>DASHBOARD MENU<li>
	</ol> 
	<form:form modelAttribute="Main_menu" method="POST" action="/d_menu">
		Please enter your menu selection:
		<form:input path="sel_menu" />
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>