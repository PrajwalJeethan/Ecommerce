/**
 * 
 */
package com.example.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Product;

/**
 * @author pmonthei
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	@Query(value="SELECT * FROM product p WHERE p.category_id =:categoryId and p.name like UPPER(concat('%', :keyword,'%'))",
//			nativeQuery = true
//			)
	List<Product> findByCategoryCategoryIdAndNameContainingIgnoreCase(Long categoryId, String keyword);
	
	
	List<Product> findByNameContainingIgnoreCase(String keyword);
	
	@Query(value="SELECT * FROM product p WHERE p.category_id =:categoryId",
			nativeQuery = true
			)
	List<Product> findProductsByCategoryId(Long categoryId);

}
