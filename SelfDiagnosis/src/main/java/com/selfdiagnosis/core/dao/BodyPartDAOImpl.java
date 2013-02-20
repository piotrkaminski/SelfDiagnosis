package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.BodyPartEntity;

@Repository
public class BodyPartDAOImpl extends BaseDAOImpl implements BodyPartDAO {

    @SuppressWarnings("unchecked")
    @Override
    public List<BodyPartEntity> findAll() {
        Query query = getCurrentSession().createQuery("from BodyPartEntity order by id desc");
        return query.list();
    }

    
}
