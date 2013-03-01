package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link TestFlagEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TestFlagEntityTest extends EntityTest {

    /**
     * Checks testFlag with blank name.
     */
    @Test
    public void nameIsBlank() {
        TestFlagEntity testFlag = createValidEntity();
        testFlag.setName("");
        Set<ConstraintViolation<TestFlagEntity>> constraintViolations = getValidator().validate(testFlag);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks testFlag with too long name.
     */
    @Test
    public void nameIsTooLong() {
        TestFlagEntity testFlag = createValidEntity();
        String flag = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TEST_FLAG_NAME_LENGTH_MAX + 1);
        testFlag.setName(flag);
        Set<ConstraintViolation<TestFlagEntity>> constraintViolations = getValidator().validate(testFlag);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 20", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected TestFlagEntity createValidEntity() {
        return createValidTestFlagEntity();
    }
    
    /**
     * Creates valid test flag entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link TestFlagEntity} 
     */
    public static TestFlagEntity createValidTestFlagEntity() {
        TestFlagEntity testFlag = new TestFlagEntity();
        testFlag.setName("Too high");
        return testFlag;
    }

    @Override
    protected TestFlagEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveTestFlagEntity(entity, adminService);
    }

    /**
     * Saves test flag.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static TestFlagEntity saveTestFlagEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (TestFlagEntity) adminService.saveEntity(entity);
    }

}
