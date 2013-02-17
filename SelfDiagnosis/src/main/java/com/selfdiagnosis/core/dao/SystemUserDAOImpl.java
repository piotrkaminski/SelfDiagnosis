package com.selfdiagnosis.core.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.entity.SystemUserEntity;

/**
 * Implementation of {@link SystemUserDAO} which provides data from database.
 *  
 * @author pkaminski
 *
 */
@Repository
public class SystemUserDAOImpl extends BaseDAOImpl implements SystemUserDAO {
    
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public SystemUserEntity findByEmail(String email) {
        Query query = getCurrentSession().createQuery("from SystemUserEntity where email = :emailParam");
        query.setString("emailParam", email);
        return (SystemUserEntity)query.uniqueResult();
    }
}
