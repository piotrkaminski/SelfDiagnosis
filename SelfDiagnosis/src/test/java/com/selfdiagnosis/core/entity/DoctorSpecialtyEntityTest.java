package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link DoctorSpecialtyEntity}. Including validators and save
 * entity.
 * 
 * @author mmieszkowski
 * 
 */
public class DoctorSpecialtyEntityTest extends EntityTest {

    /**
     * Checks doctor specialty with blank name.
     */
    @Test
    public void nameIsBlank() {
        DoctorSpecialtyEntity doctorSpecialty = createValidEntity();
        doctorSpecialty.setName("");
        Set<ConstraintViolation<DoctorSpecialtyEntity>> constraintViolations = getValidator().validate(doctorSpecialty);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks doctor specialty with too long name.
     */
    @Test
    public void nameIsTooLong() {
        DoctorSpecialtyEntity doctorSpecialty = createValidEntity();
        doctorSpecialty.setName("Very long doctor specialty name that is longer than fifty characters. " 
                + "Very long doctor specialty name that is longer than fifty characters");
        Set<ConstraintViolation<DoctorSpecialtyEntity>> constraintViolations = getValidator().validate(doctorSpecialty);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 100", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid doctor specialty entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link DoctorSpecialtyEntity}
     */
    @Override
    public DoctorSpecialtyEntity createValidEntity() {
        DoctorSpecialtyEntity doctorSpecialty = new DoctorSpecialtyEntity();
        doctorSpecialty.setName("Internist");
        return doctorSpecialty;
    }

    @Override
    public DoctorSpecialtyEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return (DoctorSpecialtyEntity) adminService.saveEntity(entity);
    }

}
