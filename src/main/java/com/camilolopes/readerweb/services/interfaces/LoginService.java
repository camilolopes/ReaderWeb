package com.camilolopes.readerweb.services.interfaces;

import com.camilolopes.readerweb.exception.EmailException;
import com.camilolopes.readerweb.exception.UserException;


public interface LoginService {
	public void authenticate(String email, String password) throws EmailException, UserException;
}
