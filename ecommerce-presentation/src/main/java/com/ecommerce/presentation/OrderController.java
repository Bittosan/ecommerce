package com.ecommerce.presentation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


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
import model.User;

@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//private boolean flagCart = false;
	private int idOrder = 1;
		
	@Autowired
	private OrderManagerRemote orderOP;
	
	@Autowired
	private ProductManagerRemote productOP;
	
	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String addCart(HttpSession session, Model model,
			@RequestParam int id_product, @RequestParam int quantity){
		User user = (User) session.getAttribute("user");

		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		Product product = orderOP.findProduct(id_product);
		if(cart == null){
			cart = new ArrayList<Product>();
			product.setQuantity(quantity);
			cart.add(product);
	//		flagCart=true;
	//		session.setAttribute("flagCart", flagCart);
			session.setAttribute("cart", cart);
			if(user!=null) 
			{
			session.setAttribute("user", user);
			model.addAttribute("email", user.getEmail());
			}
		}	else	{
			for (int i=0;i<cart.size();i++)
				if (cart.get(i).getId_product()==id_product) {
					cart.get(i).setQuantity(quantity);
	//				session.setAttribute("flagCart", flagCart);
					session.setAttribute("cart", cart);
					productOP.upgradeAvailability(id_product, quantity);
	//				flagCart=true;
					return "category";
				}
				cart.add(product);
	//			flagCart=true;
				product.setQuantity(quantity);
	//			session.setAttribute("flagCart", flagCart);
				session.setAttribute("cart", cart);
				if(user!=null) 
				{
				session.setAttribute("user", user);
				model.addAttribute("email", user.getEmail());
				}
		}	
		return "category";
	}
	
	@RequestMapping(value = "/viewcart", method = RequestMethod.GET)
	public String viewcart(HttpSession session, Model model)
	{		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");

		session.getAttribute("flagCart");
		
		if(cart!=null) {
			model.addAttribute("cart", cart);
			session.setAttribute("cart", cart);
			session.setAttribute("total", getTotalCart(cart));
			logger.info("cart: "+cart.toString());
		}
		
		if(user!=null) 
		{
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
		}
	//	session.setAttribute("flagCart", flagCart);
		
		return "cartshop";
	}
	
	@RequestMapping(value = "/removeproductcart", method = RequestMethod.POST)
	public String removeproductcart(HttpSession session, Model model, @RequestParam int id_product)
	{		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");

		Product product = new Product();
		
		for(Product p : cart)
		{
			if(p.getId_product()==id_product)
				product= p;
		}
		
		cart.remove(product);
		session.setAttribute("cart", cart);
		logger.info("cart: "+cart.toString());
		
		if(cart.size()==0)
		{
	//		flagCart =false;
	//		session.setAttribute("flagCart", flagCart);

		}
		
		if(user!=null) 
		{
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
		}
		
		return "redirect:/viewcart";
	}
	
	@RequestMapping(value = "/emptycart", method = RequestMethod.POST)
	public String emptycart(HttpSession session, Model model) {		
		User user = (User) session.getAttribute("user");
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		
		cart.clear();
		session.setAttribute("cart", cart);
		
		if(cart.size()==0)
		{
	//		flagCart =false;
	//		session.setAttribute("flagCart", flagCart);
			session.setAttribute("total", getTotalCart(cart));
		}
		
		if(user!=null) 
		{
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
		}
		
		return "redirect:/viewcart";
	}
	
	@RequestMapping(value = "/vieworder", method = RequestMethod.GET)
	public String vieworder(HttpSession session, Model model) {		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		if(cart!=null) {
			
			model.addAttribute("cart", cart);
			session.setAttribute("cart", cart);
			session.setAttribute("user", user);
			model.addAttribute("email", user.getEmail());
			session.setAttribute("total", getTotalCart(cart));
			logger.info("cart: "+cart.toString());
		}
		return "vieworder";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String checkout(HttpSession session, Model model) {		
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		User user = (User) session.getAttribute("user");
		Product p;
		for (int i=0;i<cart.size();i++) {
			p=orderOP.findProduct(cart.get(i).getId_product());
			if (cart.get(i).getQuantity()>p.getAvailability())
				model.addAttribute("checkout_error", true);
		} 
		
		GregorianCalendar gc = new GregorianCalendar();
		String purchase_data = gc.get(Calendar.DAY_OF_MONTH) + "-" + gc.get(Calendar.MONTH) + "-" + gc.get(Calendar.YEAR);
		
  

        for(Product p1 : cart)
        {
    		System.out.println(p1.getId_product());
    		System.out.println(purchase_data);
    		System.out.println(p1.getQuantity());
    		System.out.println(getTotalCart(cart));
    		System.out.println(user.getEmail());
    		System.out.println(orderOP.getLastIdOrder());
 		orderOP.addOrderDB(orderOP.getLastIdOrder()+1, getTotalCart(cart), purchase_data, p1.getId_product(), p1.getQuantity(), user.getEmail());
 		orderOP.addOrdersLogger(orderOP.getLastIdOrder()+1, p1.getId_product(), purchase_data, user.getEmail());
 		System.out.println("ORDINE CREATO");		
        }

        
    
        
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
        
		return "checkout";
	}
	
	
	
	private float getTotalCart(ArrayList<Product> cart) 
	{
	float total=0;
	
	for(Product p : cart)
		total+=p.getPrice()*p.getQuantity();
	return total;
	}
}
