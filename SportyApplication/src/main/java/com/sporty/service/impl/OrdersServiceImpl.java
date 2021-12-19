package com.sporty.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.DTO.OrderDTO;
import com.sporty.entity.AppUsers;
import com.sporty.entity.OrderItems;
import com.sporty.entity.Orders;
import com.sporty.repository.OrderItemsRepository;
import com.sporty.repository.OrdersRepository;
import com.sporty.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	OrderItemsRepository orderItemRepository;

	@Override
	public String saveOrder(Date order_date, boolean paid, List<OrderItems> items) {
		Orders ord = new Orders();

		ord.setItems(items);
		ord.setOrder_date(order_date);
		ord.setOrder_complete(paid);
		ordersRepository.save(ord);
		return "Order details are upto date";
	}

	@Override
	public List<OrderDTO> sortedOrderByDate() {
		return ordersRepository.sortByDate();

		// sortByDate();
	}

	@Override
	public List<Orders> sortedOrderByDateAndCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders saveOrder(Date order_date, boolean paid, AppUsers users) {
		if (paid) {
			Orders order = new Orders(order_date, 'Y', users);
			ordersRepository.save(order);
			return order;
		} else {
			Orders order = new Orders(order_date, 'N', users);
			ordersRepository.save(order);
			return order;
		}

	}

	@Override
	public List<OrderDTO> filterByDateAndCategory(long cat_id, Date orderDate) {
		return ordersRepository.filterByDateAndCategory(cat_id, orderDate);
	}

}
