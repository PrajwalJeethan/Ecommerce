/**
 * 
 */
package com.example.ecommerce.controllers;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;



/**
 * Controller class for product page
 * @author pmonthei
 *
 */
@Controller
@RequestMapping("/admin/products")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@GetMapping("/add")
	public String addProduct(Model model) {
		model.addAttribute("productDAO", new ProductDao());
		model.addAttribute("categories", categoryService.getAllCategories());
		return "productsAdd";
		
	}
	
	@GetMapping("")
	public String getProducts(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products";
	}
	@PostMapping("/add")
	public String addProduct(@ModelAttribute("productDAO") ProductDao productDao,
							@RequestParam("productImage") MultipartFile file,
							@RequestParam("imgName")String imgName) throws IOException{
		Category category = categoryService.getCategoryById(productDao.getCategoryId());
		
		productService.saveProduct(productDao,category,file.getBytes());
		return "redirect:/admin/products";
	}
	@GetMapping("delete/{id}")
	public String deleteProduct(@PathVariable Long id ) {
		productService.removeProduct(id);
		return "redirect:/admin/products";
	}
}
