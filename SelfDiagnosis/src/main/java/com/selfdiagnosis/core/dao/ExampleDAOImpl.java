package com.selfdiagnosis.core.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.entity.TestEntity;

@Repository
public class ExampleDAOImpl extends BaseDAOImpl implements ExampleDAO {

	@Transactional(propagation = Propagation.REQUIRED)
	public TestEntity getTestEntity(Integer id) {
		return (TestEntity) getObject(TestEntity.class, id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTestEntity(TestEntity testEntity) {
		saveOrUpdate(testEntity);
	}

	
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(TestEntity testEntity) {
		super.delete(testEntity);
	}	
	
	/* (non-Javadoc)
	 * @see com.selfdiagnosis.core.dao.ExampleDAO#getAllTestEntities()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TestEntity> getAllTestEntities() {
		Query query = getCurrentSession().createQuery("from TestEntity order by id desc");
		return query.list();
	}

}
