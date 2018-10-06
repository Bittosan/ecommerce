package com.ecommerce.presentation;

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

import application.UserManagerRemote;
import model.User;

/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
		
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private UserManagerRemote userOP;
	
<<<<<<< HEAD
	private String loginType = null;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		
		  if (session.getAttribute("loginType")==null)
			   session.setAttribute("loginType","guest");

			  loginType=(String) session.getAttribute("loginType");
			  if (loginType.equalsIgnoreCase("guest"))
			   return "home";
			  else {
			   User user = (User) session.getAttribute("user");

			   model.addAttribute("username",null);
			   model.addAttribute("errorlogin",null);

			   if(user!=null)
			   {
			    session.setAttribute("user", user);
			    model.addAttribute("email",user.getEmail());
			    if(user.getUsername().equalsIgnoreCase("admin"))
			     return "administrator";
			   }
			   
			   return "home";
			  }
	}
	
	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public String completeRegistration(Locale locale, Model model, @RequestParam String email, @RequestParam String username
						,@RequestParam String password, @RequestParam String repeat_password ,@RequestParam String name
						,@RequestParam String surname) {
		
		if (password.equals(repeat_password)) {
			if(!userOP.checkUser(email)) 
				userOP.saveUser(email, username, password, name, surname);
			else
				System.out.println("utente gia  esistente");
		}
		model.addAttribute("username", null);
		return "home";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Locale locale, Model model) {
		return "registration";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(HttpSession session, Locale locale, Model model, @RequestParam String email, @RequestParam String password) {
		  
		  User user=userOP.loginControl(email, password);
		  if(user!=null){
		   session.setAttribute("loginType", "authenticated");
		   session.setAttribute("user", user);
		   model.addAttribute("email",user.getEmail());
		   
		   if(email.equalsIgnoreCase("info@flowershop.it"))
		   {
		    session.setAttribute("user", user);
		    model.addAttribute("email",user.getEmail());
		    return "administrator";
		   }
		   
		   return "home";
		  } 
		   else {
		   model.addAttribute("errorlogin", "error");
		   return "errorLogin";
		  }
		  
		 }
=======

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpSession session, Locale locale, Model model) {
		
		User user = (User) session.getAttribute("user");


		model.addAttribute("username",null);
		model.addAttribute("errorlogin",null);

		if(user!=null)
		{
			session.setAttribute("user", user);
			model.addAttribute("email",user.getEmail());
			if(user.getUsername().equalsIgnoreCase("admin"))
				return "administrator";
		}
		
		return "home";
		
	}
	
	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public String completeRegistration(Locale locale, Model model, @RequestParam String email, @RequestParam String username
						,@RequestParam String password, @RequestParam String repeat_password ,@RequestParam String name
						,@RequestParam String surname) {
		
		if (password.equals(repeat_password)) {
			if(!userOP.checkUser(email)) 
				userOP.saveUser(email, username, password, name, surname);
			else
				System.out.println("utente gia  esistente");
		}
		model.addAttribute("username", null);
		return "home";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Locale locale, Model model) {
		return "registration";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String Login(HttpSession session, Locale locale, Model model, @RequestParam String email, @RequestParam String password) {
		
		User user=userOP.loginControl(email, password);
		if(user!=null){
			session.setAttribute("user", user);
			model.addAttribute("email",user.getEmail());
			
			if(email.equalsIgnoreCase("info@flowershop.it"))
			{
				session.setAttribute("user", user);
				model.addAttribute("email",user.getEmail());
				return "administrator";
			}
			
			return "home";
		} 
			else {
			model.addAttribute("errorlogin", "error");
			return "errorLogin";
		}
		
	}
>>>>>>> refs/remotes/ecommerce/master
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String Logout(HttpSession session, Locale locale, Model model) {
		session.setAttribute("user", null);
		session.invalidate();
		model.addAttribute("email", null);
		
		return "home";
	}
	
	@RequestMapping(value = "/pwdchange", method = RequestMethod.POST)
	public String changePwd(Locale locale, Model model, @RequestParam String email, @RequestParam String new_pass) {
		
		User user=userOP.getUser(email);
		if (user!=null) {
			user.setPassword(new_pass);
			userOP.updateUser(user);
		}
		return "home";
	}
	
	@RequestMapping(value = "/recoverypwd", method = RequestMethod.GET)
	public String recoverypwd(Locale locale, Model model) {
		return "recoverypwd";
	}
	
	@RequestMapping(value = "/aboutus", method = RequestMethod.GET)
	public String aboutus(HttpSession session, Locale locale, Model model) {
		
		User user = (User) session.getAttribute("user");

		
		if(user!=null) 
		{
		session.setAttribute("user", user);
		model.addAttribute("email", user.getEmail());
		}
		return "aboutus";
	}
}