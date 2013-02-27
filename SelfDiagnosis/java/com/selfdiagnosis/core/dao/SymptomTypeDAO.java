package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.SymptomTypeEntity;

/**
 * DAO for {@link SymptomTypeEntity}.
 * 
 * @author mmieszkowski
 * 
 */
public interface SymptomTypeDAO {

    /**
     * 
     * @return all symptom types
     */
    List<SymptomTypeEntity> findAll();

}