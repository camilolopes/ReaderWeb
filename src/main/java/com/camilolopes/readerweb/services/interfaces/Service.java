package com.camilolopes.readerweb.services.interfaces;

import java.util.List;



public interface Service<T extends Object> {
	void saveOrUpdate(T object) throws Exception;
	void delete(T object);
	T searchById(Long id);
	List<T>readAll();
}
