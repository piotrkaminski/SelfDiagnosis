package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.TestEntity;

/**
 * DAO for {@link TestEntity}.
 * @author mmieszkowski
 *
 */
@Repository
public class TestDAOImpl extends BaseDAOImpl implements TestDAO {

    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.TestDAO#findAll()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<TestEntity> findAll() {
        Query query = getCurrentSession().createQuery("from TestEntity order by id asc");
        return query.list();
    }

    
}
