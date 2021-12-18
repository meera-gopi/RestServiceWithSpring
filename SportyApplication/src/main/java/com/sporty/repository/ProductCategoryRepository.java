package com.sporty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.entity.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
	
@Query(value="select p.cat_id from ProductCategory p where p.name=:name")
public long getCategoryIdFromName(@Param("name")String name);
	
}

