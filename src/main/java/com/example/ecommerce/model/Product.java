/**
 * 
 */
package com.example.ecommerce.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 * Entity class for product table
 * @author pmonthei
 *
 */
@Entity
public class Product {
	@Id
	@SequenceGenerator(name="product_seq",
					sequenceName="product_seq",
					allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@Column(name="product_id")
	private Long productId;
	private String name;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="category_id",referencedColumnName="category_id")
	private Category category;
	private double price;
	private String description;
	@Lob
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long id) {
		this.productId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
