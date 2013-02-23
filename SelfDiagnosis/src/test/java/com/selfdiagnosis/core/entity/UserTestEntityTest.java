package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link UserTestEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class UserTestEntityTest extends EntityTest {

    /**
     * Checks systemUser test with no systemUser.
     */
    @Test
    public void systemUserIsNull() {
        UserTestEntity userTest = createValidEntity();
        userTest.setUser(null);
        Set<ConstraintViolation<UserTestEntity>> constraintViolations = getValidator().validate(userTest);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks systemUser's test with no test.
     */
    @Test
    public void testIsNull() {
        UserTestEntity userTest = createValidEntity();
        userTest.setTest(null);
        Set<ConstraintViolation<UserTestEntity>> constraintViolations = getValidator().validate(userTest);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks systemUser's test with no test unit.
     */
    @Test
    public void testUnitIsNull() {
        UserTestEntity userTest = createValidEntity();
        userTest.setTestUnit(null);
        Set<ConstraintViolation<UserTestEntity>> constraintViolations = getValidator().validate(userTest);
        assertEquals(1, constraintViolations.size());
        //TODO: Move messages to constants.
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid user test entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link UserTestEntity}
     */
    @Override
    public UserTestEntity createValidEntity() {
        UserTestEntity userTest = new UserTestEntity();
        userTest.setTest(new TestEntityTest().createValidEntity());
        userTest.setUser(new SystemUserEntityTest().createValidEntity());
        userTest.setTestUnit(new TestUnitEntityTest().createValidEntity());
        return userTest;
    }

    @Override
    public UserTestEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        UserTestEntity userTest = (UserTestEntity) entity;
        userTest.setTest((new TestEntityTest()).saveEntity(userTest.getTest(), adminService));
        userTest.setUser(new SystemUserEntityTest().saveEntity(userTest.getUser(), adminService));
        userTest.setTestUnit(new TestUnitEntityTest().saveEntity(userTest.getTestUnit(), adminService));
        return adminService.saveEntity(userTest);
    }

}
