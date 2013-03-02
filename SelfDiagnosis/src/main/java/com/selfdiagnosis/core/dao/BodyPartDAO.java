package com.selfdiagnosis.core.dao;

import java.util.List;

import com.selfdiagnosis.core.entity.BodyPartEntity;

/**
 * DAO form {@link BodyPartEntity}.
 * 
 * @author mmieszkowski
 * 
 */
public interface BodyPartDAO extends BaseDAO {

    /**
     * 
     * @return all body parts
     */
    List<BodyPartEntity> findAll();
}
