package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;

/**
 * Test class to test {@link DiseaseSymptomEntity}.
 * Including validators and save entity.
 * 
 * @author mmieszkowski
 *
 */
public class DiseaseSymptomEntityTest extends EntityTest {

    /**
     * Checks disease symptom with no disease.
     */
    @Test
    public void diseaseIsNull() {
        DiseaseSymptomEntity diseaseSymptom = createValidEntity();
        diseaseSymptom.setDisease(null);
        Set<ConstraintViolation<DiseaseSymptomEntity>> constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.disease}", constraintViolations.iterator().next().getMessage());
    }
    
    /**
     * Checks disease symptom with no symptom.
     */
    @Test
    public void symptomIsNull() {
        DiseaseSymptomEntity diseaseSymptom = createValidEntity();
        diseaseSymptom.setSymptom(null);
        Set<ConstraintViolation<DiseaseSymptomEntity>> constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotNull.symptom}", constraintViolations.iterator().next().getMessage());
    }
    
    /**
     * Checks disease symptom with no frequency.
     */
    @Test
    public void frequencyisNull() {
        DiseaseSymptomEntity diseaseSymptom = createValidEntity();
        diseaseSymptom.setFrequency(null);
        Set<ConstraintViolation<DiseaseSymptomEntity>> constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.frequency}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks disease symptom with frequency out of range.
     */
    @Test
    public void frequencyOutOfRange() {
        DiseaseSymptomEntity diseaseSymptom = createValidEntity();
        diseaseSymptom.setFrequency(new Short("-1"));
        Set<ConstraintViolation<DiseaseSymptomEntity>> constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Range.frequency}", constraintViolations.iterator().next().getMessage());
        
        diseaseSymptom.setFrequency(new Short("101"));
        constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Range.frequency}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks disease symptom with no rank.
     */
    @Test
    public void rankIsNull() {
        DiseaseSymptomEntity diseaseSymptom = createValidEntity();
        diseaseSymptom.setRank(null);
        Set<ConstraintViolation<DiseaseSymptomEntity>> constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.rank}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks disease symptom with rank out of range.
     */
    @Test
    public void rankOutOfRange() {
        DiseaseSymptomEntity diseaseSymptom = createValidEntity();
        diseaseSymptom.setRank(new Short("-1"));
        Set<ConstraintViolation<DiseaseSymptomEntity>> constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Range.rank}", constraintViolations.iterator().next().getMessage());
        
        diseaseSymptom.setRank(new Short("11"));
        constraintViolations = getValidator().validate(diseaseSymptom);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Range.rank}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected DiseaseSymptomEntity createValidEntity() {
        return createValidDiseaseSymptomEntity();
    }
    
    /**
     * Creates valid disease symptom entity. Can be used in this test or tests of
     * related entities.
     * 
     * @return valid {@link DiseaseSymptomEntity}
     */
    public static DiseaseSymptomEntity createValidDiseaseSymptomEntity() {
        DiseaseSymptomEntity diseaseSymptom = new DiseaseSymptomEntity();
        diseaseSymptom.setFrequency(SelfDiagnosisConstants.ENTITY_FREQUENCY_MAX);
        diseaseSymptom.setRank(SelfDiagnosisConstants.DISEASE_SYMPTOM_RANK_MAX);
        diseaseSymptom.setDisease(DiseaseEntityTest.createValidDiseaseEntity());
        diseaseSymptom.setSymptom(SymptomEntityTest.createValidSymptomEntity());
        return diseaseSymptom;
    }
    
    @Override
    protected DiseaseSymptomEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveDiseaseSymptomEntity(entity, adminService);
    }

    /**
     * Saves disease symptom.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static DiseaseSymptomEntity saveDiseaseSymptomEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        DiseaseSymptomEntity diseaseSymptom = (DiseaseSymptomEntity) entity;
        diseaseSymptom.setDisease(DiseaseEntityTest.saveDiseaseEntity(diseaseSymptom.getDisease(), adminService));
        diseaseSymptom.setSymptom(SymptomEntityTest.saveSymptomEntity(diseaseSymptom.getSymptom(), adminService));
        return adminService.saveEntity(diseaseSymptom);
    }

}
