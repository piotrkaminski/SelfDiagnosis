package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link AgeRangeEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class AgeRangeEntityTest extends EntityTest {

    /**
     * Checks age range with years out of range.
     */
    @Test
    public void yearsOutOfRange() {
        AgeRangeEntity ageRange = createValidEntity();
        ageRange.setYearsFrom(-1);
        Set<ConstraintViolation<AgeRangeEntity>> constraintViolations = getValidator().validate(ageRange);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be between 0 and 100", constraintViolations.iterator().next().getMessage());

        ageRange.setYearsFrom(SelfDiagnosisConstants.AGE_RANGE_AGE_MIN);
        ageRange.setYearsTo(101);
        constraintViolations = getValidator().validate(ageRange);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid entity. Can be used in this test or in tests of related
     * entities.
     * 
     * @return valid {@link AgeRangeEntity}
     */
    @Override
    public AgeRangeEntity createValidEntity() {
        AgeRangeEntity ageRange = new AgeRangeEntity();
        ageRange.setYearsFrom(SelfDiagnosisConstants.AGE_RANGE_AGE_MIN);
        ageRange.setYearsTo(SelfDiagnosisConstants.AGE_RANGE_AGE_MAX);
        return ageRange;
    }

    @Override
    public AgeRangeEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (AgeRangeEntity) adminService.saveEntity(entity);
    }

}
