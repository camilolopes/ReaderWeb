package com.camilolopes.readerweb.services.interfaces;

import java.util.List;

import com.camilolopes.readerweb.model.bean.User;

public interface UserService extends Service<User>{
	List<User>readAll();

	List<User> searchUser(String description);
}