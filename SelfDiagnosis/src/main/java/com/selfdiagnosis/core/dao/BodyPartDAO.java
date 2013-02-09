package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.BodyPartEntity;

public interface BodyPartDAO extends BaseDAO {
	
	List<BodyPartEntity> findAll();
}
