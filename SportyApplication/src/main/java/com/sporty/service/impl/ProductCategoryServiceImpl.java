package com.sporty.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.entity.ProductCategory;
import com.sporty.entity.Products;
import com.sporty.repository.ProductCategoryRepository;
import com.sporty.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public String addCategory(ProductCategory cat) {

		
		
		productCategoryRepository.save(cat);
		return "Added New Category "+cat.getName();
	}

	@Override
	public String removeCategory(long categoryId) {
		Optional<ProductCategory> cat1= productCategoryRepository.findById(categoryId);
		if(cat1.isPresent()) {
			productCategoryRepository.delete(cat1.get());
			return "Category Removed";
		}
		else{
			return "Category Not Removed";
		}
	}

	@Override
	public List<ProductCategory> categoryList() {
		List<ProductCategory> cat_list1 = productCategoryRepository.findAll();
		return cat_list1;
	}

}
