/**
 * 
 */
package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.CategoryRepository;

/**
 * Business logic implementation for product Category is made by this class. 
 * @author pmonthei
 *
 */
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void addCategory(Category category) {
		if(category.getProducts() == null) {
			category.setProducts(new ArrayList<Product>());
		}
		categoryRepository.save(category);
	}
	
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}

	public void deleteCategoryById(Long id) {
		categoryRepository.deleteById(id);
		
	}

	public Category getCategoryById(Long id) {
		
		return categoryRepository.getById(id);
	}

	
}
