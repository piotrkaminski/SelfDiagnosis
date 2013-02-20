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
public class AgeRangeEntityTest {

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
     * Checks valid age range entity. Tries to save it at the end.
     */
    @Test
    @Transactional
    public void ageRangeIsValid() {
        AgeRangeEntity ageRange = new AgeRangeEntity();
        ageRange.setYearsFrom(SelfDiagnosisConstants.AGE_RANGE_AGE_MIN);
        ageRange.setYearsTo(SelfDiagnosisConstants.AGE_RANGE_AGE_MAX);
        Set<ConstraintViolation<AgeRangeEntity>> constraintViolations = validator.validate(ageRange);
        assertEquals(0, constraintViolations.size());
        AgeRangeEntity savedAgeRange = adminService.saveEntity(ageRange);
        Assert.notNull(savedAgeRange);
    }
    
    /**
     * Checks age range with years out of range.
     */
    @Test
    public void yearsOutOfRange() {
        AgeRangeEntity ageRange = new AgeRangeEntity();
        ageRange.setYearsFrom(-1);
        ageRange.setYearsTo(SelfDiagnosisConstants.AGE_RANGE_AGE_MAX);
        Set<ConstraintViolation<AgeRangeEntity>> constraintViolations = validator.validate(ageRange);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be between 0 and 100", constraintViolations.iterator().next().getMessage());
        
        ageRange.setYearsFrom(SelfDiagnosisConstants.AGE_RANGE_AGE_MIN);
        ageRange.setYearsTo(101);
        constraintViolations = validator.validate(ageRange);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }
}
