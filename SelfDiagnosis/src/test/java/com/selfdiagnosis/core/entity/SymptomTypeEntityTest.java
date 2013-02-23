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
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
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
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid symptom type entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SymptomTypeEntity}
     */
    @Override
    public SymptomTypeEntity createValidEntity() {
        SymptomTypeEntity symptomType = new SymptomTypeEntity();
        symptomType.setName("Leg");
        return symptomType;
    }
    
    @Override
    public SymptomTypeEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (SymptomTypeEntity) adminService.saveEntity(entity);
    }


}
