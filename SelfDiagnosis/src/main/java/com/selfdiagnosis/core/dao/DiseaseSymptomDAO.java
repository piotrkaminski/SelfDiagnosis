package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;

/**
 * DAO for {@link DiseaseSymptomEntity}.
 * 
 * @author mmieszkowskis
 * 
 */
public interface DiseaseSymptomDAO {

    /**
     * 
     * @return all disease symptoms
     */
    List<DiseaseSymptomEntity> findAll();

    /**
     * 
     * @param id disease id
     * @return all symptoms for given disease
     */
    List<DiseaseSymptomEntity> findAllByDiseaseId(Long id);

}