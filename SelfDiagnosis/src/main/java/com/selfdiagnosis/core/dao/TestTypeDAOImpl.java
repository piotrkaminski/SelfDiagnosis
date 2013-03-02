package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.TestTypeEntity;

/**
 * Implementation of {@link TestTypeDAO}.
 * 
 * @author mmieszkowski
 * 
 */
@Repository
public class TestTypeDAOImpl extends BaseDAOImpl implements TestTypeDAO {

    @Override
    @SuppressWarnings("unchecked")
    public final List<TestTypeEntity> findAll() {
        Query query = getCurrentSession().createQuery("from TestTypeEntity order by id asc");
        return query.list();
    }

}
