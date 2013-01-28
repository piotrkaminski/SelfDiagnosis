package com.selfdiagnosis.core.dao;

import java.io.File;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.selfdiagnosis.core.entity.TestEntity;

@Repository
public class ExampleDAOImpl extends BaseDAO implements ExampleDAO {

	@Transactional(propagation = Propagation.REQUIRED)
	public TestEntity getTestEntity(Integer id) {
		return (TestEntity) getObject(TestEntity.class, id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TestEntity getOrderFile(File file) {
		Query query = getCurrentSession().createQuery("from OrderFile where location = :location and filename = :filename");
		query.setParameter("location", file.getParent());
        query.setParameter("filename", file.getName());
		List result = query.list();
		if (result.size() > 1) {
			throw new DAOException("There is more then 1 file: " + result);
		}
		if (result.size() == 1) {
			return (TestEntity) result.get(0);
		}
		return null;
	}	

	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTestEntity(TestEntity testEntity) {
		saveOrUpdate(testEntity);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public TestEntity saveTestEntity(File file) {
		TestEntity orderFile = new TestEntity();
		orderFile.setLocation(file.getParent());
		orderFile.setFileName(file.getName());
		Integer id = save(orderFile);
		return getTestEntity(id);
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
	public List getAllTestEntities() {
		Query query = getCurrentSession().createQuery("from TestEntity order by id desc");
		return query.list();
	}

}
