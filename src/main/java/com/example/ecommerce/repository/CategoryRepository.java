/**
 * 
 */
package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecommerce.model.Category;

/**
 * Repository class for Category entity. 
 * @author pmonthei
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
