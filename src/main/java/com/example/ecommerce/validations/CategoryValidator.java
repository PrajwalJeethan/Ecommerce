/**
 * 
 */
package com.example.ecommerce.validations;

import java.util.List;
import java.util.function.Predicate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

/**
 * @author pmonthei
 *
 */
public class CategoryValidator implements ConstraintValidator<CategoryUniqueness,Category> {
	
	@Autowired
	private CategoryService categoryService;
	@Override
	public boolean isValid(Category category, ConstraintValidatorContext context) {
		List<Category> categories = categoryService.getAllCategories();
		if(categories == null || categories.isEmpty()) return true;
		Predicate<Category> enteredCategory = c -> c.getName().equalsIgnoreCase(category.getName());
		return  !categories.stream().anyMatch(enteredCategory);
	}
	
	
}
