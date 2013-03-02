package com.selfdiagnosis.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Base DAO. All other data access objects should extend BaseDAO.
 * 
 * @author pkaminski
 * 
 */
public interface BaseDAO {

    /**
     * Return current database session.
     * 
     * @return Database session
     */
    Session getCurrentSession();

    /**
     * Return object using primary key.
     * 
     * @param clazz
     *            Object's class
     * @param id
     *            Primary key
     * @return object
     */
    Object getObject(Class<?> clazz, Serializable id);

    /**
     * Returns all objects given class.
     * 
     * @param clazz
     *            Objects'class
     * @return List of objects
     */
    List<?> getObjectList(Class<?> clazz);

    /**
     * @param obj
     *            object
     */
    void saveOrUpdate(Object obj);

    /**
     * @param obj
     *            object
     */
    void delete(Object obj);

    /**
     * Evicts object from session cache.
     * 
     * @param obj
     *            Object to evict
     */
    void evictSession(Object obj);

    /**
     * Executes store procedure.
     * 
     * @param procedure
     *            procedure name
     */
    void executeStoredProcedure(String procedure);

    /**
     * @return session factory
     */
    SessionFactory getSessionFactory();

//    /**
//     * 
//     * @param sessionFactory {@link SessionFactory}
//     */
//    void setSessionFactory(SessionFactory sessionFactory);

    /**
     * Merges object with database and returns processed object.
     * 
     * @param obj
     *            to merge
     * @return merged object
     */
    Object merge(Object obj);

}