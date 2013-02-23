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
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
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
        //TODO: Move messages to constants.
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid testBaseResult entity. Can be used in this testBaseResult or testBaseResults of
     * related entities.
     * 
     * @return valid {@link TestBaseResultEntity}
     */
    public TestBaseResultEntity createValidEntity() {
        TestBaseResultEntity testBaseResult = new TestBaseResultEntity();
        testBaseResult.setTestUnit(new TestUnitEntityTest().createValidEntity());
        testBaseResult.setTest(new TestEntityTest().createValidEntity());
        return testBaseResult;
    }

    @Override
    public SelfDiagnosisEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        TestBaseResultEntity testBaseResult = (TestBaseResultEntity) entity;
        testBaseResult.setTest(new TestEntityTest().saveEntity(testBaseResult.getTest(), adminService));
        testBaseResult.setTestUnit(new TestUnitEntityTest().saveEntity(testBaseResult.getTestUnit(), adminService));
        return adminService.saveEntity(testBaseResult);
    }
}
