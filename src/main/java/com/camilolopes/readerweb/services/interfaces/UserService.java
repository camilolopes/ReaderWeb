package com.camilolopes.readerweb.services.interfaces;

import java.util.List;

import com.camilolopes.readerweb.exception.EmailException;
import com.camilolopes.readerweb.exception.UserException;
import com.camilolopes.readerweb.model.bean.User;

public interface UserService extends Service<User>{
	
	public void saveOrUpdate(User object)  throws EmailException, UserException;
	
	List<User>readAll();

	List<User> searchUser(String description);
	
	User searchUserByEmail(String email);
}