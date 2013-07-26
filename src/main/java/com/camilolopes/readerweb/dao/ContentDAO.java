package com.camilolopes.readerweb.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.dao.interfaces.GenericDAO;
import com.camilolopes.readerweb.model.bean.Content;

public interface ContentDAO extends GenericDAO<Content, Long> {
	@Transactional
	public List<Content> search(String value);
	@Transactional
	public Content serachById(Long id);

}
