package com.sporty.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sporty.controller.OrderDTO;
import com.sporty.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Long> {
	
	
	
	//Sorting
	//@Query(value="select new com.sporty.controller.OrderDTO(o.order_id,o.orderDate,o.order_complete,i.line_id,i.quantity,i.total_item_cost) from Orders o JOIN o.items i")
	//public List<OrderDTO> sortByDate();
	
	
	//Sorting
		@Query(value="select new com.sporty.controller.OrderDTO(o.order_id,o.orderDate,o.order_complete,i.line_id,i.quantity,i.total_item_cost) from Orders o JOIN o.items i order by o.orderDate desc")
		public List<OrderDTO> sortByDate();
		
		@Query(value="select new com.sporty.controller.OrderDTO(o.order_id,o.orderDate,o.order_complete,i.line_id,i.quantity,i.total_item_cost) from Orders o JOIN o.items i JOIN i.product p JOIN p.category c  where c.cat_id=:cat_id and DATE(o.orderDate)=:orderDate")
		public List<OrderDTO> filterByDateAndCategory(@Param("cat_id") long cat_id,@Param("orderDate") Date orderDate);
		

}
