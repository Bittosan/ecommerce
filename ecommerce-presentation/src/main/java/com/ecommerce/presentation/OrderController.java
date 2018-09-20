package com.ecommerce.presentation;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.OrderManagerRemote;
import application.ProductManagerRemote;
import model.Product;

@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	private boolean flagCart = false;
		
	@Autowired
	private OrderManagerRemote orderOP;
	
	@Autowired
	private ProductManagerRemote productOP;
	
	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String addCart(HttpSession session, Model model,
			@RequestParam int id_product, @RequestParam int quantity){
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		Product product = orderOP.findProduct(id_product);
		if(cart == null){
			cart = new ArrayList<Product>();
			product.setQuantity(quantity);
			cart.add(product);
			flagCart=true;
			session.setAttribute("flagCart", flagCart);
			session.setAttribute("cart", cart);
		}	else	{
			for (int i=0;i<cart.size();i++)
				if (cart.get(i).getId_product()==id_product) {
					cart.get(i).setQuantity(quantity);
					session.setAttribute("flagCart", flagCart);
					session.setAttribute("cart", cart);
					productOP.upgradeAvailability(id_product, quantity);
					flagCart=true;
					return "catalogo";
				}
				cart.add(product);
				flagCart=true;
				product.setQuantity(quantity);
				session.setAttribute("flagCart", flagCart);
				session.setAttribute("cart", cart);
		}	
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
	
	@RequestMapping(value = "/emptycart", method = RequestMethod.POST)
	public String emptycart(HttpSession session, Model model) {		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		
		cart.clear();
		session.setAttribute("cart", cart);
		
		if(cart.size()==0)
		{
			flagCart =false;
			session.setAttribute("flagCart", flagCart);

		}
		
		return "redirect:/viewcart";
	}

}
