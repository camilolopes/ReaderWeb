package com.camilolopes.readerweb.services.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.dbunit.config.DBUnitConfiguration;
import com.camilolopes.readerweb.model.bean.Type;
import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.TypeServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:**/OrderPersistenceTests-context.xml" })
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public class TypeServiceImplATest extends DBUnitConfiguration {
	@Autowired
	@Qualifier("typeServiceImpl")
	private TypeServiceImpl typeServiceImpl;
	private Type type;
	private long typeId;
	@Autowired
	private UserServiceImpl userServiceImpl;

	@Before
	public void setUp() throws Exception {
		type = new Type();
		getSetUpOperation().execute(getConnection(), getDataSet());
	}

	@Test
	public void testAddTypeWithSucess() {
		type.setDescription("Admin");
		try {
			typeServiceImpl.saveOrUpdate(type);
		} catch (Exception e) {
			fail("Not expected result");
		}
	}

	@Test
	public void testGetTypeBydId() {
		typeId = 1;
		assertNotNull(typeServiceImpl.searchById(typeId));
	}

	@Test
	public void testGetTypeNotExist() {
		typeId = 0L;
		assertNull(typeServiceImpl.searchById(typeId));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testTypeDescriptionCannotBeNull() throws Exception {
		type.setDescription(null);
		typeServiceImpl.saveOrUpdate(type);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testTypeDescriptionCannotEmpty() throws Exception {
		type.setDescription("");
		typeServiceImpl.saveOrUpdate(type);
	}

	@Test
	public void testTypeDeletedWithSucess() {
		type.setId(1L);
		typeServiceImpl.delete(type);
		typeId = 1;
		assertNull(typeServiceImpl.searchById(typeId));
	}

	@Test
	public void testUserCannotBeDeletedWhenTypeIsDeleted() {
		typeId = 1L;
		Type type = typeServiceImpl.searchById(typeId);
		typeServiceImpl.delete(type);
		Type typeNotFound = typeServiceImpl.searchById(typeId);
		assertNull(typeNotFound);
		long userId = 3L;
		User user = userServiceImpl.searchById(userId);
		assertNotNull(user);
	}
	@Test
	public void testReturnAllTypeRecorded(){
		List<Type> listTypes = typeServiceImpl.readAll();
		assertNotNull(listTypes);
		assertFalse(listTypes.isEmpty());
	}

}
