package com.sporty.service;

import java.util.List;
import java.util.Set;

import com.sporty.entity.ProductCategory;
import com.sporty.entity.Products;

public interface ProductCategoryService {
	
	//Insert Category
	String addCategory(ProductCategory cat);
	
	//Remove Category
	String removeCategory(long categoryId);
	
	//List Categories
	List<ProductCategory> categoryList();
	

}
