package com.camilolopes.readerweb.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.dao.interfaces.GenericDAO;
@Repository
public abstract class HibernateDAO<T, Type extends Serializable> implements GenericDAO<T, Type> {
	private Class<T> persistenClass;
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public HibernateDAO(Class<T> persistenClass) {
		super();
		this.persistenClass = persistenClass;
	} 
	
	public void saveOrUpdate(T entity) {
		getCurrentSession().saveOrUpdate(entity);
		
	};
	
	@Override
	public List<T> readAll() {
		return getCurrentSession().createCriteria(persistenClass).list();
	}
	@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
	public void delete(T entity) {
		getCurrentSession().delete(entity);
		
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	};

}
