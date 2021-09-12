<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Player Selection</title>
</head>
<body>
	<h2>Enter number of players</h2>
	<form:form method="POST" action="/show_player_list">
		Please enter your menu selection:
		<form:input path="no_of_players" />
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>