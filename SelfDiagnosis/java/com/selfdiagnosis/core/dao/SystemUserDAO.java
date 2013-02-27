package com.selfdiagnosis.core.dao;

import com.selfdiagnosis.core.entity.SystemUserEntity;

/**
 * Interface for DAO related with SystemUser scope.
 * 
 * @author pkaminski
 *
 */
public interface SystemUserDAO {
    
    /**
     * Find user using his email address.
     * @param email Email address as filter
     * @return SystemUser with given email address
     */
    SystemUserEntity findByEmail(String email);
}