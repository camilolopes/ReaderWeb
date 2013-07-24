package com.camilolopes.readerweb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.camilolopes.readerweb.dao.interfaces.UserDAO;
import com.camilolopes.readerweb.model.bean.User;
@Repository("userDAOImpl")
public class UserDAOImpl extends HibernateDAO<User, Long> implements UserDAO {
	
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findUserByEmail(String email) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.ilike("email", email,MatchMode.EXACT));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User findUserById(Long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> searchUser(String description) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		Criterion email = Restrictions.ilike("email", description, MatchMode.EXACT);
		Criterion name = Restrictions.ilike("name", description,MatchMode.ANYWHERE);
		Criterion lastName = Restrictions.ilike("lastname", description,MatchMode.ANYWHERE);
		Disjunction dis = Restrictions.disjunction();
		dis.add(email);
		dis.add(name);
		dis.add(lastName);
		criteria.add(dis);
		criteria.setFetchMode("type", FetchMode.JOIN);
		return criteria.list();
	}
	@Override
	public List<User> readAll() {
		//avoiding LazyInitializationException join fetch
		String hql = "select u from User u join fetch u.type";
		Query query = getCurrentSession().createQuery(hql);
		return query.list();
	}

}
