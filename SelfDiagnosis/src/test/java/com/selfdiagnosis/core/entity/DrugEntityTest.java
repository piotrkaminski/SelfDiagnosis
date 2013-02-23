package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link DrugEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class DrugEntityTest extends EntityTest {

    /**
     * Checks drug with blank name.
     */
    @Test
    public void nameIsBlank() {
        DrugEntity drug = createValidEntity();
        drug.setName("");
        Set<ConstraintViolation<DrugEntity>> constraintViolations = getValidator().validate(drug);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks drug with too long name.
     */
    @Test
    public void nameIsTooLong() {
        DrugEntity drug = createValidEntity();
        drug.setName("Very long drug name that is longer than fifty characters");
        Set<ConstraintViolation<DrugEntity>> constraintViolations = getValidator().validate(drug);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid drug entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link DrugEntity} 
     */
    @Override
    public DrugEntity createValidEntity() {
        DrugEntity drug = new DrugEntity();
        drug.setName("Aspirin");
        return drug;
    }

    @Override
    public DrugEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (DrugEntity) adminService.saveEntity(entity);
    }

}
