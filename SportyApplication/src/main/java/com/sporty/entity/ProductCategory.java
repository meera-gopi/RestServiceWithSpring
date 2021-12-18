package com.sporty.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	
	@Entity
	@Table(name="product_category")
	public class ProductCategory {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long cat_id;
		private String name;
		
		@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
		private List<Products> products_list ;//= new HashSet<>();

		public ProductCategory(String name) {
			super();
			//this.id = id;
			this.name = name;
		}

		public ProductCategory() {
			
		}

		
//		public void setId(long id) {
//			this.id = id;
//		}

		public long getCat_id() {
			return cat_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Products> getProducts_list() {
			return products_list;
		}

		public void setProducts_list(List<Products> products_list) {
			this.products_list = products_list;
		}

	


}
