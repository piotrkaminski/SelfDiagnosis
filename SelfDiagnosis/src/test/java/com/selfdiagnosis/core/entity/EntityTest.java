package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SpringContextTest;

/**
 * Parent class for all entity tests.
 * 
 * @author mmieszkowski
 * 
 */
public abstract class EntityTest extends SpringContextTest {

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
     * Checks valid systemUser test entity. Tries to save it at the end.
     */
    @Test
    @Transactional
    public void entityIsValid() {
        SelfDiagnosisEntity entity = createValidEntity();
        Set<ConstraintViolation<SelfDiagnosisEntity>> constraintViolations = getValidator().validate(entity);
        assertEquals(0, constraintViolations.size());
        SelfDiagnosisEntity savedEntity = saveEntity(entity, adminService);
        Assert.notNull(savedEntity);
    }

    /**
     * Saves all entities, this one relates to and this one as well.
     * 
     * @param entity
     *            to save relations for
     * @param adminService
     *            injected {@link AdminService}
     * @return entity with saved related rows
     * 
     */
    public abstract SelfDiagnosisEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService);

    /**
     * Creates valid entity of any type. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SelfDiagnosisEntity}
     */
    public abstract SelfDiagnosisEntity createValidEntity();

    public AdminService getAdminService() {
        return adminService;
    }

    public static Validator getValidator() {
        return validator;
    }

    public static void setValidator(Validator validator) {
        EntityTest.validator = validator;
    }
}
