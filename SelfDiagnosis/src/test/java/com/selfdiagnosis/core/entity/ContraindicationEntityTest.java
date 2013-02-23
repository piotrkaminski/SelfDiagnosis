package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link ContraindicationEntity}. Including validators and
 * save entity.
 * 
 * @author mmieszkowski
 * 
 */
public class ContraindicationEntityTest extends EntityTest {

    /**
     * Checks contraindication with blank name.
     */
    @Test
    public void nameIsBlank() {
        ContraindicationEntity contraindication = createValidEntity();
        contraindication.setName("");
        Set<ConstraintViolation<ContraindicationEntity>> constraintViolations = getValidator().validate(
                contraindication);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks contraindication with too long name.
     */
    @Test
    public void nameIsTooLong() {
        ContraindicationEntity contraindication = createValidEntity();
        contraindication.setName("Very long contraindication name that is longer than fifty characters");
        Set<ConstraintViolation<ContraindicationEntity>> constraintViolations = getValidator().validate(
                contraindication);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid contraindication entity. Can be used in this test or tests
     * of related entities.
     * 
     * @return valid {@link ContraindicationEntity}
     */
    @Override
    public ContraindicationEntity createValidEntity() {
        ContraindicationEntity contraindication = new ContraindicationEntity();
        contraindication.setName("Disease");
        return contraindication;
    }

    @Override
    public ContraindicationEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (ContraindicationEntity) adminService.saveEntity(entity);
    }

}
