package com.sporty.service;

import java.math.BigDecimal;
import java.util.List;

import com.sporty.entity.OrderItems;
import com.sporty.entity.Orders;
import com.sporty.entity.Products;

public interface OrderItemsService {

	//Save Items
	public String saveItems(long quantity, Products product, Orders orders);
	
	//Delete Items
	public String deleteItem(long id);
	
	//Order
	public List<OrderItems> OrderByCategory();
	
}
