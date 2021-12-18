package com.sporty.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	
//	//Update Product category
//	@Modifying
//	@Transactional
//	@Query(value="update products p set p.cat_id=:cat_id where p.id=:id")
//	void updateCategoryById(@Param("cat_id") long cat_id,@Param("id") long id);
	
	//update ProductName
	@Modifying
	@Transactional
	@Query(value="update Products p set p.name=:name where p.id=:id")
	void updateNameById(@Param("name") String name,@Param("id") long id);
	
	//update Product Price
	@Modifying
	@Transactional
	@Query(value="update Products p set p.price=:price where p.id=:id")
	void updatePriceById(@Param("price") BigDecimal price,@Param("id") long id);
	
	//List products for selected category
	//@Modifying
	//@Transactional
	//@Query(value="select p from products p where p.cat_id=:cat_id")
	//List<Products> getProductsbyCategory(@Param("cat_id") long cat_id);
	
	

}
