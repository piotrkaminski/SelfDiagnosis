package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link TestEntity}. Including validators and save entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TestEntityTest extends EntityTest {

    /**
     * Checks test with blank name.
     */
    @Test
    public void nameIsBlank() {
        TestEntity test = createValidEntity();
        test.setName("");
        Set<ConstraintViolation<TestEntity>> constraintViolations = getValidator().validate(test);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks test with too long name.
     */
    @Test
    public void nameIsTooLong() {
        TestEntity test = createValidEntity();
        String name = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TEST_NAME_LENGTH_MAX + 1);
        test.setName(name);
        Set<ConstraintViolation<TestEntity>> constraintViolations = getValidator().validate(test);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks test with too long name.
     */
    @Test
    public void testTypeIsNull() {
        TestEntity test = createValidEntity();
        test.setTestType(null);
        Set<ConstraintViolation<TestEntity>> constraintViolations = getValidator().validate(test);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid test entity. Can be used in this test or tests of related
     * entities.
     * 
     * @return valid {@link TestEntity}
     */
    @Override
    public TestEntity createValidEntity() {
        TestEntity test = new TestEntity();
        test.setName("Sugar");
        test.setTestType(new TestTypeEntityTest().createValidEntity());
        return test;
    }

    @Override
    public TestEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        TestEntity test = (TestEntity) entity;
        test.setTestType(new TestTypeEntityTest().saveEntity(test.getTestType(), adminService));
        return adminService.saveEntity(test);
    }
}
