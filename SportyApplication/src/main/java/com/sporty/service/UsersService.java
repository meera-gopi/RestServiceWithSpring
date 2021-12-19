package com.sporty.service;

import java.util.List;

import com.sporty.DTO.usersDTO;
import com.sporty.entity.AppUsers;



public interface UsersService {

	//Get All Users	
	List<usersDTO> getAllUsers();
	
	//Get User by userName and Password	
	AppUsers getUserByUserNameAndPassword(String userName, String password);
	
	
	//Get Users by type
	List<AppUsers> getUsersByType(int usertype);
	
	
	//Save User Information	
	void saveUser(AppUsers user1);
	
	//Delete User
	
	void deleteUser(long userId);
	
	//Update User Info
	//void updateUser(Users user1);
	
	String changePassword(String new_password,long userId);
	
	//find by id
	
	AppUsers getByUserId(long id);
	
	
}
