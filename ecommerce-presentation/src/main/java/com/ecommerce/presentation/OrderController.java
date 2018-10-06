package com.ecommerce.presentation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import model.OrdersLogger;
import model.Product;
import model.User;

@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
		
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
					session.setAttribute("cart", cart);
					productOP.upgradeAvailability(id_product, quantity);
					return "category";
				}
				cart.add(product);
				product.setQuantity(quantity);
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
	public String checkout(HttpSession session, Model model, String creditCard) {		
		User user = (User) session.getAttribute("user");
		String message = null;
		
		if (controlloNumeroCarta(creditCard))
		{
			session.setAttribute("controlCreditCard", message);
		}
		else
		{
			session.setAttribute("user", user);
			model.addAttribute("email", user.getEmail());
			message = "Numero carta errato";
			session.setAttribute("controlCreditCard", message);
			return "vieworder";
		}
			
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		
		Product p;
		for (int i=0;i<cart.size();i++) {
			p=orderOP.findProduct(cart.get(i).getId_product());
			if (cart.get(i).getQuantity()>p.getAvailability())
				model.addAttribute("checkout_error", true);
		} 
		
		GregorianCalendar gc = new GregorianCalendar();
		String purchase_data = gc.get(Calendar.DAY_OF_MONTH) + "-" + (gc.get(Calendar.MONTH)+1) + "-" + gc.get(Calendar.YEAR);
	
		int id_order=orderOP.getLastIdOrder()+1;
		
        for(Product p1 : cart)
        {
    		System.out.println(p1.getId_product());
    		System.out.println(purchase_data);
    		System.out.println(p1.getQuantity());
    		System.out.println(getTotalCart(cart));
    		System.out.println(user.getEmail());
    		    		
    	productOP.upgradeAvailability(p1.getId_product(), p1.getAvailability()-p1.getQuantity());
 		orderOP.addOrderDB(id_order, getTotalCart(cart), purchase_data, p1.getId_product(), p1.getQuantity(), user.getEmail());
    	orderOP.addOrdersLoggerQueue(id_order, p1.getId_product(), purchase_data, user.getEmail());	
        }
         
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
        
		emptycart(session, model);
		
		return "checkout";
	}
	
	
	@RequestMapping(value = "/orderlogger", method = RequestMethod.GET)
	public String orderlog(HttpSession session, Model model) {		
		
		User user = (User) session.getAttribute("user");

		ArrayList<OrdersLogger> oL = orderOP.getAllOrderLogger();
		model.addAttribute("orderLogger", oL);
		session.setAttribute("orderLogger", oL);
			session.setAttribute("user", user);
			model.addAttribute("email", user.getEmail());

		return "orderslogger";
	}
	
	
    public static boolean controlloNumeroCarta(String creditCard) {
        if (creditCard != null) {
            Pattern pattern = Pattern.compile("[0-9]{16}");
            Matcher matcher = pattern.matcher(creditCard);
            return matcher.matches();
        }
        return false;
    }
		
	private float getTotalCart(ArrayList<Product> cart) 
	{
	float total=0;
	
	for(Product p : cart)
		total+=p.getPrice()*p.getQuantity();
	return total;
	}
}
