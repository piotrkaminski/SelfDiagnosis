package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.TestTypeEntity;

/**
 * DAO for {@link TestTypeEntity}.
 * 
 * @author mmieszkowski
 * 
 */
public interface TestTypeDAO {

    /**
     * 
     * @return list of all tests
     */
    List<TestTypeEntity> findAll();

}