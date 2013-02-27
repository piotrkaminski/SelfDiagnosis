package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.TestEntity;

/**
 * DAO for {@link TestEntity}.
 * 
 * @author mmieszkowski
 * 
 */
public interface TestDAO {

    /**
     * 
     * @return list of all tests
     */
    List<TestEntity> findAll();

}