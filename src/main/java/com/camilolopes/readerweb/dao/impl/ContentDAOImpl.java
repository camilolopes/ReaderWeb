package com.camilolopes.readerweb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.dao.ContentDAO;
import com.camilolopes.readerweb.model.bean.Content;
@Repository
public class ContentDAOImpl extends HibernateDAO<Content, Long> implements ContentDAO {

	public ContentDAOImpl() {
		super(Content.class);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void saveOrUpdate(Content entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void delete(Content entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<Content> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Content> search(String value) {
		Criteria criteria = getCurrentSession().createCriteria(Content.class);
		Criterion description = Restrictions.ilike("description", value,MatchMode.ANYWHERE);
		Criterion type = Restrictions.ilike("type", value,MatchMode.ANYWHERE);
		Criterion tag = Restrictions.ilike("tag", value,MatchMode.ANYWHERE);
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(description);
		disjunction.add(type);
		disjunction.add(tag);
		criteria.add(disjunction);	
		List<Content> listContent = criteria.list();
		return listContent;
	}

	

}
