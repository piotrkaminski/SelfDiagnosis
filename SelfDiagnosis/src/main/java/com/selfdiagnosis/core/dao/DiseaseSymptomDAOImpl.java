package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;

@Repository
public class DiseaseSymptomDAOImpl extends BaseDAOImpl implements DiseaseSymptomDAO {

    /* (non-Javadoc)
     * @see com.selfdiagnosis.core.dao.DiseaseSymptomDAO#findAll()
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<DiseaseSymptomEntity> findAll() {
        Query query = getCurrentSession().createQuery("from DiseaseSymptomEntity order by id desc");
        return query.list();
    }

    @Override
    public List<DiseaseSymptomEntity> findAllByDiseaseId(Long id) {
        if (id == null) {
            return null;
        }
        Query query = getCurrentSession().createQuery("from DiseaseSymptomEntity where id = :id order by id desc")
                .setLong("id", id);
        return query.list();
    }
    
    
}
