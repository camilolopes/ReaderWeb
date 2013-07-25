package com.camilolopes.readerweb.services.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.dbunit.config.DBUnitConfiguration;
import com.camilolopes.readerweb.model.bean.Content;
import com.camilolopes.readerweb.services.ContentService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/OrderPersistenceTests-context.xml"})
@TransactionConfiguration
@Transactional
public class ContentServiceImplAT extends DBUnitConfiguration {
	@Autowired
	private ContentService contentServiceImpl;
	
	public ContentServiceImplAT() {
		
	}
	
	@Before
	public void setUp() throws Exception {
		setNameDataSetXml("readerweb-content-dataset.xml");
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchById() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchByDescriptionValid() {
		List<Content> listContents = contentServiceImpl.search("TDD");
		assertFalse(listContents.isEmpty());
	}
	@Test
	public void testSearchByTagValid(){
		fail("Not yet implemented");
	}
	@Test
	public void testSearchByTypeValid(){
		
	}
	@Test
	public void testSearchByDescriptionNotExist(){
		fail("Not yet implemented");
	}
	@Test
	public void testSearchByTagNotExist(){
		
	}
	@Test
	public void testSearchByTypeNotExist(){
		fail("Not yet implemented");
	}

}
