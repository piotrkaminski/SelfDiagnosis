package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link TreatmentEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class TreatmentEntityTest extends EntityTest {

    /**
     * Checks treatment with blank name.
     */
    @Test
    public void nameIsBlank() {
        TreatmentEntity treatment = createValidEntity();
        treatment.setName("");
        Set<ConstraintViolation<TreatmentEntity>> constraintViolations = getValidator().validate(treatment);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks treatment with too long name.
     */
    @Test
    public void nameIsTooLong() {
        TreatmentEntity treatment = createValidEntity();
        String name = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.TREATMENT_NAME_LENGTH_MAX + 1);
        treatment.setName(name);
        Set<ConstraintViolation<TreatmentEntity>> constraintViolations = getValidator().validate(treatment);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected TreatmentEntity createValidEntity() {
        return createValidTreatmentEntity();
    }

    /**
     * Creates valid test flag entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link TreatmentEntity}
     */
    public TreatmentEntity createValidTreatmentEntity() {
        TreatmentEntity treatment = new TreatmentEntity();
        treatment.setTreatmentType(TreatmentTypeEntityTest.createValidTreatmentTypeEntity());
        treatment.setName("Criotherapy");
        return treatment;
    }

    @Override
    protected TreatmentEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveTreatmentEntity(entity, adminService);
    }

    /**
     * Saves treatment.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static TreatmentEntity saveTreatmentEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        TreatmentEntity treatment = (TreatmentEntity) entity;
        treatment.setTreatmentType(TreatmentTypeEntityTest.saveTreatmentTypeEntity(treatment.getTreatmentType(),
                adminService));
        return adminService.saveEntity(treatment);
    }

}
