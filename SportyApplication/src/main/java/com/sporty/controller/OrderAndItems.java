package com.sporty.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.sporty.entity.OrderItems;
import com.sporty.entity.Orders;

public class OrderAndItems {
	
	private Orders order;
	private List<OrderItems> items_list;
	private Date order_date;
	private boolean paid;
	private long quantity;
	private long user_id;
	private long prod_id;
	private long order_Id;
	
	public OrderAndItems(Orders order, List<OrderItems> items_list) {
		super();
		this.order = order;
		this.items_list = items_list;
	}
	
	//Saving 
	
	public OrderAndItems(List<OrderItems> items_list, Date order_date, boolean paid) {
		super();
		this.items_list = items_list;
		this.order_date = order_date;
		this.paid = paid;
	}
	//

	//Save order
	public OrderAndItems(Date order_date,long user_id,boolean paid,long quantity,long prod_id) {
		super();
		this.order_date = order_date;
		this.user_id=user_id;
		this.paid=paid;
		this.quantity = quantity;
		
		this.prod_id=prod_id;
	}



	public OrderAndItems() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	public List<OrderItems> getItems_list() {
		return items_list;
	}
	public void setItems_list(List<OrderItems> items_list) {
		this.items_list = items_list;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}



	public long getQuantity() {
		return quantity;
	}



	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}




	public long getProd_id() {
		return prod_id;
	}



	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}



	public long getOrder_Id() {
		return order_Id;
	}



	public void setOrder_Id(long order_Id) {
		this.order_Id = order_Id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	

}
