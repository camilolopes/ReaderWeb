package com.camilolopes.readerweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.UserService;

@Component
public class UserController {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
	private User user;
	
	public UserController() {
		user = new User();
	}
	
	public void addEditUser(User user){
		userServiceImpl.saveOrUpdate(user);
	}
	
	public List<User> listAllUsers(){
		
		return userServiceImpl.readAll();
	}
	
	public List<User> searchUser(String description){
		
		return userServiceImpl.searchUser(description);
	}
	
	public void deleteUser(User user){
		userServiceImpl.delete(user);
	}
	
	public User searchUserById(long id){
		
		return userServiceImpl.searchById(id);
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
