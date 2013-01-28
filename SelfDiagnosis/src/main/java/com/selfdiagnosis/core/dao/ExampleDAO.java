package com.selfdiagnosis.core.dao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface ExampleDAO {

	public abstract List getAllTestEntities();

}