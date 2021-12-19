package com.sporty.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.DTO.OrderAndItems;
import com.sporty.DTO.OrderDTO;
import com.sporty.entity.AppUsers;
import com.sporty.entity.Orders;
import com.sporty.entity.Products;
import com.sporty.service.OrderItemsService;
import com.sporty.service.OrdersService;
import com.sporty.service.ProductsService;
import com.sporty.service.UsersService;

@RestController
@RequestMapping(value="/orders",method=RequestMethod.GET)
public class OrdersController {
	
	@Autowired
	OrdersService ordersService;
	@Autowired
	OrderItemsService orderItemsService;
	@Autowired
	ProductsService productsService;
	@Autowired
	UsersService usersService;
	
	@PostMapping(value="/saveOrder")
	public String saveOrder(@RequestBody OrderAndItems order_list) {
		Date order_date = order_list.getOrder_date();
		boolean paid = order_list.isPaid();	
		long user_id=order_list.getUser_id();
		AppUsers users=usersService.getByUserId(user_id);
		Orders order = ordersService.saveOrder(order_date, paid,users);
		long prod_id=order_list.getProd_id();
		long quantity = order_list.getQuantity();
		
		Products prod = productsService.getProduct(prod_id);
		orderItemsService.saveItems(quantity,  prod, order);
		return "Order Saved";
	}
	
	@GetMapping(value="/ordersByDate",produces = {"application/json"})
	public List<OrderDTO> ordersByDate(){
		return ordersService.sortedOrderByDate();
	}
	
	@GetMapping(value="/filter/{cat_id}/{orderDate}",produces = {"application/json"})
	public List<OrderDTO> ordersByDate(@PathVariable("cat_id") long cat_id,@PathVariable("orderDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date orderDate){
		System.out.println(cat_id);
		System.out.println(orderDate);
		return ordersService.filterByDateAndCategory(cat_id, orderDate);
	}

}
