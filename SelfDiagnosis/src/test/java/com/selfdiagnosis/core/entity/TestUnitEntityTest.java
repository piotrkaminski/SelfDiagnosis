package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * TestUnit class to test {@link TestUnitEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TestUnitEntityTest extends EntityTest {

    /**
     * Checks testUnit with blank name.
     */
    @Test
    public void nameIsBlank() {
        TestUnitEntity testUnit = createValidEntity();
        testUnit.setName("");
        Set<ConstraintViolation<TestUnitEntity>> constraintViolations = getValidator().validate(testUnit);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks testUnit with too long name.
     */
    @Test
    public void nameIsTooLong() {
        TestUnitEntity testUnit = createValidEntity();
        String name = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TEST_UNIT_NAME_LENGTH_MAX + 1);
        testUnit.setName(name);
        Set<ConstraintViolation<TestUnitEntity>> constraintViolations = getValidator().validate(testUnit);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks testUnit with too long short name.
     */
    @Test
    public void shortNameIsTooLong() {
        TestUnitEntity testUnit = createValidEntity();
        String name = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TEST_UNIT_SHORT_NAME_LENGTH_MAX + 1);
        testUnit.setShortName(name);
        Set<ConstraintViolation<TestUnitEntity>> constraintViolations = getValidator().validate(testUnit);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 10", constraintViolations.iterator().next().getMessage());
    }
    
    @Override
    protected TestUnitEntity createValidEntity() {
        return createValidTestUnitEntity();
    }

    /**
     * Creates valid testUnit entity. Can be used in this testUnit or testUnits of
     * related entities.
     * 
     * @return valid {@link TestUnitEntity}
     */
    public static TestUnitEntity createValidTestUnitEntity() {
        TestUnitEntity testUnit = new TestUnitEntity();
        testUnit.setName("ml");
        return testUnit;
    }
    
    @Override
    protected TestUnitEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveTestUnitEntity(entity, adminService);
    }

    /**
     * Saves test unit.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static TestUnitEntity saveTestUnitEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (TestUnitEntity) adminService.saveEntity(entity);
    }

}
