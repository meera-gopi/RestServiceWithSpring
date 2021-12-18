package com.sporty.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sporty.entity.AppUsers;
//import com.sporty.entity.Users;
import com.sporty.service.UsersService;

@RestController
@RequestMapping(value="/UsersResouces",method=RequestMethod.GET)
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	
	@GetMapping("/users")
	public List<AppUsers> getUsers()
	{		
		return usersService.getAllUsers();		
	}
	
	
	@GetMapping("/login/{userName}/{password}")
	public AppUsers login(@PathVariable("userName") String userName,@PathVariable("password") String password) {
		
		return usersService.getUserByUserNameAndPassword(userName, password);
		
	}
	
	@GetMapping("/userTypeList/{typeId}")
	public List<AppUsers> listUsersOfSpecificType(@PathVariable("typeId") int id){
		return usersService.getUsersByType(id);
	}
	
	@PostMapping("/saveUsers")
	public void saveUser(@RequestBody AppUsers newUser) {
		usersService.saveUser(newUser);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUserById(@PathVariable("userId") long id) {
		usersService.deleteUser(id);
	}
	
	@PostMapping("/changePassword/{newPassword}/{userId}")
	public String changePassword(@PathVariable("newPassword") String new_password, @PathVariable("userId") long id) {
		String changed = usersService.changePassword(new_password, id);
		return changed;
	}

}
