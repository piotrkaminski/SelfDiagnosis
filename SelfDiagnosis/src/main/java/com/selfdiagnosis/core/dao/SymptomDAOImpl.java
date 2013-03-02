package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.SymptomEntity;

/**
 * Implementation for {@link SymptomDAO}.
 * 
 * @author mmieszkowski
 * 
 */
@Repository
public class SymptomDAOImpl extends BaseDAOImpl implements SymptomDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<SymptomEntity> findAll() {
        Query query = getCurrentSession().createQuery("from SymptomEntity order by id desc");
        return query.list();
    }

}
