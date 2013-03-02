package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.SymptomTypeEntity;

/**
 * Implementation of {@link SymptomTypeDAO}.
 * 
 * @author mmieszkowski
 * 
 */
@Repository
public class SymptomTypeDAOImpl extends BaseDAOImpl implements SymptomTypeDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<SymptomTypeEntity> findAll() {
        Query query = getCurrentSession().createQuery("from SymptomTypeEntity order by id asc");
        return query.list();
    }

}
