package com.selfdiagnosis.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Abstract class for DAO classes.
 * 
 * @author pkaminski
 */
public abstract class BaseDAO {

    /**
     *  SessionFactory
     */
	@Autowired
    private SessionFactory sessionFactory;
    
    /**
     * Return current database session
     * @return Database session
     */
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /**
     * Return object using primary key
     * @param clazz Object's class
     * @param id Primary key
     * @return object
     */
    @SuppressWarnings("rawtypes")
    public Object getObject(Class clazz, Serializable id) {
        return getCurrentSession().get(clazz, id);
    }
    
    /**
     * Returns all objects given class
     * @param clazz Objects'class
     * @return List of objects
     */
    @SuppressWarnings("rawtypes")
    public List getObjectList(Class clazz) {
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        return criteria.list();
    }
    
    
    /**
     * @param obj object
     */
    public void saveOrUpdate(Object obj) {
        getCurrentSession().saveOrUpdate(obj);
    }
    
    @Transactional(propagation=Propagation.REQUIRED)
    public Integer save(Object obj) {
        return (Integer) getCurrentSession().save(obj);
    }    
    
    /**
     * @param obj object
     */
    public void delete(Object obj) {
        getCurrentSession().delete(obj);
    }
    

    /**
     * Evicts object from session cache 
     * 
     * @param obj Object to evict
     */
    public void evictSession(Object obj) {
        getCurrentSession().evict(obj);
    }
   
    
    /**
     * Executes store procedure.
     * 
     * @param procedure procedure name
     */
    public void executeStoredProcedure(String procedure) {
        getCurrentSession().createSQLQuery(procedure).executeUpdate();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
}
