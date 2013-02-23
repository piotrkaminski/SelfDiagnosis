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
public class SymptomQuestionAnswerEntityTest extends EntityTest {

    /**
     * Checks symptom answer with no symptom.
     */
    @Test
    public void symptomQuestionIsNull() {
        SymptomQuestionAnswerEntity symptomQuestionAnswer = createValidEntity();
        symptomQuestionAnswer.setSymptomQuestion(null);
        Set<ConstraintViolation<SymptomQuestionAnswerEntity>> constraintViolations = getValidator().validate(
                symptomQuestionAnswer);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom answer with no symptom.
     */
    @Test
    public void answerNumberIsNull() {
        SymptomQuestionAnswerEntity symptomQuestionAnswer = createValidEntity();
        symptomQuestionAnswer.setAnswerNumber(null);
        Set<ConstraintViolation<SymptomQuestionAnswerEntity>> constraintViolations = getValidator().validate(
                symptomQuestionAnswer);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be null", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom answer with no answer text.
     */
    @Test
    public void answerIsBlank() {
        SymptomQuestionAnswerEntity symptomQuestionAnswer = createValidEntity();
        symptomQuestionAnswer.setAnswer("");
        Set<ConstraintViolation<SymptomQuestionAnswerEntity>> constraintViolations = getValidator().validate(
                symptomQuestionAnswer);
        assertEquals(1, constraintViolations.size());
        assertEquals("may not be empty", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Checks symptom question answer with answer text too long.
     */
    @Test
    public void answerTooLong() {
        SymptomQuestionAnswerEntity symptomQuestionAnswer = createValidEntity();
        String answer = SelfDiagnosisTestUtils
                .generateString(SelfDiagnosisConstants.SYMPTOM_QUESTION_ANSWER_LENGTH_MAX + 1);
        symptomQuestionAnswer.setAnswer(answer);
        Set<ConstraintViolation<SymptomQuestionAnswerEntity>> constraintViolations = getValidator().validate(
                symptomQuestionAnswer);
        assertEquals(1, constraintViolations.size());
        assertEquals("length must be between 0 and 200", constraintViolations.iterator().next().getMessage());
    }

    /**
     * Creates valid symptom question answer entity. Can be used in this test or
     * tests of related entities.
     * 
     * @return valid {@link SymptomQuestionAnswerEntity}
     */
    @Override
    public SymptomQuestionAnswerEntity createValidEntity() {
        SymptomQuestionAnswerEntity symptomQuestionAnswer = new SymptomQuestionAnswerEntity();
        symptomQuestionAnswer.setAnswerNumber(new Short("0"));
        symptomQuestionAnswer.setAnswer("Yes");
        symptomQuestionAnswer.setSymptomQuestion(new SymptomQuestionEntityTest().createValidEntity());
        return symptomQuestionAnswer;
    }

    @Override
    public SymptomQuestionAnswerEntity saveEntity(SelfDiagnosisEntity entity, AdminService adminService) {
        SymptomQuestionAnswerEntity symptomQuestionAnswer = (SymptomQuestionAnswerEntity) entity;
        symptomQuestionAnswer.setSymptomQuestion(new SymptomQuestionEntityTest().saveEntity(
                symptomQuestionAnswer.getSymptomQuestion(), adminService));
        return adminService.saveEntity(symptomQuestionAnswer);
    }

}
