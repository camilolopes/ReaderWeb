package com.camilolopes.readerweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

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
	
	private Content content;
	
	public ContentController() {
	content = new Content();
	listContent = new ArrayList<Content>();
	}
	
	public void save(){
		try {
			contentService.saveOrUpdate(content);
			listContent.add(content);
			newContent();
		} catch (Exception e) {
			addMessageFaceContext(e.getMessage());
		}
	}
	public void newContent(){
		content = new Content();
	}
	
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
	private void addMessageFaceContext(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, msg ,""));
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
}
