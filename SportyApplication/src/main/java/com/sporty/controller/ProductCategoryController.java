package com.sporty.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.entity.ProductCategory;
import com.sporty.entity.Products;
import com.sporty.service.ProductCategoryService;

@RestController
@RequestMapping(value="/ProdCategory",method=RequestMethod.GET)
public class ProductCategoryController {
	
	@Autowired
	ProductCategoryService productCategoryService;
	
	
	@PostMapping("/saveCategory")
	public String saveCategory(@RequestBody ProductCategory cat ) {
		
		return productCategoryService.addCategory(cat);
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") long categoryId) {
		return productCategoryService.removeCategory(categoryId);
	}
	
	@GetMapping("/category and Products")
	public List<ProductCategory> getProductCategoryDetails(){
		return productCategoryService.categoryList();
	}
	
}
