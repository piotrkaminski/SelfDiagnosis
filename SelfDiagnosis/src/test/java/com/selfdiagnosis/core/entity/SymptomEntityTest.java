package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Ignore;
import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link SymptomEntity}.
 * Including validators and save entity.
 * 
 * @author mmieszkowski
 *
 */
public class SymptomEntityTest extends EntityTest {

    /**
     * Checks symptom with blank name.
     */
    @Test
    public void nameIsBlank() {
        SymptomEntity symptom = createValidEntity();
        symptom.setName("");
        Set<ConstraintViolation<SymptomEntity>> constraintViolations = getValidator().validate(symptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.name}", constraintViolations.iterator().next().getMessage());
    }
    
    /**
     * Checks symptom with too long name.
     */
    @Test
    public void nameIsTooLong() {
        SymptomEntity symptom = createValidEntity();
        symptom.setName("Very long disease name that is longer than one hundred characters. " 
                + "Very long disease name that is longer than one hundred characters.");
        Set<ConstraintViolation<SymptomEntity>> constraintViolations = getValidator().validate(symptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Length.name}", constraintViolations.iterator().next().getMessage());
    }
    
    /**
     * Checks symptom with no body part.
     */
    @Test
    @Ignore
    //TODO: make custom validator and validate body part only on certain symptom type. Do the same for test_id
    public void bodyPartisNull() {
        SymptomEntity symptom = createValidEntity();
        symptom.setBodyPart(null);
        Set<ConstraintViolation<SymptomEntity>> constraintViolations = getValidator().validate(symptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom with no symptom type.
     */
    @Test
    public void symptomTypeIsNull() {
        SymptomEntity symptom = createValidEntity();
        symptom.setSymptomType(null);
        Set<ConstraintViolation<SymptomEntity>> constraintViolations = getValidator().validate(symptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotNull.symptomType}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected SymptomEntity createValidEntity() {
        return createValidSymptomEntity();
    }

    /**
     * Creates valid symptom entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SymptomEntity}
     */
    public static SymptomEntity createValidSymptomEntity() {
        SymptomEntity symptom = new SymptomEntity();
        symptom.setName("Pain");
        symptom.setBodyPart(BodyPartEntityTest.createValidBodyPartEntity());
        symptom.setSymptomType(SymptomTypeEntityTest.createValidSymptomTypeEntity());
        return symptom;
    }

    @Override
    protected SymptomEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveSymptomEntity(entity, adminService);
    }

    /**
     * Saves symptom.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static SymptomEntity saveSymptomEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        SymptomEntity symptom = (SymptomEntity) entity;
        symptom.setBodyPart(BodyPartEntityTest.saveBodyPartEntity(symptom.getBodyPart(), adminService));
        symptom.setSymptomType(SymptomTypeEntityTest.saveSymptomTypeEntity(symptom.getSymptomType(), adminService));
        return adminService.saveEntity(symptom);
    }

}
