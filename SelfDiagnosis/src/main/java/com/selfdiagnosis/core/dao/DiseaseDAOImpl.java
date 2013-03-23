package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.DiseaseEntity;

/**
 * Implementation of {@link DiseaseDAO}.
 * 
 * @author mmieszkowski
 * 
 */
@Repository
public class DiseaseDAOImpl extends BaseDAOImpl implements DiseaseDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<DiseaseEntity> findAll() {
        Query query = getCurrentSession().createQuery("from DiseaseEntity");
        return query.list();
    }


}
