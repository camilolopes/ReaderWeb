package com.camilolopes.readerweb.controller;

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
		new User();
	}
	
	public void addUser(User user){
		userServiceImpl.saveOrUpdate(user);
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
