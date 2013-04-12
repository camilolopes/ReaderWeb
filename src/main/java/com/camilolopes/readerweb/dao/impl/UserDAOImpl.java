package com.camilolopes.readerweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.camilolopes.readerweb.dao.interfaces.UserDAO;
import com.camilolopes.readerweb.model.bean.User;
@Repository
public class UserDAOImpl extends HibernateDAO<User, Long> implements UserDAO {
	
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(Long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

}
