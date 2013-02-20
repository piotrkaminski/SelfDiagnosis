package com.selfdiagnosis.core.service;

import java.util.List;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.TestEntity;

/**
 * Service that stores methods used in system administration module.
 * 
 * @author mmieszkowski
 * 
 */
public interface AdminService {

    /**
     * 
     * @return list of all body parts
     */
    List<BodyPartEntity> getBodyPartList();

    /**
     * Saves any hibernate entity.
     * 
     * @param selfDiagnosisEntity
     *            entity to save
     * @param <T>
     *            any hibernate entity
     * @return merged entity
     */
    <T extends SelfDiagnosisEntity> T saveEntity(T selfDiagnosisEntity);

    /**
     * 
     * @return list of all symptom types
     */
    List<SymptomTypeEntity> getSymptomTypeList();

    /**
     * 
     * @param clazz
     *            class of entity to get
     * @param id
     *            of entity to get
     * @param <T>
     *            any hibernate entity
     * @return entity
     */
    <T extends SelfDiagnosisEntity> T getEntityByTypeAndId(Class<T> clazz, Long id);

    /**
     * Adds new disease symptom relation. Based on transient symptom stored in
     * disease entity
     * 
     * @param disease
     *            related disease
     */
    void addNewDiseaseSymptom(DiseaseEntity disease);

    /**
     * Deletes given {@link DiseaseSymptomEntity}.
     * 
     * @param diseaseSymptomEntity
     *            entity to be deleted.
     */
    void deleteDiseaseSymptom(DiseaseSymptomEntity diseaseSymptomEntity);

    /**
     * 
     * @return List of all disease symptoms.
     */
    List<DiseaseSymptomEntity> getDiseaseSymptomList();

    /**
     * 
     * @return List of all symptoms.
     */
    List<SymptomEntity> getSymptomList();

    /**
     * 
     * @return List of all tests.
     */
    List<TestEntity> getTestList();

    /**
     * 
     * @param id disease id
     * @return List of all symptoms related with given disease
     */
    List<DiseaseSymptomEntity> getDiseaseSymptomListForDisease(Long id);
}