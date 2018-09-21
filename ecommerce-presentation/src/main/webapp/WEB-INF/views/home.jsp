<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
	</head>
	<body>
		<div class = "top-right">
			<c:choose>
				<c:when test ="${email==null}">
					<br>
						<form action = "login" method = "post">
							<table>
								<tr>
									<td>
										<font color= black>Email</font></td><td> <font color= black>Password</font>
									</td>
								</tr>
								<tr>
									<td>
										<input type = "TEXT" name = "email" value = "" size = "13" required>
									</td>
									<td>
										<input type = "PASSWORD" name = "password" value = "" size = "13" required>
									</td>
									<td>
										<input type = "SUBMIT" name = accedi value = "accedi">
									</td>
								</tr>				
							</table>
						</form>	
						<a href="registration" style = "text-decoration: none;">
							<font color= black>Non sono registrato</font><br></a>
						<a href = "recoverypwd" style = "text-decoration: none;" >
							<font color= black>Ho dimenticato la password</font></a>
					</c:when>
				<c:otherwise>					
					Benvenuto <c:out value="${email}"></c:out><br>
					<form action = "logout" method = "post">
						<input type = "Submit" value = "Logout">
					</form>		
					<a href="product" style = "text-decoration: none;">
						<font color= black>Catalogo</font><br></a>
				</c:otherwise>
			</c:choose>			
		</div>
	</body>
</html>