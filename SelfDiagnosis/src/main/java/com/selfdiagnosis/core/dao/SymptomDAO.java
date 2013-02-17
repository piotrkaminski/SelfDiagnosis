package com.selfdiagnosis.core.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.entity.SymptomEntity;

public interface SymptomDAO extends BaseDAO {

    @Transactional
    List<SymptomEntity> findAll();

}