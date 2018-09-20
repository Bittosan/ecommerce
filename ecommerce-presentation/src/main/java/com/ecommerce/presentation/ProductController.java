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

/**
 * Servlet implementation class ProductController
 */

@Controller
public class ProductController {
       
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductManagerRemote productOP;
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String catalogo(Locale locale, Model model) {
		
		return "catalogo";
	}
	
	@RequestMapping(value = "/productType", method = RequestMethod.GET)
	public String productView(HttpSession session,Locale locale, Model model, @RequestParam String tipo) {
		
		List<Product> lp=productOP.getProductList(tipo);
		model.addAttribute("list", lp);
		session.setAttribute("list", lp);
		logger.info("nome prodotto: "+lp.toString());
		return "catalogo";
	}
	
//	double getTotalCart(ArrayList<Product> cart) {
//		double total=0.0;
//		
//		for(Product p : cart)
//			total+=p.getPrezzo()*p.getQuantita();
//		return total;
//	}
}