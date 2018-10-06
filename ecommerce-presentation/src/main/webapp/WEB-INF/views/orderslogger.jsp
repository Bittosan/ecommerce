<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Flower Shop - Log Ordini</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
<div id="wrap">
  <div class="header">
    <div class="logo"><a href="#"><img src="resources/images/logo.gif" alt="" border="0" /></a></div>
    <div id="menu">
      <ul>
        <li ><a href="home">Home</a></li>
        <li class="selected"><a href="orderlogger">Log Ordini</a></li>
      </ul>
    </div>
  </div>
  <div class="center_content">
    <div class="left_content">
      <div class="title"><span class="title_icon"><img src="resources/images/bullet1.gif" alt="" /></span>Log Ordini</div>
       <div class="feat_prod_box_details">  
          <table class="cart_table">
          <tr class="cart_title">
            <td>Id Ordine</td>
            <td>Id Prodotto</td>
            <td>Data Acquisto</td>
            <td>Utente</td>
          </tr>
          <c:forEach items ="${sessionScope.orderLogger}" var = "logger">
          <tr>
            <td>${logger.id_order}</td>
            <td>${logger.id_product}</td>
            <td>${logger.purchase_data}</td>
            <td>${logger.email}</td>
          </tr>
	</c:forEach>
        </table>
  

      </div>
      
        </div>
    <!--end of left content-->
    <div class="right_content">
      <div class="email_box"> 

	<c:choose>
				<c:when test ="${email==null}">
<form action = "login" method = "post">
      <span class="red">Email:</span> <input type="text" name="email" value="" size="13" required/>
 
      <span class="red">Password:</span> <input type="password" name="password" value="" size="13" required/>
<div class="login_box1">
  		<input class= "login_button" type = "submit" name = accedi value = "login">
  		</div>
 </form>	   
			<div class="reg_pass_box">
	       			<a href="registration" style = "text-decoration: none;">
						<font class="red">Non sono registrato</font>
					</a>
					<br></br>
					<a href = "recoverypwd" style = "text-decoration: none;" >
						<font class="red">Ho dimenticato la password</font>
					</a>    
</div>
      					</c:when>
				<c:otherwise>	
				<div class="welcome">
					<span class="red">Benvenuto <c:out value="${email}"></c:out></span>
					</div>
	<div class="logout_box">
					<form action = "logout" method = "post">
						<input class= "login_button" type = "Submit" value = "Logout">
					</form>		
					</div>
				</c:otherwise>
			</c:choose>		
			</div>
      			<div class="divide_line"></div>	

      <div class="title"><span class="title_icon"><img src="resources/images/bullet3.gif" alt="" /></span>Chi siamo</div>
      <div class="about">
        <p> <img src="resources/images/about.gif" alt="" class="right" /> Flower Shop è un negozio online specializzato dove acquistare velocemente una grande qualità di fiori e piante a prezzi imbattibili per le ricorrenze ed i regali. </p>
      </div>
   
    </div>
    <!--end of right content-->
    <div class="clear"></div>
  </div>
  <!--end of center content-->
  <div class="footer">
    <div class="left_footer"><img src="resources/images/footer_logo.gif" alt="" /><br />
      <a href="http://csscreme.com"><img src="resources/images/csscreme.gif" alt="" border="0" /></a></div>
    <div class="right_footer"> </div>
  </div>
</div>
</body>
</html>
