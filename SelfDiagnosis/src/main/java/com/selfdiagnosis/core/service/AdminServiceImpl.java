package com.selfdiagnosis.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.dao.BodyPartDAO;
import com.selfdiagnosis.core.dao.DiseaseSymptomDAO;
import com.selfdiagnosis.core.dao.SymptomDAO;
import com.selfdiagnosis.core.dao.SymptomTypeDAO;
import com.selfdiagnosis.core.dao.TestDAO;
import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.TestEntity;

/**
 * Implementation for {@link AdminService}.
 * 
 * @author mmieszkowski
 * 
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    /** DAO injected by Spring. */
    @Autowired
    private BodyPartDAO bodyPartDAO;

    /** DAO injected by Spring. */
    @Autowired
    private DiseaseSymptomDAO diseaseSymptomDAO;

    /** DAO injected by Spring. */
    @Autowired
    private SymptomDAO baseDAO;

    /** DAO injected by Spring. */
    @Autowired
    private SymptomTypeDAO symptomTypeDAO;
    
    /** DAO injected by Spring. */
    @Autowired
    private SymptomDAO symptomDAO;

    /** DAO injected by Spring. */
    @Autowired
    private TestDAO testDAO;

    @Override
    @Transactional
    public List<BodyPartEntity> getBodyPartList() {
        return bodyPartDAO.findAll();
    }

    @Override
    @Transactional
    public List<SymptomTypeEntity> getSymptomTypeList() {
        return symptomTypeDAO.findAll();
    }
    
    @Override
    @Transactional
    public List<DiseaseSymptomEntity> getDiseaseSymptomList() {
        return diseaseSymptomDAO.findAll();
    }

    @Override
    @Transactional
    public List<DiseaseSymptomEntity> getDiseaseSymptomListForDisease(final Long id) {
        return diseaseSymptomDAO.findAllByDiseaseId(id);
    }

    @Override
    @Transactional
    public List<SymptomEntity> getSymptomList() {
        return symptomDAO.findAll();
    }

    @Override
    @Transactional
    public List<TestEntity> getTestList() {
        return testDAO.findAll();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public final <T extends SelfDiagnosisEntity> T getEntityByTypeAndId(final Class<T> clazz, final Long id) {
        return (T) baseDAO.getObject(clazz, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public final <T extends SelfDiagnosisEntity> T saveEntity(final T selfDiagnosisEntity) {
        return (T) baseDAO.merge(selfDiagnosisEntity);
    }

    @Override
    @Transactional
    public void addNewDiseaseSymptom(final DiseaseEntity disease) {
        DiseaseSymptomEntity diseaseSymptom = new DiseaseSymptomEntity();
        diseaseSymptom.setDisease(disease);
        diseaseSymptom.setSymptom(disease.getSymptom());
        diseaseSymptom.setFrequency(new Short("50"));
        diseaseSymptom.setRank(new Short("50"));
        saveEntity(diseaseSymptom);
    }
    
    @Override
    @Transactional
    public void deleteDiseaseSymptom(final DiseaseSymptomEntity diseaseSymptomEntity) {
        baseDAO.delete(diseaseSymptomEntity);
    }

}
