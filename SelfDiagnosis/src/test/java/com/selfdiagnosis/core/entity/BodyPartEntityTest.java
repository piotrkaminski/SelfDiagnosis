package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link BodyPartEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class BodyPartEntityTest extends EntityTest {

    /**
     * Checks body part with blank name.
     */
    @Test
    public void nameIsBlank() {
        BodyPartEntity bodyPart = createValidEntity();
        bodyPart.setName("");
        Set<ConstraintViolation<BodyPartEntity>> constraintViolations = getValidator().validate(bodyPart);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks body part with too long name.
     */
    @Test
    public void nameIsTooLong() {
        BodyPartEntity bodyPart = createValidEntity();
        bodyPart.setName("Very long body part name that is longer than fifty characters");
        Set<ConstraintViolation<BodyPartEntity>> constraintViolations = getValidator().validate(bodyPart);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected BodyPartEntity createValidEntity() {
        return createValidBodyPartEntity();
    }
    
    /**
     * Creates valid body part entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link BodyPartEntity}
     */
    public static BodyPartEntity createValidBodyPartEntity() {
        BodyPartEntity bodyPart = new BodyPartEntity();
        bodyPart.setName("Leg");
        return bodyPart;
    }

    @Override
    protected BodyPartEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveBodyPartEntity(entity, adminService);
    }
    
    /**
     * Saves body part.
     * @param entity to save
     * @param adminService injected service
     * @return saved body part
     */
    public static BodyPartEntity saveBodyPartEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (BodyPartEntity) adminService.saveEntity(entity);
    }
    
}
