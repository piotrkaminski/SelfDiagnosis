package com.selfdiagnosis.core.entity;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.selfdiagnosis.SelfDiagnosisConstants;
import com.selfdiagnosis.core.service.AdminService;
import com.selfdiagnosis.test.SelfDiagnosisTestUtils;

/**
 * Test class to test {@link DiseaseSymptomEntity}. Including validators and
 * save entity.
 * 
 * @author mmieszkowski
 * 
 */
public class SymptomQuestionEntityTest extends EntityTest {

    /**
     * Checks symptom question with no symptom.
     */
    @Test
    public void symptomIsNull() {
        SymptomQuestionEntity symptomQuestion = createValidEntity();
        symptomQuestion.setSymptom(null);
        Set<ConstraintViolation<SymptomQuestionEntity>> constraintViolations = getValidator().validate(symptomQuestion);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotNull.symptom}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom question with no symptom.
     */
    @Test
    public void questionNumberIsNull() {
        SymptomQuestionEntity symptomQuestion = createValidEntity();
        symptomQuestion.setQuestionNumber(null);
        Set<ConstraintViolation<SymptomQuestionEntity>> constraintViolations = getValidator().validate(symptomQuestion);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotNull.questionNumber}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom question with no question text.
     */
    @Test
    public void questionIsBlank() {
        SymptomQuestionEntity symptomQuestion = createValidEntity();
        symptomQuestion.setQuestion("");
        Set<ConstraintViolation<SymptomQuestionEntity>> constraintViolations = getValidator().validate(symptomQuestion);
        assertEquals(1, constraintViolations.size());
        assertEquals("{NotBlank.question}", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom question with question text too long.
     */
    @Test
    public void questionTooLong() {
        SymptomQuestionEntity symptomQuestion = createValidEntity();
        String question = SelfDiagnosisTestUtils.generateString(SelfDiagnosisConstants.SYMPTOM_QUESTION_LENGTH_MAX + 1);
        symptomQuestion.setQuestion(question);
        Set<ConstraintViolation<SymptomQuestionEntity>> constraintViolations = getValidator().validate(symptomQuestion);
        assertEquals(1, constraintViolations.size());
        assertEquals("{Length.question}", constraintViolations.iterator().next().getMessage());
    }

    @Override
    protected SymptomQuestionEntity createValidEntity() {
        return createValidSymptomQuestionEntity();
    }

    /**
     * Creates valid symptom question entity. Can be used in this test or tests
     * of related entities.
     * 
     * @return valid {@link SymptomQuestionEntity}
     */
    public static SymptomQuestionEntity createValidSymptomQuestionEntity() {
        SymptomQuestionEntity symptomQuestion = new SymptomQuestionEntity();
        symptomQuestion.setQuestionNumber(new Short("0"));
        symptomQuestion.setQuestion("Do you have a pain?");
        symptomQuestion.setSymptom(SymptomEntityTest.createValidSymptomEntity());
        return symptomQuestion;
    }

    @Override
    protected SymptomQuestionEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        return saveSymptomQuestionEntity(entity, adminService);
    }

    /**
     * Saves symptom question.
     * 
     * @param entity
     *            to save
     * @param adminService
     *            injected service
     * @return saved entity
     */
    public static SymptomQuestionEntity saveSymptomQuestionEntity(
            SelfDiagnosisEntity entity, AdminService adminService) {
        SymptomQuestionEntity symptomQuestion = (SymptomQuestionEntity) entity;
        symptomQuestion.setSymptom(SymptomEntityTest.saveSymptomEntity(symptomQuestion.getSymptom(), adminService));
        return adminService.saveEntity(symptomQuestion);
    }

}
