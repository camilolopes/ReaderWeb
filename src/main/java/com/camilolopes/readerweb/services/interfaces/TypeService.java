package com.camilolopes.readerweb.services.interfaces;

import java.util.List;

import com.camilolopes.readerweb.model.bean.Type;

public interface TypeService extends Service<Type> {
	public List<Type> readAll();
}
