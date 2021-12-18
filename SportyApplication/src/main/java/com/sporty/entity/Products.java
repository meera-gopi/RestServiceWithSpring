package com.sporty.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long prod_id;

	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="cat_id")
	private ProductCategory category;
	private BigDecimal price;
	
	

	public Products(String name, ProductCategory category, BigDecimal price) {
		super();
		//this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		
	}

	public Products() {
		super();
	}

	public long getId() {
		return prod_id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}


}
