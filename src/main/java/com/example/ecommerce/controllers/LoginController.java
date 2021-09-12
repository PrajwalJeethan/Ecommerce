/**
 * 
 */
package com.example.ecommerce.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ecommerce.common.GlobalData;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.CustomerUserDetailsService;

/**
 * @author pmonthei
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@GetMapping("/login")
	public String login() {
		GlobalData.cart.clear();
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("user") User user,HttpServletRequest request) throws ServletException{
		User registeredUser = customerUserDetailsService.registerUser(user);
		request.login(registeredUser.getEmail(), registeredUser.getPassword());
		return "redirect:/";
	}

}
