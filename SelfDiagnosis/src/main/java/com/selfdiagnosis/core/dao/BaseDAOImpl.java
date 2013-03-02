package com.selfdiagnosis.core.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Abstract class for DAO classes.
 * 
 * @author pkaminski
 */
@Repository
public abstract class BaseDAOImpl implements BaseDAO {

    /**
     *  SessionFactory.
     */
    @Autowired
    private SessionFactory sessionFactory;
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#getCurrentSession()
     */
    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#getObject(java.lang.Class, java.io.Serializable)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public Object getObject(Class clazz, Serializable id) {
        return getCurrentSession().get(clazz, id);
    }
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#getObjectList(java.lang.Class)
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List<?> getObjectList(Class clazz) {
        Criteria criteria = getCurrentSession().createCriteria(clazz);
        return criteria.list();
    }
    
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#saveOrUpdate(java.lang.Object)
     */
    @Override
    public void saveOrUpdate(Object obj) {
        getCurrentSession().saveOrUpdate(obj);
    }
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#delete(java.lang.Object)
     */
    @Override
    public void delete(Object obj) {
        getCurrentSession().delete(obj);
    }
    

    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#evictSession(java.lang.Object)
     */
    @Override
    public void evictSession(Object obj) {
        getCurrentSession().evict(obj);
    }
   
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#executeStoredProcedure(java.lang.String)
     */
    @Override
    public void executeStoredProcedure(String procedure) {
        getCurrentSession().createSQLQuery(procedure).executeUpdate();
    }

    @Override
    public Object merge(Object obj) {
        return getCurrentSession().merge(obj);
    }
    
    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.BaseDAO#getSessionFactory()
     */
    @Override
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
