package com.sporty.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.DTO.ProductAndCategory;
import com.sporty.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
	

	
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
	
	
	@Query(value="select new com.sporty.DTO.ProductAndCategory(p.prod_id,p.name,p.price,c.cat_id,c.name) from Products p JOIN p.category c ")
	List<ProductAndCategory> getProducts();
	
	

}
