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
	

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		model.addAttribute("username",null);
		model.addAttribute("errorlogin",null);
		return "home";
	}
	
	@RequestMapping(value = "/registrationController", method = RequestMethod.POST)
	public String completeRegistration(Locale locale, Model model, @RequestParam String email, @RequestParam String username
						,@RequestParam String password, @RequestParam String confPassword ,@RequestParam String nome
						,@RequestParam String cognome) {
		
		if (password.equals(confPassword)) {
			if(!userOP.checkUser(email)) 
				userOP.saveUser(email, username, password, nome, cognome);
			else
				System.out.println("utente già esistente");
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
			return "home";
		} else {
			model.addAttribute("errorlogin", "error");
			return "errorLogin";
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String Logout(HttpSession session, Locale locale, Model model) {
		session.setAttribute("user", null);
		session.invalidate();
		model.addAttribute("email", null);
		
		return "home";
	}
	
	@RequestMapping(value = "/pwdchange", method = RequestMethod.POST)
	public String changePwd(Locale locale, Model model, @RequestParam String email, @RequestParam String newpwd) {
		
		User user=userOP.getUser(email);
		if (user!=null) {
			user.setPassword(newpwd);
			userOP.updateUser(user);
		}
		return "home";
	}
	
	@RequestMapping(value = "/recoverypwd", method = RequestMethod.GET)
	public String recoverypwd(Locale locale, Model model) {
		return "recoverypwd";
	}
}