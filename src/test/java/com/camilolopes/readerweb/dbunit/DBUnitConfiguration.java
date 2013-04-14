package com.camilolopes.readerweb.dbunit;

import java.io.FileInputStream;
import java.sql.Connection;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
@ContextConfiguration(locations={"classpath:**/OrderPersistenceTests-context.xml"})
@TransactionConfiguration(defaultRollback=true,transactionManager="transactionManager")
@Transactional
public abstract class DBUnitConfiguration extends DatabaseTestCase {
	private FileInputStream loadFile;	
	private Connection connection;
	@Autowired
	private SessionFactory sessionFactory;

	public DBUnitConfiguration() {
		super();
	}

	public DBUnitConfiguration(String name) {
		super(name);
	}
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connection = SessionFactoryUtils.getDataSource(sessionFactory).getConnection();
		IDatabaseConnection iDataBaseConnection = new DatabaseConnection(connection);
		return iDataBaseConnection ;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		loadFile = new FileInputStream("src/main/resources/readerweb-dataset.xml");
//		IDataSet dataSet = new FlatXmlDataSet(loadFile); 
		IDataSet dataSet2 = new FlatXmlDataSetBuilder().build(loadFile);
		return dataSet2;
	}
	@Override
	protected DatabaseOperation getSetUpOperation() throws Exception {
		return DatabaseOperation.CLEAN_INSERT;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}