package com.camilolopes.readerweb.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.readerweb.enums.StatusUser;
import com.camilolopes.readerweb.exception.EmailException;
import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.LoginService;
import com.camilolopes.readerweb.services.interfaces.UserService;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userServiceImpl;
	
//	TODO Apply design pattern 
	@Override
	public void authenticate(String email, String password) throws EmailException {
		if(email!=null && password !=null){
			isValidUser(email,password);
		}
		else {
			throw  new IllegalArgumentException();
		}
	}

	private void isValidUser(String emailPassed,String passwordPassed) throws EmailException {
		User user = userServiceImpl.searchUserByEmail(emailPassed);
		if (user!=null) {
			validateUserData(user, emailPassed, passwordPassed);
		}else{
			throw new IllegalArgumentException("User Invalid");
		}
		 		
	}


	private void validateUserData(User user, String email, String password) throws EmailException {
		if (!user.getEmail().equalsIgnoreCase(email) || !user.getPassword().equals(password)) {
			throw new IllegalArgumentException("E-mail or Password are invalid");
		}
		if (user.getStatus().equals(StatusUser.INACTIVE)) {
			throw new IllegalArgumentException("Conta está inativa");
		}
		if(user.getExpirationDate().before(new Date())){
			userServiceImpl.saveOrUpdate(user);
			throw new IllegalArgumentException("Conta expirada");
		}
		
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

}
