package com.camilolopes.readerweb.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilolopes.readerweb.dao.ContentDAO;
import com.camilolopes.readerweb.model.bean.Content;
import com.camilolopes.readerweb.services.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private ContentDAO contentDAOImpl;

	@Override
	public List<Content> search(String value){
		
		return contentDAOImpl.search(value);
	}

	@Override
	public void saveOrUpdate(Content content) throws Exception {
		contentDAOImpl.saveOrUpdate(content);
		
	}

	@Override
	public void delete(Content content) {
		contentDAOImpl.delete(content);
		
	}

	@Override
	public Content searchById(Long id) {
		
		return contentDAOImpl.serachById(id);
	}

	@Override
	public List<Content> readAll() {
		
		return contentDAOImpl.readAll();
	}

	

}
