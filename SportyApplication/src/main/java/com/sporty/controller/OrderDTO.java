package com.sporty.controller;

import java.math.BigDecimal;
import java.util.Date;



public class OrderDTO {

	private long order_id;
	private Date orderDate;
	private char order_complete;
	private long line_id;
	private long quantity;
	private BigDecimal total_item_cost;
	
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public OrderDTO(long order_id, Date orderDate, char order_complete, long line_id, long quantity,
			BigDecimal total_item_cost) {
		super();
		this.order_id = order_id;
		this.orderDate = orderDate;
		this.order_complete = order_complete;
		this.line_id = line_id;
		this.quantity = quantity;
		this.total_item_cost = total_item_cost;
	}



	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public char getOrder_complete() {
		return order_complete;
	}
	public void setOrder_complete(char order_complete) {
		this.order_complete = order_complete;
	}
	public long getLine_id() {
		return line_id;
	}
	public void setLine_id(long line_id) {
		this.line_id = line_id;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal_item_cost() {
		return total_item_cost;
	}
	public void setTotal_item_cost(BigDecimal total_item_cost) {
		this.total_item_cost = total_item_cost;
	}
	
	
	


}
