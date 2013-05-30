package com.camilolopes.readerweb.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericDAO<T,Type extends Serializable> {
	void saveOrUpdate(T entity);
	@Transactional
	void delete(T entity);
	@Transactional
	List<T> readAll();
}
