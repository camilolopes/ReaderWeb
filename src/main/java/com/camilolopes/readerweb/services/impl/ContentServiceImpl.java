package com.camilolopes.readerweb.services.impl;

import java.util.List;

import com.camilolopes.readerweb.model.bean.Content;
import com.camilolopes.readerweb.services.ContentService;

@org.springframework.stereotype.Service
public class ContentServiceImpl implements ContentService<Content> {

	@Override
	public List<Content> search(String value){
		
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
