package com.camilolopes.readerweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.camilolopes.readerweb.dao.ContentDAO;
import com.camilolopes.readerweb.model.bean.Content;
import com.camilolopes.readerweb.services.ContentService;

@org.springframework.stereotype.Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentDAO contentDAOImpl;

	@Override
	public List<Content> search(String value){
		
		return contentDAOImpl.search(value);
	}

	@Override
	public void saveOrUpdate(Content object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Content object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Content searchById(Long id) {
		
		return contentDAOImpl.serachById(id);
	}

}
