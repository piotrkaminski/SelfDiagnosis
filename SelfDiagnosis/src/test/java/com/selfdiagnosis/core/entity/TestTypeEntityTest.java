package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link TestTypeEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TestTypeEntityTest extends EntityTest {

    /**
     * Checks test type with blank name.
     */
    @Test
    public void nameIsBlank() {
        TestTypeEntity testType = new TestTypeEntity();
        Set<ConstraintViolation<TestTypeEntity>> constraintViolations = getValidator().validate(testType);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks test type with too long name.
     */
    @Test
    public void nameIsTooLong() {
        TestTypeEntity testType = new TestTypeEntity();
        String type = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TEST_TYPE_NAME_LENGTH_MAX + 1);
        testType.setName(type);
        Set<ConstraintViolation<TestTypeEntity>> constraintViolations = getValidator().validate(testType);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid test type entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link TestTypeEntity}
     */
    @Override
    public TestTypeEntity createValidEntity() {
        TestTypeEntity testType = new TestTypeEntity();
        testType.setName("Blood");
        return testType;
    }

    @Override
    public TestTypeEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (TestTypeEntity) adminService.saveEntity(entity);
    }

}
