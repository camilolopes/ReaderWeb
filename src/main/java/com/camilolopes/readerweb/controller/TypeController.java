package com.camilolopes.readerweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.camilolopes.readerweb.model.bean.Type;
import com.camilolopes.readerweb.services.interfaces.TypeService;

@Component
public class TypeController {
	@Autowired
	private TypeService typeServiceImpl;
	private Type type;
	
	public TypeController() {
		type = new Type();
	}
	public void init(){
		
	}

	public void add(){
		try {
			typeServiceImpl.saveOrUpdate(type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(){
		typeServiceImpl.delete(type);
	}
	
	public List<Type> getListTypes(){
		
		return typeServiceImpl.readAll();
	}
	
	public TypeService getTypeServiceImpl() {
		return typeServiceImpl;
	}

	public void setTypeServiceImpl(TypeService typeServiceImpl) {
		this.typeServiceImpl = typeServiceImpl;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
