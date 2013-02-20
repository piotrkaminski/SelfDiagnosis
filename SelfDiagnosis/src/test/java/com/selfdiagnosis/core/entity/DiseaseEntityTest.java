package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link DiseaseEntity}.
 * Including validators and save entity.
 * 
 * @author mmieszkowski
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DiseaseEntityTest {

    /**
     * Injected {@link AdminService}.
     */
    @Autowired
    private AdminService adminService;
    
    /**
     * Validator.
     */
    private static Validator validator;

    /**
     * Set up method. Ran before all tests.
     */
    @BeforeClass
    public static void setUp() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Checks valid disease entity. Tries to save it at the end.
     */
    @Test
    @Transactional
    public void diseaseIsValid() {
        DiseaseEntity disease = new DiseaseEntity();
        disease.setName("Flu");
        disease.setFrequency(SelfDiagnosisConstants.ENTITY_FREQUENCY_MAX);
        Set<ConstraintViolation<DiseaseEntity>> constraintViolations = validator.validate(disease);
        assertEquals(0, constraintViolations.size());
        DiseaseEntity savedDisease = adminService.saveEntity(disease);
        Assert.notNull(savedDisease);
    }
    
    /**
     * Checks disease with blank name.
     */
    @Test
    public void nameIsBlank() {
        DiseaseEntity disease = new DiseaseEntity();
        disease.setFrequency(SelfDiagnosisConstants.ENTITY_FREQUENCY_MAX);
        Set<ConstraintViolation<DiseaseEntity>> constraintViolations = validator.validate(disease);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }
    
    /**
     * Checks disease with too long name.
     */
    @Test
    public void nameIsTooLong() {
        DiseaseEntity disease = new DiseaseEntity();
        disease.setName("Very long disease name that is longer than one hundred characters. " 
                + "Very long disease name that is longer than one hundred characters.");
        disease.setFrequency(SelfDiagnosisConstants.ENTITY_FREQUENCY_MAX);
        Set<ConstraintViolation<DiseaseEntity>> constraintViolations = validator.validate(disease);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }
    
    /**
     * Checks disease with no frequency.
     */
    @Test
    public void frequencyisNull() {
        DiseaseEntity disease = new DiseaseEntity();
        disease.setName("Flu");
        Set<ConstraintViolation<DiseaseEntity>> constraintViolations = validator.validate(disease);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks disease with frequency out of range.
     */
    @Test
    public void frequencyOutOfRange() {
        DiseaseEntity disease = new DiseaseEntity();
        disease.setName("Flu");
        disease.setFrequency(new Short("-1"));
        Set<ConstraintViolation<DiseaseEntity>> constraintViolations = validator.validate(disease);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be between 0 and 100", constraintViolations.iterator().next().getMessage());
        
        disease.setFrequency(new Short("101"));
        constraintViolations = validator.validate(disease);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }
}
