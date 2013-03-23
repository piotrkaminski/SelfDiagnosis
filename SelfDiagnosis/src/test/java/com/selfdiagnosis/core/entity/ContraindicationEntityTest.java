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
        assertEquals("NotBlank.name", constraintViolations.iterator().next().getMessage());
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
        assertEquals("{Length.name}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected ContraindicationEntity createValidEntity() {
        return createValidContraindicationEntity();
    }

    /**
     * Creates valid contraindication entity. Can be used in this test or tests
     * of related entities.
     * 
     * @return valid {@link ContraindicationEntity}
     */
    public static ContraindicationEntity createValidContraindicationEntity() {
        ContraindicationEntity contraindication = new ContraindicationEntity();
        contraindication.setName("Disease");
        return contraindication;
    }

    @Override
    protected ContraindicationEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveContraindicationEntity(entity, adminService);
    }

    /**
     * Saves contraindication.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static ContraindicationEntity saveContraindicationEntity(SelfDiagnosisEntity entity,
            AdminService adminService) {
        return (ContraindicationEntity) adminService.saveEntity(entity);
    }

}
