package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;

public interface DiseaseSymptomDAO {

    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.SymptomDAO#findAll()
     */
    List<DiseaseSymptomEntity> findAll();

    List<DiseaseSymptomEntity> findAllByDiseaseId(Long id);

}