package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.TestEntity;

/**
 * Implementation of {@link TestDAO}.
 * 
 * @author mmieszkowski
 * 
 */
@Repository
public class TestDAOImpl extends BaseDAOImpl implements TestDAO {

    @Override
    @SuppressWarnings("unchecked")
    public final List<TestEntity> findAll() {
        Query query = getCurrentSession().createQuery("from TestEntity order by id asc");
        return query.list();
    }

}
