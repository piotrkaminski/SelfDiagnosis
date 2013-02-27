package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.SymptomEntity;

/**
 * DAO for {@link SymptomEntity}.
 * @author mmieszkowski
 *
 */
public interface SymptomDAO extends BaseDAO {

    /**
     * 
     * @return all symptoms
     */
    List<SymptomEntity> findAll();

}