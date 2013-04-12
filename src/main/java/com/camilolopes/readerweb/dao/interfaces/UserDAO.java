package com.camilolopes.readerweb.dao.interfaces;

import com.camilolopes.readerweb.model.bean.User;

public interface UserDAO extends GenericDAO<User, Long> {
	public User findUserByEmail(String email);

	public User findUserById(Long id);
}
