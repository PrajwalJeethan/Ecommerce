package com.example.ecommerce;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ecommerce.model.Category;
import com.example.ecommerce.service.CategoryService;

@SpringBootTest
class EcommerceApplicationTests {
	@Autowired
	private CategoryService categoryService;
	@Test
	void contextLoads() {
		List<Category> category = categoryService.getAllCategories();
		category.stream().forEach(c -> System.out.println(c.getName()));
	}

}
