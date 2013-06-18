package com.camilolopes.readerweb.services.interfaces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.camilolopes.readerweb.dao.interfaces.TypeDAO;
import com.camilolopes.readerweb.model.bean.Type;

@Service("typeServiceImpl")
public class TypeServiceImpl implements TypeService {
	@Autowired
	@Qualifier("typeDAOImpl")
	private TypeDAO typeDAOImpl;

	@Override
	public void saveOrUpdate(Type type) throws Exception {
		validateType(type);
		typeDAOImpl.saveOrUpdate(type);
	}

	private void validateType(Type type) {
		if (type.getDescription() == null || type.getDescription().isEmpty()) {
			throw new IllegalArgumentException("Type cannot null");
		}
	}

	@Override
	public void delete(Type type) {
		typeDAOImpl.delete(type);
	}

	@Override
	public Type searchById(Long id) {
		return typeDAOImpl.findById(id);
	}

	@Override
	public List<Type> readAll() { 

		return typeDAOImpl.readAll();
	}
	
	public TypeDAO getTypeDAOImpl() {
		return typeDAOImpl;
	}

	public void setTypeDAOImpl(TypeDAO typeDAOImpl) {
		this.typeDAOImpl = typeDAOImpl;
	}

}
