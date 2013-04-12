package com.camilolopes.readerweb.dao.interfaces;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,Type extends Serializable> {
	void saveOrUpdate(T entity);
	void delete(T entity);
	List<T> readAll();
}
