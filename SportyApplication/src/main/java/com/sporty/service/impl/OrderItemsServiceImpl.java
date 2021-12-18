package com.sporty.service.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.entity.OrderItems;
import com.sporty.entity.Orders;
import com.sporty.entity.Products;
import com.sporty.repository.OrderItemsRepository;
import com.sporty.service.OrderItemsService;
@Service
public class OrderItemsServiceImpl implements OrderItemsService {
	
	@Autowired
	OrderItemsRepository orderItemsRepository;

	@Override
	public String saveItems(long quantity, Products product, Orders orders) {
		OrderItems orderItems = new OrderItems();
		
		orderItems.setQuantity(quantity);		
		orderItems.setOrders(orders);
		orderItems.setProduct(product);
		BigDecimal total = new BigDecimal(BigInteger.ZERO,2);
		total = (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
		
		orderItems.setTotal_item_cost(total);
		orderItemsRepository.save(orderItems);
		return "Items Saved";
	}

	@Override
	public String deleteItem(long id) {
		orderItemsRepository.deleteById(id);
		return "Line Item Removed";
	}

	@Override
	public List<OrderItems> OrderByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
