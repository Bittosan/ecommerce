<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- In questa pagina il cliente può effettuare la registrazione -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel = "stylesheet" type = "text/css" href = "Stylesheet/Style.css">
</head>
<body>
	<div class = "personalData">
		<form class = "reg" action = "registrationController" method = "post">
			E-Mail: <input type = "TEXT" name = "email" value = "" required>
			<c:if test = "${email == null }"><font color = red>*</font></c:if><br>
			Username: <input name = "username" required/>
			<c:if test = "${username == null }"><font color = red required>*</font></c:if><br>
			Password: <input type = "password" name = "password" value = "" required>
			<c:if test = "${password == null }"><font color = red>*</font></c:if><br>
			Conferma Password: <input type = "PASSWORD" name= "repeat_password" value = "" required>
			<c:if test = "${confPassword == null }"><font color = red>*</font></c:if><br>
			Nome: <input type = "TEXT" name = "name" value = "" required>
			<c:if test = "${nome == null }"><font color = red>*</font></c:if><br>
			Cognome: <input type = "TEXT" name = "surname" value = "" required">
			<c:if test = "${cognome == null }"><font color = red>*</font></c:if><br>
						
			<input type = "submit" class = "bottone" value = "Registrati">
		</form>
	</div>
</body>
</html>