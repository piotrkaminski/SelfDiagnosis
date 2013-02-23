package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link BodyPartEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class SystemUserEntityTest extends EntityTest {


    /**
     * Checks system user with blank password.
     */
    @Test
    public void passwordIsBlank() {
        SystemUserEntity systemUser = createValidEntity();
        systemUser.setPassword("");
        Set<ConstraintViolation<SystemUserEntity>> constraintViolations = getValidator().validate(systemUser);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks system user with too long password.
     */
    @Test
    public void passwordIsTooLong() {
        SystemUserEntity systemUser = createValidEntity();
        String password = SelfDiagnosisTestUtils
                .generateString(SelfDiagnosisConstants.SYSTEM_USER_PASSWORD_LENGTH_MAX + 1);
        systemUser.setPassword(password);
        Set<ConstraintViolation<SystemUserEntity>> constraintViolations = getValidator().validate(systemUser);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks system user with too long first name.
     */
    @Test
    public void firstNameIsTooLong() {
        SystemUserEntity systemUser = createValidEntity();
        String firstName = SelfDiagnosisTestUtils
                .generateString(SelfDiagnosisConstants.SYSTEM_USER_FIRST_NAME_LENGTH_MAX + 1);
        systemUser.setFirstName(firstName);
        Set<ConstraintViolation<SystemUserEntity>> constraintViolations = getValidator().validate(systemUser);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks system user with too long last name.
     */
    @Test
    public void lastNameIsTooLong() {
        SystemUserEntity systemUser = createValidEntity();
        String lastName = SelfDiagnosisTestUtils
                .generateString(SelfDiagnosisConstants.SYSTEM_USER_LAST_NAME_LENGTH_MAX + 1);
        systemUser.setLastName(lastName);
        Set<ConstraintViolation<SystemUserEntity>> constraintViolations = getValidator().validate(systemUser);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks system user with not valid email.
     */
    @Test
    public void emailNotValid() {
        SystemUserEntity systemUser = createValidEntity();
        systemUser.setEmail("test.pl");
        Set<ConstraintViolation<SystemUserEntity>> constraintViolations = getValidator().validate(systemUser);
        assertEquals(1, constraintViolations.size());
        assertEquals("not a well-formed email address", constraintViolations.iterator().next().getMessage());
 
        systemUser.setEmail("test@test.pl");
        constraintViolations = getValidator().validate(systemUser);
        assertEquals(0, constraintViolations.size());
    }

    /**
     * Checks system user with future birth date.
     */
    @Test
    public void birthDateInFuture() {
        SystemUserEntity systemUser = createValidEntity();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        systemUser.setBirthDate(c.getTime());
        Set<ConstraintViolation<SystemUserEntity>> constraintViolations = getValidator().validate(systemUser);
        assertEquals(1, constraintViolations.size());
        assertEquals("must be in the past", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid system user entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SystemUserEntity}
     */
    @Override
    public SystemUserEntity createValidEntity() {
        SystemUserEntity systemUser = new SystemUserEntity();
        systemUser.setPassword("Password");
        systemUser.setEnabled(true);
        return systemUser;
    }

    @Override
    public SystemUserEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (SystemUserEntity) adminService.saveEntity(entity);
    }

}
