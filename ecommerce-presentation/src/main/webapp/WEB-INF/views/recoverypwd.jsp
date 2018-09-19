<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cambia Password</title>
</head>
<body>
	<div class = "changePassword">
		<form class = "np" action = "pwdchange" method = "post">
			E-Mail: <input type = "text" name = "email" value = "" required>
			<c:if test = "${email == null }"><font color = red>*</font></c:if><br>
			Nuova Password: <input name = "new_pass" required/>
			<c:if test = "${new_pass == null }"><font color = red required>*</font></c:if><br>
						
			<input type = "submit" class = "bottone" value = "invia">
		</form>
	</div>
</body>
</html>