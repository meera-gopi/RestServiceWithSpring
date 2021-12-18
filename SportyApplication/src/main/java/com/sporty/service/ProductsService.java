package com.sporty.service;

import java.math.BigDecimal;
import java.util.List;

import com.sporty.entity.ProductCategory;
import com.sporty.entity.Products;

public interface ProductsService {
	
	//Save Products
	//String saveProducts(Products prod,ProductCategory cat);
	String saveProducts(String prod_name,BigDecimal price,long category_id);
	
	//Update Product Category
	String updateProductCategory(long prod_id,long cat_id);
	
	//Delete Product
	String deleteProducts(long id);
	
	//Update Product Name
	String updateProductName(String name,long id);
	
	//Update ProductPrice
	String updateProductPrice(BigDecimal price,long id);
	
	//Get Products by Category
	//List<Products> getProducts(long categoryId);
	
	//Get Products
	List<Products> getProducts();
	
	//get product by id
	Products getProduct(long id);

}
