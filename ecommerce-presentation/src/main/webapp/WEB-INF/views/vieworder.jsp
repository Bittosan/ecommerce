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

		Riepilogo ordine
					
		Dati utente
		<c:out value="${name}"></c:out>
		<c:out value="${surname}"></c:out>
		<c:out value="${email}"></c:out>
	
		I tuoi prodotti
		
		<c:forEach items ="${sessionScope.cart}" var = "product">
			<tr>				
				<td class = "colonna">
				Descrizione
					<c:out value = "${product.description}"/>
				</td>
				<td class = "colonna">
				Prezzo unitario
					<c:out value = "${product.price}euro"/>
				</td>
				
				<td class = "colonna">
				Quantità
					<c:out value = "Quantità: ${order.quantity}"/>
				</td>
				
				<td class = "colonna">
				Totale
					<c:out value = "${product.price}*${order.quantity} euro"/>
				</td>

			</c:forEach>
			
	
		<table>
		<tr>
				<td class = "colonna">
				Totale ordine
					<c:out value = "Totale: ${sessionScope.order.total}euro"/>
				</td>
					</tr>
		</table>
		
						<form action = "vieworder" method = "GET">
						<input type = "Submit" value = "Procedi all'acquisto">
					</form>	

</body>
</html>