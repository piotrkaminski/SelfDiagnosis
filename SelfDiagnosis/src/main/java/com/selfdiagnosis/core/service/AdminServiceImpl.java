package com.selfdiagnosis.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.dao.BodyPartDAO;
import com.selfdiagnosis.core.dao.SymptomDAO;
import com.selfdiagnosis.core.dao.SymptomTypeDAO;
import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private SymptomDAO baseDAO;

	@Autowired
	private SymptomDAO symptomDAO;
	
	@Autowired
	private BodyPartDAO bodyPartDAO;
	
	@Autowired
	private SymptomTypeDAO symptomTypeDAO;
	
	
	/* (non-Javadoc)
	 * @see com.selfdiagnosis.core.service.AdminService#getBodyPartList()
	 */
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
	public BodyPartEntity getBodyPartById(Integer id) {
		return (BodyPartEntity)bodyPartDAO.getObject(BodyPartEntity.class, id);
	}

	@Override
	@Transactional 
	public SymptomTypeEntity getSymptomTypeById(Integer id) {
		return (SymptomTypeEntity)bodyPartDAO.getObject(SymptomTypeEntity.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public <T extends SelfDiagnosisEntity> T getEntityByTypeAndId(Class<T> clazz, Integer id) {
		return (T)baseDAO.getObject(clazz, id);
	}

	
	/* (non-Javadoc)
	 * @see com.selfdiagnosis.core.service.AdminService#saveBodyPart(com.selfdiagnosis.core.entity.BodyPartEntity)
	 */
	@Override
	@Transactional
	public void saveBodyPart(BodyPartEntity bodyPart) {
		bodyPartDAO.saveOrUpdate(bodyPart);
	}

	/* (non-Javadoc)
	 * @see com.selfdiagnosis.core.service.AdminService#saveSymptom(com.selfdiagnosis.core.entity.SymptomEntity)
	 */
	@Override
	@Transactional
	public SymptomEntity saveSymptom(SymptomEntity symptom) {
		return (SymptomEntity)symptomDAO.merge(symptom);
	}
	
	@Override
	public SymptomEntity setSymptomBodyPart(SymptomEntity symptom, BodyPartEntity bodyPart) {
		symptom.setBodyPart(bodyPart);
		return symptom;
	}

	@Override
	@Transactional
	public SelfDiagnosisEntity saveEntity(SelfDiagnosisEntity selfDiagnosisEntity) {
		if (selfDiagnosisEntity instanceof SymptomEntity) {
			return saveSymptom((SymptomEntity)selfDiagnosisEntity);
		} else if (selfDiagnosisEntity instanceof SymptomTypeEntity) {
			return (SymptomTypeEntity)baseDAO.merge(selfDiagnosisEntity);
		} else if (selfDiagnosisEntity instanceof BodyPartEntity) {
			return (BodyPartEntity)baseDAO.merge(selfDiagnosisEntity);
		}
		
		return selfDiagnosisEntity;
	}

	
	
}
