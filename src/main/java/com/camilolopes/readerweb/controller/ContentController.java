package com.camilolopes.readerweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.camilolopes.readerweb.model.bean.Content;
import com.camilolopes.readerweb.services.impl.ContentServiceImpl;
@Controller
public class ContentController {
	private String description;
	private List<Content> listContent;
	
	@Autowired
	private ContentServiceImpl contentService;
	
	public void search(){
		listContent = contentService.search(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Content> getListContent() {
		return listContent;
	}

	public void setListContent(List<Content> listContent) {
		this.listContent = listContent;
	}

	public ContentServiceImpl getContentService() {
		return contentService;
	}

	public void setContentService(ContentServiceImpl contentService) {
		this.contentService = contentService;
	}
	
}
