package com.sporty.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.DTO.ProductAndCategory;
import com.sporty.entity.ProductCategory;
import com.sporty.entity.Products;
import com.sporty.repository.ProductCategoryRepository;
import com.sporty.repository.ProductsRepository;
import com.sporty.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ProductCategoryRepository productCategoryRepository;
	


	@Override
	public String updateProductCategory(long prod_id,long cat_id) {
		Optional<ProductCategory> prod_cat = productCategoryRepository.findById(cat_id);
		
		if(prod_cat.isPresent()) {
			Products prod1 = productsRepository.getById(prod_id);
				
			prod1.setCategory(prod_cat.get());
			
			productsRepository.save(prod1);
			//updateCategoryById(cat.getCat_id(), prod_id);
			return " Updated the Category";
			
		}
		
		else {
		// TODO Auto-generated method stub
		return"Category not Available.Please add the category ." ;}
	}

	@Override
	public String deleteProducts(long id) {
		
		Optional<Products> prod = productsRepository.findById(id);
		if(prod.isPresent())
		{
			productsRepository.deleteById(id);
			
		return "Product is deleted";}
		
		else {
			return "No such Product is not Available";
		}
	}

	@Override
	public String updateProductName(String name,long id) {
		productsRepository.updateNameById(name, id);
		return "Updated product Name";
	}

	@Override
	public String updateProductPrice(BigDecimal price,long id) {
		productsRepository.updatePriceById(price, id);
		return "Price Updated";
	}
	
	

//	@Override
//	public List<Products> getProducts(long categoryId) {
//		List<Products> prod_list = productsRepository.getProductsbyCategory(categoryId);
//		return prod_list;
//	}

	@Override
	public List<ProductAndCategory> getProducts() {
		List<ProductAndCategory> prod_List = productsRepository.getProducts();
		return prod_List;
	}

	@Override
	public String saveProducts(String prod_name, BigDecimal price, long category_id) {
		long category_id1=1;
		 ProductCategory prod_cat =productCategoryRepository.getById(category_id);
		//Optional<ProductCategory> prod_cat = productCategoryRepository.findById(category_id1);
		Products prod = new Products();
		if(Objects.nonNull(prod_cat)) {
			prod.setCategory(prod_cat);
			prod.setName(prod_name);
			prod.setPrice(price);
			productsRepository.save(prod);
			return " Product details are Saved. ";
		}
				
		else {
			return"Category not Available.Please add the category ." ;}
	}

	@Override
	public Products getProduct(long prod_id) {
		return productsRepository.getById(prod_id);
		
	}

}
