package com.camilolopes.readerweb.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.camilolopes.readerweb.dao.interfaces.UserDAO;
import com.camilolopes.readerweb.model.bean.User;
@Repository
public class UserDAOImpl extends HibernateDAO<User, Long> implements UserDAO {
	
	public UserDAOImpl() {
		super(User.class);
	}

	@Override
	public User findUserByEmail(String email) {
	
		return null;
	}

	@Override
	public User findUserById(Long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	@Override
	public List<User> searchUser(String description) {
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.ilike("email", description, MatchMode.EXACT));
		return criteria.list();
	}

}
