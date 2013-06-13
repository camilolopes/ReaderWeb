package com.camilolopes.readerweb.dao.impl;

import org.springframework.stereotype.Repository;

import com.camilolopes.readerweb.dao.interfaces.TypeDAO;
import com.camilolopes.readerweb.model.bean.Type;
@Repository
public class TypeDAOImpl extends HibernateDAO<Type, Long> implements TypeDAO{

	public TypeDAOImpl() {
		super(Type.class);
		
	}

	@Override
	public Type findById(Long id) {
		
		return (Type) getCurrentSession().get(Type.class, id);
	}
}
