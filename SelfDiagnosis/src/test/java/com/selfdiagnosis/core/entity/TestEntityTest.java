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
        assertEquals("{NotBlank.name}", constraintViolations.iterator().next().getMessage());
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
        assertEquals("{Length.name}", constraintViolations.iterator().next().getMessage());
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
        assertEquals("{NotNull.testType}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected TestEntity createValidEntity() {
        return createValidTestEntity();
    }
    
    /**
     * Creates valid test entity. Can be used in this test or tests of related
     * entities.
     * 
     * @return valid {@link TestEntity}
     */
    public static TestEntity createValidTestEntity() {
        TestEntity test = new TestEntity();
        test.setName("Sugar");
        test.setTestType(TestTypeEntityTest.createValidTestTypeEntity());
        return test;
    }

    @Override
    protected TestEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveTestEntity(entity, adminService);
    }

    /**
     * Saves test entity.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static TestEntity saveTestEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        TestEntity test = (TestEntity) entity;
        test.setTestType(TestTypeEntityTest.saveTestTypeEntity(test.getTestType(), adminService));
        return adminService.saveEntity(test);
    }
    
}
