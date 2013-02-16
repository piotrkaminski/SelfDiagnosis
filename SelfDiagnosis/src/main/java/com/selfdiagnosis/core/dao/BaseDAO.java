package com.selfdiagnosis.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface BaseDAO {

	/**
	 * Return current database session
	 * @return Database session
	 */
	Session getCurrentSession();

	/**
	 * Return object using primary key
	 * @param clazz Object's class
	 * @param id Primary key
	 * @return object
	 */
	Object getObject(Class clazz, Serializable id);

	/**
	 * Returns all objects given class
	 * @param clazz Objects'class
	 * @return List of objects
	 */
	List getObjectList(Class clazz);

	/**
	 * @param obj object
	 */
	void saveOrUpdate(Object obj);

	@Transactional(propagation = Propagation.REQUIRED)
	Integer save(Object obj);

	/**
	 * @param obj object
	 */
	void delete(Object obj);

	/**
	 * Evicts object from session cache 
	 * 
	 * @param obj Object to evict
	 */
	void evictSession(Object obj);

	/**
	 * Executes store procedure.
	 * 
	 * @param procedure procedure name
	 */
	void executeStoredProcedure(String procedure);

	SessionFactory getSessionFactory();

	void setSessionFactory(SessionFactory sessionFactory);

	Object merge(Object obj);

}