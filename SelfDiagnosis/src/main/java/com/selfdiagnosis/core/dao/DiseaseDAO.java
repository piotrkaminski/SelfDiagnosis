package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.DiseaseEntity;

/**
 * Interface for Disease DAO.
 * 
 * @author mmieszkowski
 * 
 */
public interface DiseaseDAO {

    /**
     * 
     * @return all diseases in the system
     */
    List<DiseaseEntity> findAll();

}