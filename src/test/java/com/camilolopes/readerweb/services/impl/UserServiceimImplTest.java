package com.camilolopes.readerweb.services.impl;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.camilolopes.readerweb.enums.StatusUser;
import com.camilolopes.readerweb.model.bean.User;
import com.camilolopes.readerweb.services.interfaces.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:**/OrderPersistenceTests-context.xml"})
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
@Transactional
public class UserServiceimImplTest extends UserServiceImpl {
	@Autowired
	private UserService userServiceImpl;
	private User user;

	
	@Before
	public void setUp() throws Exception {
		user = new User();
	}
	
	private void setupUserData() {
		user.setEmail("use12@user.com");
		user.setLastname("lopes");
		user.setName("camilo");
		user.setPassword("123456");
		user.setRegisterDate(new Date());
		user.setStatus(StatusUser.ATIVE);
	}

	@Test
	public void testAddNewUserWithSucess() {
		setupUserData();
		try{
			userServiceImpl.addOrEdit(user);
			assertNotNull(userServiceImpl.readAll());
			assertEquals(1,userServiceImpl.readAll().size());
		}catch (Exception e) {
			fail("not expected result " + e.fillInStackTrace());
		}
	}


	@Test
	public void testDeletedUserById() {
		setupUserData();
		userServiceImpl.addOrEdit(user);
		assertFalse(userServiceImpl.readAll().isEmpty());
		User userFound = userServiceImpl.readAll().get(0);
		userServiceImpl.delete(user);
		assertNull("user not found",userServiceImpl.read(userFound.getId()));
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

	@Test
	public void testReadAll() {
		fail("Not yet implemented");
	}

}
