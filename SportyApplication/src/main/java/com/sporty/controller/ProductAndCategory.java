package com.sporty.controller;

import java.math.BigDecimal;

import com.sporty.entity.ProductCategory;
import com.sporty.entity.Products;


public class ProductAndCategory {
	//private Products prod;
	String prodName;
	BigDecimal price;
	long category_id;
	long prod_id;
    private ProductCategory cat;
	
	public ProductAndCategory() {
		
	}
	
	public ProductAndCategory(String prodName, BigDecimal price, long category_id) {
		super();
		this.prodName = prodName;
		this.price = price;
		this.category_id = category_id;
	}
	
	public ProductAndCategory(long prod_id,ProductCategory cat) {
		this.prod_id=prod_id;
		this.cat=cat;
	}
	
	
	public String getProdName() {
		return prodName;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public ProductCategory getCat() {
		return cat;
	}

	public void setCat(ProductCategory cat) {
		this.cat = cat;
	}
	
	
	
	
}
