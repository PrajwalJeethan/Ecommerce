/**
 * 
 */
package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repository.ProductRepository;

/**
 * Service class for product entity
 * @author pmonthei
 *
 */
@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private Mapper mapper;
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	public void saveProduct(ProductDao productDao, Category category,byte[] image) {

		Product product = mapper.map(productDao, Product.class);
		product.setCategory(category);
		product.setImage(Base64.getEncoder().encodeToString(image));
		category.getProducts().add(product);
		productRepository.save(product);
	}

	public void removeProduct(Long id) {
		
		productRepository.deleteById(id);
	}

	public List<Product> searchForProductsByCategoryId(Long categoryId, String keyword) {
		List<Product> products =  new ArrayList<>();
		if(categoryId == 0) {
			products = productRepository.findByNameContainingIgnoreCase(keyword);
		}else {
			products = productRepository.findByCategoryCategoryIdAndNameContainingIgnoreCase(categoryId,keyword);
		}
		return  products;	
	}

	public List<Product> getAllProductsByCategoryId(Long categoryId) {
		
		return productRepository.findProductsByCategoryId(categoryId);
	}

	public Optional<Product> getAllProductsById(Long id) {
		
		return productRepository.findById(id);
	}

	public Optional<Product> getProductById(Long id) {
		
		return productRepository.findById(id);
	}
}
