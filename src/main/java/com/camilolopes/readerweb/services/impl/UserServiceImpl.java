package com.camilolopes.readerweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.readerweb.dao.interfaces.UserDAO;
import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	@Qualifier("userDAOImpl")
	private UserDAO userDAO;
	
	@Override
	public void addOrEdit(User user) {
		userDAO.saveOrUpdate(user);
	}
	
	@Override
	public List<User> readAll() {
		return userDAO.readAll();
	}


	@Override
	public void delete(User user) {
		userDAO.delete(user);

	}

	@Override
	public User read(Long id) {
		return userDAO.findUserById(id);
	}

	
}
