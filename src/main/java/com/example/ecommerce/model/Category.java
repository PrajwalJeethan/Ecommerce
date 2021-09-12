/**
 * 
 */
package com.example.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.example.ecommerce.validations.CategoryUniqueness;

/**
 * Entity class for category object
 * @author pmonthei
 *
 */
@Entity
@CategoryUniqueness
public class Category {
	
	@Id
	@SequenceGenerator(name="category_seq",
			sequenceName="category_seq",
			allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
			generator="category_seq")
	@Column(name="category_id")
	private Long categoryId;
	
	@Column(unique=true)
	private String name;
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<Product> products;


	public Category() {
		
	}
	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
