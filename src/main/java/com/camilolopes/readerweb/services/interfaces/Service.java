package com.camilolopes.readerweb.services.interfaces;

import com.camilolopes.readerweb.exception.EmailException;

public interface Service<T extends Object> {
	void saveOrUpdate(T object) throws EmailException;
	void delete(T object);
	T searchById(Long id);
}
