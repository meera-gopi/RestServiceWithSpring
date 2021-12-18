package com.sporty.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long order_id;
	
	@Column(name="order_date")
	@Temporal(TemporalType.DATE)
	Date orderDate;
	char order_complete;
	
	@OneToMany(mappedBy="orders",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	List<OrderItems> items;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="id")
	
	private AppUsers users;
	
	public Orders() {
		
	}
	
	public Orders(Date order_date, char order_complete,AppUsers users) {
		super();
		this.orderDate = order_date;
		this.order_complete = order_complete;
		this.users = users;
	}
	public Orders(Date order_date, char order_complete, List<OrderItems> items) {
		super();
		this.orderDate = order_date;
		this.order_complete = order_complete;
		this.items = items;
	}

	public Date getOrder_date() {
		return orderDate;
	}

	public void setOrder_date(Date order_date) {
		this.orderDate = order_date;
	}

	public char isOrder_complete() {
		return order_complete;
	}

	public void setOrder_complete(boolean order_complete) {
		if(order_complete) {
		this.order_complete = 'Y';}
		else {
			this.order_complete = 'N';
		}
	}

	public List<OrderItems> getItems() {
		return items;
	}

	public void setItems(List<OrderItems> items) {
		this.items = items;
	}

	public long getOrder_id() {
		return order_id;
	}



	public AppUsers getUsers() {
		return users;
	}

	public void setUsers(AppUsers users) {
		this.users = users;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	
	

}
