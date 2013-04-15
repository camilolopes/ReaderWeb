package com.camilolopes.readerweb.services.interfaces;

public interface Service<T extends Object> {
	void saveOrUpdate(T object);
	void delete(T object);
	T searchById(Long id);
}
