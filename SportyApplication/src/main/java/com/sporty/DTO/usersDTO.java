package com.sporty.DTO;

public class usersDTO {
	
	private long user_id;
	private String firstName;
	private String LastName;
	public usersDTO(long user_id, String firstName, String lastName) {
		super();
		this.user_id = user_id;
		this.firstName = firstName;
		LastName = lastName;
	}
	public usersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
	

}
