package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link TreatmentTypeEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TreatmentTypeEntityTest extends EntityTest {


    /**
     * Checks treatmentType with blank name.
     */
    @Test
    public void nameIsBlank() {
        TreatmentTypeEntity treatmentType = createValidEntity();
        treatmentType.setName("");
        Set<ConstraintViolation<TreatmentTypeEntity>> constraintViolations = getValidator().validate(treatmentType);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks treatmentType with too long name.
     */
    @Test
    public void nameIsTooLong() {
        TreatmentTypeEntity treatmentType = createValidEntity();
        String name = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TREATMENT_NAME_LENGTH_MAX + 1);
        treatmentType.setName(name);
        Set<ConstraintViolation<TreatmentTypeEntity>> constraintViolations = getValidator().validate(treatmentType);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected TreatmentTypeEntity createValidEntity() {
        return createValidTreatmentTypeEntity();
    }

    /**
     * Creates valid test flag entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link TreatmentTypeEntity} 
     */
    public static TreatmentTypeEntity createValidTreatmentTypeEntity() {
        TreatmentTypeEntity treatmentType = new TreatmentTypeEntity();
        treatmentType.setName("Rehabilitation");
        return treatmentType;
    }
    
    @Override
    protected TreatmentTypeEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveTreatmentTypeEntity(entity, adminService);
    }

    /**
     * Saves treatment type.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static TreatmentTypeEntity saveTreatmentTypeEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (TreatmentTypeEntity) adminService.saveEntity(entity);
    }

}
