package com.camilolopes.readerweb.services.impl;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.readerweb.dao.interfaces.UserDAO;
import com.camilolopes.readerweb.enums.StatusUser;
import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.UserService;
@Service
public class UserServiceImpl implements UserService {
	private static final int NUMBER_DAYS_EXPIRATION = 90;
	@Autowired
	@Qualifier("userDAOImpl")
	private UserDAO userDAO;
	
	@Override
	public void saveOrUpdate(User user) {
		validateExpirationDate(user);
		userDAO.saveOrUpdate(user);
		
	}
	
	public void validateExpirationDate(User user) {
		DateTime dt = new DateTime(user.getExpirationDate());
		if (user.getExpirationDate()==null) {
			DateTime dateTime= dt.plusDays(NUMBER_DAYS_EXPIRATION);
			user.setExpirationDate(dateTime.toDate());
		} else {
			long currentDate = new Date().getTime();
			if(dt.isBefore(currentDate) && user.getStatus().equals(StatusUser.ATIVE)){
				user.setStatus(StatusUser.INACTIVE);
			}
		}
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

	
}
