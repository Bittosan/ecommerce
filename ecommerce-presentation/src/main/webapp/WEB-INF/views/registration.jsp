<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <html>
<head>
<title>Flower Shop</title>
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
</head>
<body>
<div id="wrap">
  <div class="header">
    <div class="logo"><a href="#"><img src="resources/images/logo.gif" alt="" border="0" /></a></div>
    <div id="menu">
      <ul>
        <li><a href="home">Home</a></li>
        <li><a href="productType?tipo=Fiori">Fiori</a></li>
        <li><a href="productType?tipo=Vasi">Vasi</a></li>
        <li><a href="productType?tipo=Attrezzature">Attrezzature</a></li>
        <li><a href="aboutus">Chi siamo</a></li>
      </ul>
    </div>
  </div>
<div class="center_content">
    <div class="left_content">
      <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" /></span>Registrazione</div>
      <div class="feat_prod_box_details">
        <p class="details"> Inserisci i tuoi dati per poter proseguire con la registrazione del tuo account</p>
        <div class="contact_form">
          <div class="form_subtitle">Crea nuovo account</div>
          <form name="register" action = "registrationController" method = "post">
            <div class="form_row">
              <label class="contact"><strong>Email:</strong></label>
              <input type="text" class="contact_input" name = "email" value = "" required/>
              <c:if test = "${email == null }"></c:if>
            </div>
            <div class="form_row">
              <label class="contact"><strong>Username:</strong></label>
              <input type="text" class="contact_input" name = "username" required/>
              <c:if test = "${username == null }"></c:if>
            </div>
            <div class="form_row">
              <label class="contact"><strong>Password:</strong></label>
              <input type = "password" class="contact_input"  name = "password" value = "" required/>
              <c:if test = "${password == null }"></c:if>
            </div>
            <div class="form_row">
              <label class="contact"><strong>Ripeti Pass:</strong></label>
              <input type = "password" class="contact_input" name= "repeat_password" value = "" required/>
              <c:if test = "${confPassword == null }"></c:if>
            </div>
            <div class="form_row">
              <label class="contact"><strong>Nome:</strong></label>
              <input type="text" class="contact_input" name = "name" value = "" required/>
              <c:if test = "${name == null }"></c:if>
            </div>
            <div class="form_row">
              <label class="contact"><strong>Cognome:</strong></label>
              <input type="text" class="contact_input"  name = "surname" value = "" required/>
              <c:if test = "${surname == null }"></c:if>
            </div>
           <div class="form_row">
              <label class="contact"><strong>Numero Carta Credito:</strong></label>
            </div>
            <div class="form_row">
              <input type="submit" class="register" value="Registrati" />
            </div>
          </form>
        </div>
      </div>
      <div class="clear"></div>
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
      			<c:if test="${not empty email}">
       <div class="cart">
        <div class="title"><span class="title_icon"><img src="resources/images/cart.gif" alt="" /></span><a href="viewcart" class="red">Visualizza il carrello</a></div>             
        </div>
        </c:if>
      <div class="title"><span class="title_icon"><img src="resources/images/bullet3.gif" alt="" /></span>Chi siamo</div>
      <div class="about">
        <p> <img src="resources/images/about.gif" alt="" class="right" /> Flower Shop è un negozio online specializzato dove acquistare velocemente una grande qualità di fiori e piante a prezzi imbattibili per le ricorrenze ed i regali. </p>
      </div>
      <div class="right_box">
        <div class="title"><span class="title_icon"><img src="resources/images/bullet4.gif" alt="" /></span>Promozioni</div>
        <div class="new_prod_box"><span class="red">Tulipani Rosa</span>
          <div class="new_prod_bg"> <span class="new_icon"><img src="resources/images/promo_icon.gif" alt="" /></span> <img src="resources/images/thumb1.gif" alt="" class="thumb" border="0" /></div>
        </div>
        <div class="new_prod_box"><span class="red">Bouquet Viola</span>
          <div class="new_prod_bg"> <span class="new_icon"><img src="resources/images/promo_icon.gif" alt="" /></span> <img src="resources/images/thumb2.gif" alt="" class="thumb" border="0" /></div>
        </div>
      </div>
      <div class="right_box">
        <div class="title"><span class="title_icon"><img src="resources/images/bullet4.gif" alt="" /></span>Promozioni</div>
        <div class="new_prod_box"><span class="red">Bouquet Giallo</span>
          <div class="new_prod_bg"> <span class="new_icon"><img src="resources/images/promo_icon.gif" alt="" /></span><img src="resources/images/thumb3.gif" alt="" class="thumb" border="0" /></div>
        </div>
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