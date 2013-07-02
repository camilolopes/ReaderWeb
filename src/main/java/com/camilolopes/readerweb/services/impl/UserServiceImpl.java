package com.camilolopes.readerweb.services.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.readerweb.dao.interfaces.UserDAO;
import com.camilolopes.readerweb.enums.StatusUser;
import com.camilolopes.readerweb.exception.EmailException;
import com.camilolopes.readerweb.exception.UserException;
import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	private static final int NUMBER_DAYS_EXPIRATION = 90;
	@Autowired
	@Qualifier("userDAOImpl")
	private UserDAO userDAO;
	
	@Override
	public void saveOrUpdate(User user) throws EmailException, UserException {
		validateUser(user);
		userDAO.saveOrUpdate(user);
		
	}
	
	private void validateUser(User user) throws EmailException, UserException {
		validateRegisterDate(user);
		validateExpirationDate(user);
		validateExistUser(user);
		
	}

	private void validateExistUser(User user) throws EmailException {
		User userFound = userDAO.findUserByEmail(user.getEmail());
		if (userFound!=null && user.getId()==null) {
			throw new EmailException("E-mail already exist");
		}
		
	}

	private void validateRegisterDate(User user) {
		if (user!=null && user.getRegisterDate()==null) {
			throw new IllegalArgumentException("Register Date cannot be null");
		}
		
	}

	public void validateExpirationDate(User user) throws UserException {
		DateTime dt = new DateTime(user.getExpirationDate());
		if (user.getExpirationDate()==null) {
			DateTime dateTime= dt.plusDays(NUMBER_DAYS_EXPIRATION);
			user.setExpirationDate(dateTime.toDate());
		} else {
			long currentDate = new Date().getTime();
			if(dt.isBefore(currentDate)){
				throw new UserException("Expiration Date cannot be less than current date");
			}
		}
	}

	@Override
	public List<User> readAll() {
		List<User> listUsers = userDAO.readAll();
//		descending order 
		Collections.sort(listUsers);
		return listUsers;
	}


	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public User searchById(Long id) {
		return userDAO.findUserById(id);
	}

	@Override
	public List<User> searchUser(String description) {
		if (description==null ||description.isEmpty()) {
			throw new IllegalArgumentException("Invalid Description");
		}
		return userDAO.searchUser(description);
	}

	@Override
	public User searchUserByEmail(String email) {
		User user = userDAO.findUserByEmail(email);
		return user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
