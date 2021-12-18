package com.sporty.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="app_users")
public class AppUsers{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	private String lastName;
	private int userTypeId;
	private String userName;
	private String password;
	
	@OneToMany(mappedBy="users",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	List<Orders> orders;
	
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public AppUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppUsers( String firstName, String lastName, int userTypeId, String userName, String password) {
		super();
		//this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userTypeId = userTypeId;
		this.userName = userName;
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}