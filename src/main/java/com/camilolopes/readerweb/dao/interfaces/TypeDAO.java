package com.camilolopes.readerweb.dao.interfaces;

import com.camilolopes.readerweb.model.bean.Type;

public interface TypeDAO extends GenericDAO<Type, Long>{

	Type findById(Long id);

}
