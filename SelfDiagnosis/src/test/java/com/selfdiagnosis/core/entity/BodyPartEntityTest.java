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
public class BodyPartEntityTest {

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
     * Checks valid body part entity. Tries to save it at the end.
     */
    @Test
    @Transactional
    public void diseaseIsValid() {
        BodyPartEntity bodyPart = new BodyPartEntity();
        bodyPart.setName("Leg");
        Set<ConstraintViolation<BodyPartEntity>> constraintViolations = validator.validate(bodyPart);
        assertEquals(0, constraintViolations.size());
        BodyPartEntity savedBodyPart = adminService.saveEntity(bodyPart);
        Assert.notNull(savedBodyPart);
    }
    
    /**
     * Checks body part with blank name.
     */
    @Test
    public void nameIsBlank() {
        BodyPartEntity bodyPart = new BodyPartEntity();
        Set<ConstraintViolation<BodyPartEntity>> constraintViolations = validator.validate(bodyPart);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks body part with too long name.
     */
    @Test
    public void nameIsTooLong() {
        BodyPartEntity bodyPart = new BodyPartEntity();
        bodyPart.setName("Very long body part name that is longer than fifty characters");
        Set<ConstraintViolation<BodyPartEntity>> constraintViolations = validator.validate(bodyPart);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }
}
