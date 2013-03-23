package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link SymptomTypeEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class SymptomTypeEntityTest extends EntityTest {

    /**
     * Checks symptom type with blank name.
     */
    @Test
    public void nameIsBlank() {
        SymptomTypeEntity symptomType = createValidEntity();
        symptomType.setName("");
        Set<ConstraintViolation<SymptomTypeEntity>> constraintViolations = getValidator().validate(symptomType);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.name}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom type with too long name.
     */
    @Test
    public void nameIsTooLong() {
        SymptomTypeEntity symptomType = createValidEntity();
        symptomType.setName("Very long body part name that is longer than fifty characters");
        Set<ConstraintViolation<SymptomTypeEntity>> constraintViolations = getValidator().validate(symptomType);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Length.name}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected SymptomTypeEntity createValidEntity() {
        return createValidSymptomTypeEntity();
    }

    /**
     * Creates valid symptom type entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SymptomTypeEntity}
     */
    public static SymptomTypeEntity createValidSymptomTypeEntity() {
        SymptomTypeEntity symptomType = new SymptomTypeEntity();
        symptomType.setName("Leg");
        return symptomType;
    }

    @Override
    protected SymptomTypeEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveSymptomTypeEntity(entity, adminService);
    }

    /**
     * Saves symptom type.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static SymptomTypeEntity saveSymptomTypeEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (SymptomTypeEntity) adminService.saveEntity(entity);
    }

}
