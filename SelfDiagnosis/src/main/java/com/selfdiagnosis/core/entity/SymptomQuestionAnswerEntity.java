package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Entity that stores answers to symptom questions.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "SymptomQuestionAnswer")
public class SymptomQuestionAnswerEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -5243042936481966453L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Question, this answer relates to.
     */
    @NotNull(message = "{NotNull.symptomQuestion}")
    @ManyToOne
    @JoinColumn(name = "symptomQuestion_id", unique = false, nullable = false)
    private SymptomQuestionEntity symptomQuestion;

    /**
     * Answers's number within given symptom question.
     */
    @NotNull(message = "{NotNull.answerNumber}")
    @Min(value = 0, message = "{Min.answerNumber}")
    @Column(name = "answerNumber", unique = false, nullable = false)
    private Short answerNumber;

    /**
     * Answer's text.
     */
    @NotBlank(message = "{NotBlank.answer}")
    @Length(max = SelfDiagnosisConstants.SYMPTOM_QUESTION_ANSWER_LENGTH_MAX, message = "{Length.answer}")
    @Column(name = "answer", unique = false, nullable = false)
    private String answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SymptomQuestionEntity getSymptomQuestion() {
        return symptomQuestion;
    }

    public void setSymptomQuestion(SymptomQuestionEntity symptomQuestion) {
        this.symptomQuestion = symptomQuestion;
    }

    public Short getAnswerNumber() {
        return answerNumber;
    }

    public void setAnswerNumber(Short answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
