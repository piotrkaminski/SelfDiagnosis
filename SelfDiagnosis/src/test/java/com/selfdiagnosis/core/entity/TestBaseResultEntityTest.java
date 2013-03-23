package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link TestBaseResultEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TestBaseResultEntityTest extends EntityTest {

    /**
     * Checks systemUser's test with no test.
     */
    @Test
    public void testIsNull() {
        TestBaseResultEntity testBaseResult = createValidEntity();
        testBaseResult.setTest(null);
        Set<ConstraintViolation<TestBaseResultEntity>> constraintViolations = getValidator().validate(testBaseResult);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotNull.test}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks systemUser's test with no test unit.
     */
    @Test
    public void testUnitIsNull() {
        TestBaseResultEntity testBaseResult = createValidEntity();
        testBaseResult.setTestUnit(null);
        Set<ConstraintViolation<TestBaseResultEntity>> constraintViolations = getValidator().validate(testBaseResult);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotNull.testUnit}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected TestBaseResultEntity createValidEntity() {
        return createValidTestBaseResultEntity();
    }
    
    /**
     * Creates valid testBaseResult entity. Can be used in this testBaseResult or testBaseResults of
     * related entities.
     * 
     * @return valid {@link TestBaseResultEntity}
     */
    public static TestBaseResultEntity createValidTestBaseResultEntity() {
        TestBaseResultEntity testBaseResult = new TestBaseResultEntity();
        testBaseResult.setTestUnit(TestUnitEntityTest.createValidTestUnitEntity());
        testBaseResult.setTest(TestEntityTest.createValidTestEntity());
        return testBaseResult;
    }

    @Override
    protected TestBaseResultEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveTestBaseResultEntity(entity, adminService);
    }

    /**
     * Saves test base result.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static TestBaseResultEntity saveTestBaseResultEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        TestBaseResultEntity testBaseResult = (TestBaseResultEntity) entity;
        testBaseResult.setTest(TestEntityTest.saveTestEntity(testBaseResult.getTest(), adminService));
        testBaseResult.setTestUnit(TestUnitEntityTest.saveTestUnitEntity(testBaseResult.getTestUnit(), adminService));
        return adminService.saveEntity(testBaseResult);
    }

}
