package com.ecommerce.presentation;

import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
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
	private boolean flagCart = false;
	
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
	
	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String addCart(HttpSession session, Model model,
			@RequestParam int id_product, @RequestParam int quantity){
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
			
		if(cart == null)
		{
			cart = new ArrayList<Product>();
			Product product = productOP.findProduct(id_product);
	//		product.setQuantita(quantity);
			cart.add(product);
			flagCart=true;
	//		session.setAttribute("total", getTotalCart(cart));
			session.setAttribute("flagCart", flagCart);
		}
		else
		{
			Product product = productOP.findProduct(id_product);
	//		product.setQuantita(quantity);
			cart.add(product);
			flagCart=true;
	//		session.setAttribute("total", getTotalCart(cart));
			session.setAttribute("flagCart", flagCart);
		}
		
		
		session.setAttribute("cart", cart);
		
		return "catalogo";
	}
	
	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public String viewcart(HttpSession session, Model model)
	{		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		session.getAttribute("flagCart");
		
		if(cart!=null) {
			model.addAttribute("cart", cart);
			session.setAttribute("cart", cart);
			logger.info("cart: "+cart.toString());
		}
		
		session.setAttribute("flagCart", flagCart);
		
		return "cartshop";
	}
	
	@RequestMapping(value = "/removeproductcart", method = RequestMethod.POST)
	public String removeproductcart(HttpSession session, Model model, @RequestParam int id_product)
	{		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		Product product = new Product();
		
		for(Product p : cart)
		{
			if(p.getId_product()==id_product)
				product= p;
		}
		
		cart.remove(product);
		session.setAttribute("cart", cart);
	//	session.setAttribute("total", getTotalCart(cart));
		logger.info("cart: "+cart.toString());
		
		if(cart.size()==0)
		{
			flagCart =false;
			session.setAttribute("flagCart", flagCart);

		}

				
		return "redirect:/viewcart";
	}
	
	
//	double getTotalCart(ArrayList<Product> cart) {
//		double total=0.0;
//		
//		for(Product p : cart)
//			total+=p.getPrezzo()*p.getQuantita();
//		return total;
//	}
}