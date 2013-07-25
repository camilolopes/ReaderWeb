package com.camilolopes.readerweb.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface GenericDAO<T,Type extends Serializable> {
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void saveOrUpdate(T entity);
	@Transactional
	public void delete(T entity);
	@Transactional
	public List<T> readAll();
}
