package com.camilolopes.readerweb.services.interfaces;

public interface Service<T extends Object> {
	void addOrEdit(T object);
	void delete(T object);
	T read(Long id);
}
