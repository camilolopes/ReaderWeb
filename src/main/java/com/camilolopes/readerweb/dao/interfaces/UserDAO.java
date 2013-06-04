package com.camilolopes.readerweb.dao.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.model.bean.User;

public interface UserDAO extends GenericDAO<User, Long> {
	@Transactional
	public User findUserByEmail(String email);
	@Transactional
	public User findUserById(Long id);
	@Transactional
	public List<User> searchUser(String description);
}
