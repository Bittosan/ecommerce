<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>Flower Shop</title>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
		<link rel="stylesheet" type="text/css" href="style.css" />
	</head>
	<body>
		<div id="wrap">
  			<div class="header">
    			<div class="logo">
    				<a href="#">
    					<img src="images/logo.gif" alt="" border="0" /></a>
    			</div>
    		</div>
    		<div id="menu">    
      			<ul>
        			<li class="selected"><a href="home.jsp">Home</a></li>
        			<li>
        				<a href="#">Chi siamo</a>
        			</li>
        			<li>
        				<a href="productType?tipo=fioril">Fiori</a>
        			</li>
        			<li>
        				<a href="productType?tipo=vasi">Vasi</a>
        			</li>
        			<li>
        				<a href="productType?tipo=attrezzature">Attrezzature</a>
        			</li>
        			<li>
        				<a href="register.html">Contatti</a>
        			</li>
      			</ul>
    		</div>
  		</div>
	  	<div class="center_content">
	    	<div class="left_content">
	      		<div class="title">
	      			<span class="title_icon">
	      				<img src="images/bullet1.gif" alt="" />
	      			</span>
	      			Featured products
	      		</div>
	      		<div class="feat_prod_box">
	        		<div class="prod_img">
	        			<a href="#">
	        				<img src="images/prod1.gif" alt="" border="0" />
	        			</a>
	        		</div>
	        		<div class="prod_det_box">
	         			<div class="box_top">
	         			</div>
	          			<div class="box_center">
	            			<div class="prod_title">
	            				Product name
	            			</div>
	            			<p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
	            			<a href="#" class="more">- more details -</a>
	            			<div class="clear">
	            			</div>
	          			</div>
	          			<div class="box_bottom">
	          			</div>
	        		</div>
	        		<div class="clear">
	        		</div>
	      		</div>
	      		<div class="feat_prod_box">
	        		<div class="prod_img">
	        			<a href="#">
	        				<img src="images/prod2.gif" alt="" border="0" />
	        			</a>
	        		</div>
	        		<div class="prod_det_box">
	          			<div class="box_top">
	          		</div>
	          		<div class="box_center">
	            		<div class="prod_title">
	            			Product name
	            		</div>
	            		<p class="details">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
	            		<a href="#" class="more">- more details -</a>
	            		<div class="clear"></div>
	          			</div>
	          			<div class="box_bottom">
	          			</div>
	        		</div>
	        		<div class="clear">
	        		</div>
	      		</div>
	      	</div>	
	      	<div class="title">
	      		<span class="title_icon">
	      			<img src="images/bullet2.gif" alt="" />
	      		</span>
	      		New products
	      	</div>
	      	<div class="new_products">
	        	<div class="new_prod_box"> 
	        		<a href="#">
	        			product name
	        		</a>
	          		<div class="new_prod_bg"> 
	          			<span class="new_icon">
	          				<img src="images/new_icon.gif" alt="" />
	          			</span> 
	          			<a href="#">
	          				<img src="images/thumb1.gif" alt="" class="thumb" border="0" />
	          			</a> 
	          		</div>
	        	</div>
	        	<div class="new_prod_box"> 
	        		<a href="#">
	        			product name
	        		</a>
	          		<div class="new_prod_bg"> 
	          			<span class="new_icon">
	          				<img src="images/new_icon.gif" alt="" />
	          			</span> 
	          			<a href="#">
	          				<img src="images/thumb2.gif" alt="" class="thumb" border="0" />
	          			</a>
	          		</div>
	        	</div>
	        	<div class="new_prod_box"> 
	        		<a href="#">
	        			product name
	        		</a>
	          		<div class="new_prod_bg"> 
	          			<span class="new_icon">
	          				<img src="images/new_icon.gif" alt="" />
	          			</span> 
	          			<a href="#">
	          				<img src="images/thumb3.gif" alt="" class="thumb" border="0" />
	          			</a> 
	          		</div>
	        	</div>
	      	</div>
	      	<div class="clear">
	      	</div>
	    </div>
	    <!--end of left content-->
	    <div class="right_content">
	    	<div class="email_box"> 
	    		<span class="red">Email:</span>
	      		<input type="text" name="email" value="" size="13" required/>  
	       	</div>
	    	<div class="password_box"> 
	    		<span class="red">Password: </span> 
	    		<input type = "password" name = "password" value = "" size = "13" required/>
	      	</div>
	       	<div class="login_box">		
	       		<span>
	       			<input type = "submit" name = accedi value = "accedi">
	       		</span>
			</div>
	       	<div class="reg_pass_box">		
	       		<span>
	       			<a href="registration" style = "text-decoration: none;">
						<font class="red">Non sono registrato</font>
					</a>
				</span>
				<span>
					<a href = "recoverypwd" style = "text-decoration: none;" >
						<font class="red">Ho dimenticato la password</font>
					</a>
				</span>
			</div>
			<div class="divide">
			</div>			
	      	<div class="cart">
	        	<div class="title">
	        		<span class="title_icon">
	        			<img src="images/cart.gif" alt="" />
	        		</span>
	        		My cart
	        	</div>
	        	<div class="home_cart_content"> 3 x items | 
	        		<span class="red">TOTAL: 100$</span> 
	        	</div>
	        	<a href="cart.html" class="view_cart">view cart</a> 
	        </div>
	      	<div class="title">
	      		<span class="title_icon">
	      			<img src="images/bullet3.gif" alt="" />
	      		</span>
	      		About Our Shop
	      	</div>
	      	<div class="about">
	        	<p> 
	        		<img src="images/about.gif" alt="" class="right" /> 
	        		Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud. 
	        		</p>
	      	</div>
	      	<div class="right_box">
	        	<div class="title">
	        		<span class="title_icon">
	        			<img src="images/bullet4.gif" alt="" />
	        		</span>
	        		Promotions
	        	</div>
	        	<div class="new_prod_box"> 
	        		<a href="#">product name</a>
	          		<div class="new_prod_bg"> 
	          			<span class="new_icon">
	          				<img src="images/promo_icon.gif" alt="" />
	          			</span>
	          			<a href="#">
	          				<img src="images/thumb1.gif" alt="" class="thumb" border="0" />
	          			</a> 
	          		</div>
	        	</div>
	        	<div class="new_prod_box"> 
	        		<a href="#">product name</a>
	          		<div class="new_prod_bg">
	          			<span class="new_icon">
	          				<img src="images/promo_icon.gif" alt="" />
	          			</span> 
	          			<a href="#">
	          				<img src="images/thumb2.gif" alt="" class="thumb" border="0" />
	          			</a> 
	          		</div>
	        	</div>
	        	<div class="new_prod_box"> 
	        		<a href="#">product name</a>
	          		<div class="new_prod_bg"> 
	          			<span class="new_icon">
	          				<img src="images/promo_icon.gif" alt="" />
	          			</span> 
	          			<a href="#">
	          				<img src="images/thumb3.gif" alt="" class="thumb" border="0" />
	          			</a> 
	          		</div>
	        	</div>
	      	</div>
	      	<div class="right_box">
	        	<div class="title">
	        		<span class="title_icon">
	        			<img src="images/bullet5.gif" alt="" />
	        		</span>
	        		Categories
	        	</div>
	        	<ul class="list">
	          		<li>
	          			<a href="#">accesories</a>
	          		</li>
	          		<li>
	          			<a href="#">flower gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">specials</a>
	          		</li>
	          		<li>
	          			<a href="#">hollidays gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">accesories</a>
	          		</li>
	          		<li>
	          			<a href="#">flower gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">specials</a>
	          		</li>
	          		<li>
	          			<a href="#">hollidays gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">accesories</a>
	          		</li>
	          		<li>
	          			<a href="#">flower gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">specials</a>
	          		</li>
	        	</ul>
	        	<div class="title">
	        		<span class="title_icon">
	        			<img src="images/bullet6.gif" alt="" />
	        		</span>
	        		Partners
	        	</div>
	        	<ul class="list">
	          		<li>
	          			<a href="#">accesories</a>
	          		</li>
	          		<li>
	          			<a href="#">flower gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">specials</a>
	          		</li>
	          		<li>
	          			<a href="#">hollidays gifts</a>
	          		</li>
	         		<li>
	         			<a href="#">accesories</a>
	         		</li>
	          		<li>
	          			<a href="#">flower gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">specials</a>
	          		</li>
	          		<li>
	          			<a href="#">hollidays gifts</a>
	          		</li>
	          		<li>
	          			<a href="#">accesories</a>
	          		</li>
	        	</ul>
	      	</div>
	   	</div>
	    <!--end of right content-->
	    <div class="clear">
	   	</div>
	  	<!--end of center content-->
	  	<div class="footer">
	    	<div class="left_footer">
	    		<img src="images/footer_logo.gif" alt="" />
	      			<a href="http://csscreme.com"><img src="images/csscreme.gif" alt="" border="0" /></a>
	      	</div>
	    	<div class="right_footer"> 
	    		<a href="#">home</a> 
	    		<a href="#">about us</a> 
	    		<a href="#">services</a> 
	    		<a href="#">privacy policy</a> 
	    		<a href="#">contact us</a> 
	    	</div>
	  	</div>
	</body>
</html>