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
	private List<Content> listContents;
	private Content newContent;
	
	public ContentServiceImplAT() {
		
	}
	
	@Before
	public void setUp() throws Exception {
		setNameDataSetXml("readerweb-content-dataset.xml");
		getSetUpOperation().execute(getConnection(), getDataSet());
		newContent = new Content();
	}

	@Test
	public void testSaveOrUpdate() {
		newContent.setDescription("JEE com frameworks");
		newContent.setTag("jee");
		newContent.setUrl("http://www.camilolopes.com.br");
		try {
			contentServiceImpl.saveOrUpdate(newContent);
		} catch (Exception e) {
			fail("not expected result");
		}
	}

	@Test
	public void testDeleteContentById() {
		newContent = contentServiceImpl.searchById(2L);
		contentServiceImpl.delete(newContent);
		newContent=contentServiceImpl.searchById(2L);
		assertNull(newContent);
	}

	@Test
	public void testSearchById() {
		Content contentFound = contentServiceImpl.searchById(3L);
		assertNotNull(contentFound);
		assertEquals("dbunit", contentFound.getDescription());
	}

	@Test
	public void testSearchByDescriptionValid() {
		listContents = contentServiceImpl.search("TDD");
		assertFalse(listContents.isEmpty());
	}
	@Test
	public void testSearchByTagValid(){
		listContents = contentServiceImpl.search("unit test");
		assertFalse(listContents.isEmpty());
		int expectedTotalTag = 1;
		assertEquals(expectedTotalTag,listContents.size());
	}
	@Test
	public void testSearchByTypeValid(){
			listContents=contentServiceImpl.search("book");
			int expectedTotal = 1;
			assertEquals(expectedTotal,listContents.size());
	}
	@Test
	public void testSearchTypeCaseInsensitive(){
		listContents=contentServiceImpl.search("BoOk");
		int expectedTotal = 1;
		assertEquals(expectedTotal,listContents.size());
	}
	@Test
	public void testSearchByDescriptionNotExist(){
		listContents=contentServiceImpl.search("dbunit");
		int expectedTotal = 1;
		assertEquals(expectedTotal,listContents.size());
	}
	@Test
	public void testSearchByTagNotExist(){
		listContents=contentServiceImpl.search("HTML5");
		assertTrue(listContents.isEmpty());
	}
	@Test
	public void testSearchByTypeNotExist(){
		listContents=contentServiceImpl.search("Maganize");
		assertTrue(listContents.isEmpty());
	}

}
