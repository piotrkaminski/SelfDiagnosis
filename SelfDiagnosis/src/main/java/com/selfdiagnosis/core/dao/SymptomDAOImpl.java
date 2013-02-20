package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.SymptomEntity;

@Repository
public class SymptomDAOImpl extends BaseDAOImpl implements SymptomDAO {

    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.SymptomDAO#findAll()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<SymptomEntity> findAll() {
        Query query = getCurrentSession().createQuery("from SymptomEntity order by id desc");
        return query.list();
    }

    
}
