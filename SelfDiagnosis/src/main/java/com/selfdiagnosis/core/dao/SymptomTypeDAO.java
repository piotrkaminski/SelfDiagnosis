package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.SymptomTypeEntity;

public interface SymptomTypeDAO {

	List<SymptomTypeEntity> findAll();

}