<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test ="${sessionScope.flagCart==false}">
				carrello vuoto
			</c:when>
			<c:otherwise>					
				<table class = "carrello">
					<c:forEach items ="${sessionScope.cart}" var = "product">
						<tr>				
							<td class = "colonna">
								<c:out value = "${product.description}"/>
							</td>
							<td class = "colonna">
								<c:out value = "${product.price}euro"/>
							</td>
							<td class = "colonna">
								<c:out value = "Quantità: ${product.quantity}"/>
							</td>
							<td class = "colonna">
								<form action = "removeproductcart" method = "POST">
									<input type = "Submit" value = "Rimuovi prodotto"><br>
									<input type = "hidden" name = "id_product" value='<c:out value = "${product.id_product}"/>'/>
								</form>	
							</td>
						</tr>
					</c:forEach>
				</table>
				<table>
					<tr>
						<td class = "colonna">
							<c:out value = "Totale: ${sessionScope.total}euro"/>
						</td>
					</tr>
			
				</table>
				<form action = "emptycart" method = "POST">
					<input type = "Submit" value = "Rimuovi tutto"><br>
				</form>
				<form action = "checkout" method = "GET">
					<input type = "Submit" value = "Procedi all'ordine">
				</form>	
			</c:otherwise>
		</c:choose>		
	</body>
</html>