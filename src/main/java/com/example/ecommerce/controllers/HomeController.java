/**
 * 
 */
package com.example.ecommerce.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecommerce.common.GlobalData;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;

/**
 * Controller class for home page
 * @author pmonthei
 *
 */
@Controller
public class HomeController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping({"/","/home"})
	public String home(Model model) {
		model.addAttribute("category",new Category());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "index";
	}
	
	@SuppressWarnings("null")
	@GetMapping("/shop")
	public String getSearchProduct(@ModelAttribute("category") Category category,@RequestParam(name="keyword",defaultValue="") String keyword, Model model) {
		if((category.getCategoryId()== null || category.getCategoryId() == 0 )
				&& keyword != null && keyword.isEmpty()) {
			model.addAttribute("category",new Category());
		}else {
			model.addAttribute("category",categoryService.getCategoryById(category.getCategoryId()));
		}
		model.addAttribute("categories", categoryService.getAllCategories());
		List<Product> products = new ArrayList<>();
		if(category != null && category.getCategoryId() != null && keyword != "") {
			products = productService.searchForProductsByCategoryId(category.getCategoryId(),keyword);
		}else {
			products = productService.getAllProducts();
		}
		model.addAttribute("keyword", keyword);
		model.addAttribute("products", products);
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}
	
	@GetMapping("/shop/category/{id}")
	public String getProductByCategoryId(Model model,@PathVariable Long id) {
		model.addAttribute("category",new Category());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("products", productService.getAllProductsByCategoryId(id));
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "shop";
	}
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable Long id) {
		model.addAttribute("product", productService.getAllProductsById(id).get());
		model.addAttribute("cartCount", GlobalData.cart.size());
		return "viewProduct";
	}
	
	
	
	
}
