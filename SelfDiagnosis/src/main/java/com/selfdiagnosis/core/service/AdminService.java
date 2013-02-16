package com.selfdiagnosis.core.service;

import java.util.List;

import com.selfdiagnosis.core.entity.BodyPartEntity;
import com.selfdiagnosis.core.entity.SelfDiagnosisEntity;
import com.selfdiagnosis.core.entity.SymptomEntity;
import com.selfdiagnosis.core.entity.SymptomTypeEntity;

public interface AdminService {

	List<BodyPartEntity> getBodyPartList();

	SymptomEntity saveSymptom(SymptomEntity symptom);

	void saveBodyPart(BodyPartEntity bodyPart);

	BodyPartEntity getBodyPartById(Integer id);

	SymptomEntity setSymptomBodyPart(SymptomEntity symptom, BodyPartEntity bodyPart);

	SelfDiagnosisEntity saveEntity(SelfDiagnosisEntity selfDiagnosisEntity);

	SymptomTypeEntity getSymptomTypeById(Integer id);

	List<SymptomTypeEntity> getSymptomTypeList();

	<T extends SelfDiagnosisEntity> T getEntityByTypeAndId(Class<T> clazz, Integer id);
}