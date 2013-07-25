package com.camilolopes.readerweb.services;

import java.util.List;

import com.camilolopes.readerweb.services.interfaces.Service;

public interface ContentService<T> extends Service<T>{

	List<T> search(String value);

}
