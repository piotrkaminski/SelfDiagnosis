package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.selfdiagnosis.core.entity.DiseaseSymptomEntity;

/**
 * Implementation od {@link DiseaseSymptomDAO}.
 * 
 * @author mmieszkowski
 * 
 */
@Repository
public class DiseaseSymptomDAOImpl extends BaseDAOImpl implements DiseaseSymptomDAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<DiseaseSymptomEntity> findAll() {
        Query query = getCurrentSession().createQuery("from DiseaseSymptomEntity");
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<DiseaseSymptomEntity> findAllByDiseaseId(Long id) {
        if (id == null) {
            return null;
        }
        Query query = getCurrentSession().createQuery(
                "from DiseaseSymptomEntity where disease.id = :id").setLong("id", id);
        return query.list();
    }

}
