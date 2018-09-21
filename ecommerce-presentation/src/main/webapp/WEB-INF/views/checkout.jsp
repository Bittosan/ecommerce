<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Checkout</title>
	</head>
	<body>
		<div class = "top-right">
			<c:choose>
				<c:when test ="${checkout_error}">
					<div class = "accentra">
						<h1><a style = "text-align : center">
							<font color = red>Impossibile Effettuare Acquisto</font></a></h1>
					</div>
				</c:when>
				<c:otherwise>					
					<div class = "accentra">
						<h1><a style = "text-align : center">
						<font color = red>Acquisto Effettuato Con Successo</font></a></h1>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
	</body>			
</html>