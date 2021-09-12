/**
 * 
 */
package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * Controller class for Admin home page
 * @author pmonthei
 *
 */
@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public String adminHomePage() {
		return "adminHome";
	}
	
	@GetMapping("/admin/orders")
	public String manageOrders() {
		return "orders";
	}
	
	
	
	@GetMapping("/admin/reports")
	public String manageReports() {
		return "reports";
	}

}
