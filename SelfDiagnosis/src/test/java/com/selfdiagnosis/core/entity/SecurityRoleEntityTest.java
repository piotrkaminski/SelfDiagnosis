package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link SecurityRoleEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class SecurityRoleEntityTest extends EntityTest {

    /**
     * Checks security role with blank name.
     */
    @Test
    public void nameIsBlank() {
        SecurityRoleEntity securityRole = createValidEntity();
        securityRole.setRoleName(null);
        Set<ConstraintViolation<SecurityRoleEntity>> constraintViolations = getValidator().validate(securityRole);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks security role with too long name.
     */
    @Test
    public void nameIsTooLong() {
        SecurityRoleEntity securityRole = createValidEntity();
        securityRole.setRoleName("Very long security role name that is longer than fifty characters. ");
        Set<ConstraintViolation<SecurityRoleEntity>> constraintViolations = getValidator().validate(securityRole);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 50", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid security role entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link SecurityRoleEntity}
     */
    @Override
    public SecurityRoleEntity createValidEntity() {
        SecurityRoleEntity securityRole = new SecurityRoleEntity();
        securityRole.setRoleName("User");
        return securityRole;
    }

    @Override
    public SecurityRoleEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (SecurityRoleEntity) adminService.saveEntity(entity);
    }

}
