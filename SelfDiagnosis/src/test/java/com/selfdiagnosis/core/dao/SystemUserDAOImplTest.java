package com.selfdiagnosis.core.dao;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.selfdiagnosis.core.entity.SystemUserEntity;
import com.selfdiagnosis.test.SpringContextTest;

public class SystemUserDAOImplTest extends SpringContextTest {

	@Autowired
	SystemUserDAO systemUserDAO;

	@Test
	public void testFindByEmail() {
		String randomEmail = "sfdsfs@mail.com";
		SystemUserEntity user = systemUserDAO.findByEmail(randomEmail);
		assertNull(user);
	}
}
