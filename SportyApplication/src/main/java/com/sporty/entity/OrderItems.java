package com.sporty.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_items")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long line_id;
	
	private long quantity;
	private BigDecimal total_item_cost;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="prod_id")
	private Products product;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="order_id")
	private Orders orders;

	

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrderItems(long quantity, BigDecimal total_item_cost, Products product, Orders orders) {
		super();
		this.quantity = quantity;
		this.total_item_cost = total_item_cost;
		this.product = product;
		this.orders = orders;
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



	public Products getProduct() {
		return product;
	}



	public void setProduct(Products product) {
		this.product = product;
	}



	public Orders getOrders() {
		return orders;
	}



	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	

}
