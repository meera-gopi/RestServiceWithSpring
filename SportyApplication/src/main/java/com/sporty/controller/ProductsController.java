package com.sporty.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.DTO.ProductAndCategory;
import com.sporty.service.ProductsService;

@RestController
@RequestMapping(value="/Products",method=RequestMethod.GET)

public class ProductsController {
	
	@Autowired 
	ProductsService productsService;
	
	@GetMapping("/ListAllProducts")
	public List<ProductAndCategory> getAllProducts(){
		return productsService.getProducts();
		
	}
	
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody ProductAndCategory prodAndCat) {
		
		String name=prodAndCat.getProdName();
		BigDecimal price=prodAndCat.getPrice();
		long cat_id =prodAndCat.getCategory_id();
		System.out.println(name+price+cat_id);
		return productsService.saveProducts(name,price,cat_id);
		
	}
	
	@PostMapping("/updatePrice/{prod_id}/{price}")
	public String updatePrice(@PathVariable("prod_id") long id,@PathVariable("price") BigDecimal price) {
		return productsService.updateProductPrice(price, id);
	}
	
	@PostMapping("/updateProductName/{prod_id}/{name}")
	public String updateProductName(@PathVariable("prod_id") long id,@PathVariable("name") String name) {
		return productsService.updateProductName(name, id);
	}

	@PostMapping("/updateCategory/{prod_id}/{cat_id}")
		public String updateCategory(@PathVariable("prod_id") long id,@PathVariable("cat_id") long cat_id) {
		return productsService.updateProductCategory(id,cat_id);
	}
	
	@DeleteMapping("/deleteProduct/{prod_id}")
	public String deleteProduct(@PathVariable("prod_id") long id) {
		return productsService.deleteProducts(id);
	}
}


