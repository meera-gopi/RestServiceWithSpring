package com.sporty.service.impl;

import java.util.List;
import java.util.Objects;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sporty.entity.AppUsers;
//import com.sporty.entity.Users;
import com.sporty.repository.UsersRepository;
import com.sporty.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	
	@Autowired
	 UsersRepository usersRepository;

	@Override
	public List<AppUsers> getAllUsers() {
		List<AppUsers> userList = usersRepository.findAll();
		return userList;
	}

	@Override
	public AppUsers getUserByUserNameAndPassword(String userName,String password) {
		AppUsers userLoggedIn = usersRepository.findByUserNameAndPassword(userName, password);
		if(Objects.nonNull(userLoggedIn)) {
			return userLoggedIn;
			
		}
		
		else {
		return null;}
	}

	@Override
	public List<AppUsers> getUsersByType(int usertype) {
		List<AppUsers> userList1=usersRepository.findByUserType(usertype);
		return userList1;
	}

	@Override
	public void saveUser(AppUsers user1) {
		usersRepository.save(user1);
		
	}

	@Override
	public void deleteUser(long id) {
		AppUsers user1 = usersRepository.findById(id);
		
		if(Objects.nonNull(user1)) {
			usersRepository.delete(user1);
		}
		
	}

	@Override
	public String changePassword(String password,long id) {
		AppUsers user1 = usersRepository.findById(id);
		
		if(Objects.nonNull(user1)) {
			usersRepository.changePassword(password, id);
			return "Password Changed";
		}
		else {
			return "Password not Changed";
		}
		
	}

	@Override
	public AppUsers getByUserId(long id) {
		
		return usersRepository.findById(id);
	}

//	@Override
//	public void updateUser(Users user1) {
//		// TODO Auto-generated method stub
//		
//	}

}
