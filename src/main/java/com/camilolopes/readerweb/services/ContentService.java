package com.camilolopes.readerweb.services;

import java.util.List;

import com.camilolopes.readerweb.model.bean.Content;
import com.camilolopes.readerweb.services.interfaces.Service;

public interface ContentService extends Service<Content>{

	List<Content> search(String value);

}
