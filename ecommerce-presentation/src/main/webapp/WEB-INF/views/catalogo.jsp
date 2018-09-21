<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<!-- In questa pagina mostriamo i prodotti ricercati nel database -->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Catalogo</title>
		<link rel = "stylesheet" type = "text/css" href = "Stylesheet/Style.css">
	</head>
	<body>
		<jsp:useBean id="user" class = "model.User" scope = "session"></jsp:useBean>
		<jsp:useBean id="product" class = "model.Product" scope = "session"></jsp:useBean>

	<!-- Nel div "top" si inserisce il logo del sito, il menù di navigazione e la sezione del log-in  --> 

		<div class = "top">
			<div class = "top-center">
				<header><h1>E-Commerce</h1></header>
				<ul class = "menu">
					<li class="primo">
						<a style = "text-decoration:none;" href = "home">
						<font color= "#e9e9e9">Home Page</font></a>
					</li>
					<li>
						<font color= "black">Acquisti</font>
					<li>
						<a style="text-decoration: none;" href= "productType?tipo=fiori">
						<font color= "#e9e9e9">Fiori</font></a>
					</li>
					<li>
						<a style="text-decoration: none;" href= "productType?tipo=vasi">
						<font color = "#e9e9e9">Vasi</font></a>
					</li>
					<li class="last">
						<a style="text-decoration: none;" href= "productType?tipo=attrezzature">
						<font color = "#e9e9e9">Attrezzature</font></a>
					</li>
				</ul>
			</div>
		</div>
		<div class = "top-right">
			Benvenuto <c:out value="${user.username}"></c:out><br>
			<form action = "logout" method = "POST">
				<input type = "Submit" value = "Logout">
			</form>		
			<a href="viewcart" style = "text-decoration: none;">
				<font color= black> Il mio carrello</font><br></a>
		</div>	
	
		<!-- In questa sezione prendiamo le informazioni dei prodotti dalla richiesta e le mostriamo a video, accompagnandole
		con un'immagine. Inoltre è possibile accedere ad un'altra sezione, con più dettagli sul prodotto, cliccando
		sull'immagine. -->

		<div class = "middle-center">
			<table class = "catalogo">
				<c:forEach items ="${sessionScope.list}" var = "product">
					<tr>				
						<td class = "colonna">
							<c:out value = "${product.description}"/>
						</td>
						<td class = "colonna">
							<c:out value = "${product.price}euro"/>
						</td>
						<td class = "colonna">
							<c:out value = "Disponibilità: ${product.availability}"/>
						</td>
						<td class = "colonna">
						<!-- In questa parte viene visualizzata la possibilità di aggiunge al carrello il prodotto -->
							<form action = "addcart" method = "POST">
								<input type = "Submit" value = "Aggiungi al carrello"><br>
								<input type = "hidden" name = "id_product" value='<c:out value = "${product.id_product}"/>'/>
								Quantità: <input type = "number" name = "quantity" value= "${product.availability}">
							</form>	
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
</html>