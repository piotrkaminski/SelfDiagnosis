package com.selfdiagnosis.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.dao.BodyPartDAO;
import com.selfdiagnosis.core.dao.DiseaseDAO;
import com.selfdiagnosis.core.dao.DiseaseSymptomDAO;
import com.selfdiagnosis.core.dao.SymptomDAO;
import com.selfdiagnosis.core.dao.SymptomTypeDAO;
import com.selfdiagnosis.core.dao.TestDAO;
import com.selfdiagnosis.core.dao.TestTypeDAO;
import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.DiseaseEntity;
import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;
import com.selfdiagnosis.core.entity.TestEntity;
import com.selfdiagnosis.core.entity.TestTypeEntity;

/**
 * Implementation for {@link AdminService}.
 * 
 * @author mmieszkowski
 * 
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    //TODO check generated queries. Maybe we dont need eager fetching
    /** DAO injected by Spring. */
    @Autowired
    private BodyPartDAO bodyPartDAO;

    /** DAO injected by Spring. */
    @Autowired
    private DiseaseSymptomDAO diseaseSymptomDAO;

    /** DAO injected by Spring. */
    @Autowired
    private DiseaseDAO diseaseDAO;

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

    /** DAO injected by Spring. */
    @Autowired
    private TestTypeDAO testTypeDAO;

    @Override
    @Transactional(readOnly = true)
    public List<BodyPartEntity> getBodyPartList() {
        return bodyPartDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<SymptomTypeEntity> getSymptomTypeList() {
        return symptomTypeDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<DiseaseEntity> getDiseaseList() {
        return diseaseDAO.findAll();
    }

    
    @Override
    @Transactional(readOnly = true)
    public List<DiseaseSymptomEntity> getDiseaseSymptomList() {
        return diseaseSymptomDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiseaseSymptomEntity> getDiseaseSymptomListForDisease(final Long id) {
        if (id == null) {
            return new ArrayList<DiseaseSymptomEntity>();
        }
        return diseaseSymptomDAO.findAllByDiseaseId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SymptomEntity> getSymptomList() {
        return symptomDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestEntity> getTestList() {
        return testDAO.findAll();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<TestTypeEntity> getTestTypeList() {
        return testTypeDAO.findAll();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    public final <T extends SelfDiagnosisEntity> T getEntityByTypeAndId(final Class<T> clazz, final Long id) {
        return (T) baseDAO.getObject(clazz, id);
    }

    @Override
    @Transactional
    public final <T extends SelfDiagnosisEntity> T saveEntity(final T selfDiagnosisEntity) {
        baseDAO.saveOrUpdate(selfDiagnosisEntity);
        return selfDiagnosisEntity;
    }

    @Override
    @Transactional
    public void addNewDiseaseSymptom(final DiseaseEntity disease) {
        DiseaseSymptomEntity diseaseSymptom = disease.getDiseaseSymptom();
        diseaseSymptom.setDisease(disease);
        saveEntity(diseaseSymptom);
        disease.setDiseaseSymptom(new DiseaseSymptomEntity());
    }
    
    @Override
    @Transactional
    public void deleteEntity(final SelfDiagnosisEntity selfDiagnosisEntity) {
        baseDAO.delete(selfDiagnosisEntity);
    }
}
