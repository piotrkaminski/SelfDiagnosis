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

    @Override
    protected UserTestEntity createValidEntity() {
        return createValidUserTestEntity();
    }
    
    /**
     * Creates valid user test entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link UserTestEntity}
     */
    public static UserTestEntity createValidUserTestEntity() {
        UserTestEntity userTest = new UserTestEntity();
        userTest.setTest(TestEntityTest.createValidTestEntity());
        userTest.setUser(SystemUserEntityTest.createValidSystemUserEntity());
        userTest.setTestUnit(TestUnitEntityTest.createValidTestUnitEntity());
        return userTest;
    }

    @Override
    protected UserTestEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveUserTestEntity(entity, adminService);
    }

    /**
     * Saves user test entity.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static UserTestEntity saveUserTestEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        UserTestEntity userTest = (UserTestEntity) entity;
        userTest.setTest(TestEntityTest.saveTestEntity(userTest.getTest(), adminService));
        userTest.setUser(SystemUserEntityTest.saveSystemUserEntity(userTest.getUser(), adminService));
        userTest.setTestUnit(TestUnitEntityTest.saveTestUnitEntity(userTest.getTestUnit(), adminService));
        return adminService.saveEntity(userTest);
    }

}
