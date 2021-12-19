package com.sporty.service;

import java.util.Date;
import java.util.List;

import com.sporty.DTO.OrderDTO;
import com.sporty.entity.AppUsers;
import com.sporty.entity.OrderItems;
import com.sporty.entity.Orders;

import antlr.collections.impl.LList;

public interface OrdersService {
	
	//newOrder
	public Orders saveOrder(Date order_date,boolean paid,AppUsers users);

	//Save Order
	public String saveOrder(Date order_date,boolean paid,List<OrderItems> items);
	
	//Retrieve order based on Date and category
	
	public List<OrderDTO> sortedOrderByDate() ;
	
	public List<Orders> sortedOrderByDateAndCategory() ;
	
	//Retrieve orders based on date and category
	public List<OrderDTO> filterByDateAndCategory(long cat_id,Date orderDate) ;
	
}
