package com.camilolopes.readerweb.dao.interfaces;

import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.model.bean.Type;

public interface TypeDAO extends GenericDAO<Type, Long>{
	@Transactional
	Type findById(Long id);
	
}
