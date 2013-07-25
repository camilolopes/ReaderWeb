package com.camilolopes.readerweb.controller;

import java.util.List;

import com.camilolopes.readerweb.model.bean.Content;

public class ContentController {
	private String description;
	private List<Content> listContent;
	
	public void search(){
//		TODO 
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
	
}
