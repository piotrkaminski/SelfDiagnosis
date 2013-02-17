package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.SymptomTypeEntity;

@Repository
public class SymptomTypeDAOImpl extends BaseDAOImpl implements SymptomTypeDAO {

    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.SymptomTypeDAO#findAll()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<SymptomTypeEntity> findAll() {
        Query query = getCurrentSession().createQuery("from SymptomTypeEntity order by id asc");
        return query.list();
    }

    
}
