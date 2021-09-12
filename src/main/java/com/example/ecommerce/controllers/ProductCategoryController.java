/**
 * 
 */
package com.example.ecommerce.controllers;

import java.util.List;
import java.util.function.Predicate;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;


/**
 * Controller class for categories page.
 * @author pmonthei
 *
 */

@Controller
@RequestMapping("/admin/products/categories")
public class ProductCategoryController {
	
	public final static Logger LOG =  LoggerFactory.getLogger(ProductCategoryController.class);
	@Autowired
	private CategoryService categoryService;
	@GetMapping("/add")
	public String getAddCategory(Model model) {
		model.addAttribute("category",new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/add")
	public String postAddCategory(@Valid @ModelAttribute("category") Category category,BindingResult bindingResult,Model model) {
		if(!bindingResult.hasErrors()) {
			model.addAttribute("erroMsg", null);
			categoryService.addCategory(category);
		}else {
			LOG.debug("category: "+category.getName()+" is already present in Database");
			String errorMessage = bindingResult.getGlobalError().getDefaultMessage();
			model.addAttribute("erroMsg", errorMessage);
			return "categoriesAdd"; // be in same page.
		}
		
		return "redirect:/admin/products/categories";
	}
	
	@GetMapping("")
	public String getAllCategories(Model model) {
		List<Category> categories = categoryService.getAllCategories();
		model.addAttribute("categories",categories);
		return "categories";
	}
	@GetMapping("/delete/{id}")
	public String deleteCategory(@PathVariable Long id, Model model) {
		categoryService.deleteCategoryById(id);
		return "redirect:/admin/products/categories";
	}
	@GetMapping("/update/{id}")
	public String updateCategory(@PathVariable Long id,Model model) {
		Category category = categoryService.getCategoryById(id);
		model.addAttribute("category", category);
		return "categoriesAdd";
	}
}
