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
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
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
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
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
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid symptom entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SymptomEntity}
     */
    @Override
    public SymptomEntity createValidEntity() {
        SymptomEntity symptom = new SymptomEntity();
        symptom.setName("Pain");
        symptom.setBodyPart(new BodyPartEntityTest().createValidEntity());
        symptom.setSymptomType(new SymptomTypeEntityTest().createValidEntity());
        return symptom;
    }

    @Override
    public SymptomEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        SymptomEntity symptom = (SymptomEntity) entity;
        symptom.setBodyPart(new BodyPartEntityTest().saveEntity(symptom.getBodyPart(), adminService));
        symptom.setSymptomType(new SymptomTypeEntityTest().saveEntity(symptom.getSymptomType(), adminService));
        return adminService.saveEntity(symptom);
    }

}
