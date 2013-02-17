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

    @Autowired
    private SymptomDAO baseDAO;

    @Autowired
    private BodyPartDAO bodyPartDAO;

    @Autowired
    private SymptomTypeDAO symptomTypeDAO;
    
    @Autowired
    private SymptomDAO symptomDAO;

    @Autowired
    private DiseaseSymptomDAO diseaseSymptomDAO;

    @Autowired
    private TestDAO testDAO;

    /*
     * (non-Javadoc)
     * 
     * @see com.selfdiagnosis.core.service.AdminService#getBodyPartList()
     */
    @Override
    @Transactional
    public List<BodyPartEntity> getBodyPartList() {
        return bodyPartDAO.findAll();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.selfdiagnosis.core.service.AdminService#getSymptomTypeList()
     */
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
    public List<DiseaseSymptomEntity> getDiseaseSymptomListForDisease(Long id) {
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
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * com.selfdiagnosis.core.service.AdminService#getEntityByTypeAndId(Class<T>
     * clazz, Long id)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public final <T extends SelfDiagnosisEntity> T getEntityByTypeAndId(Class<T> clazz, Long id) {
        return (T) baseDAO.getObject(clazz, id);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.selfdiagnosis.core.service.AdminService#saveEntity(SelfDiagnosisEntity
     * selfDiagnosisEntity)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public final <T extends SelfDiagnosisEntity> T saveEntity(T selfDiagnosisEntity) {
        return (T) baseDAO.merge(selfDiagnosisEntity);
    }


    /*
     * (non-Javadoc)
     * 
     * @see
     * com.selfdiagnosis.core.service.AdminService#addNewDiseaseSymptom(DiseaseEntity disease)
     */
    @Override
    @Transactional
    public void addNewDiseaseSymptom(DiseaseEntity disease) {
        DiseaseSymptomEntity diseaseSymptom = new DiseaseSymptomEntity();
        diseaseSymptom.setDisease(disease);
        diseaseSymptom.setSymptom(disease.getSymptom());
        diseaseSymptom.setFrequncy(new Short("50"));
        diseaseSymptom.setRank(new Short("50"));
        saveEntity(diseaseSymptom);
    }
    
    @Override
    @Transactional
    public void deleteDiseaseSymptom(DiseaseSymptomEntity diseaseSymptomEntity) {
        baseDAO.delete(diseaseSymptomEntity);
    }

}
