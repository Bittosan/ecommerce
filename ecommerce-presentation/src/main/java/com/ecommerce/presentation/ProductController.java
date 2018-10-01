package com.ecommerce.presentation;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.ProductManagerRemote;
import model.Product;
import model.User;

/**
 * Servlet implementation class ProductController
 */

@Controller
public class ProductController {
       
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductManagerRemote productOP;
	
	@RequestMapping(value = "/viewdetails", method = RequestMethod.GET)
	public String catalogo(HttpSession session, Locale locale, Model model, @RequestParam int id_product) {
		
		User user = (User) session.getAttribute("user");

		Product p = productOP.findProduct(id_product);
		model.addAttribute("product", p);
		session.setAttribute("product", p);
		
		if(user!=null) 
		{
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
		}
		return "details";
	}
	
	
	@RequestMapping(value = "/productType", method = RequestMethod.GET)
	public String productView(HttpSession session,Locale locale, Model model, @RequestParam String tipo) {
		User user = (User) session.getAttribute("user");

		
		List<Product> lp=productOP.getProductList(tipo);
		model.addAttribute("list", lp);
		session.setAttribute("list", lp);
		session.setAttribute("type", tipo);	
		if(user!=null) 
		{
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
		}
		logger.info("nome prodotto: "+lp.toString());
		return "category";

	}
	
}