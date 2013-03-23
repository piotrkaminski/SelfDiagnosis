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
 * Symptom questions entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "SymptomQuestion")
public class SymptomQuestionEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -4665256835134213975L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Symptom, this question relates to.
     */
    @NotNull(message = "{NotNull.symptom}")
    @ManyToOne
    @JoinColumn(name = "symptom_id", unique = false, nullable = false)
    private SymptomEntity symptom;

    /**
     * Question's number within given symptom. First question is always about
     * having a symptom.
     */
    @NotNull(message = "{NotNull.questionNumber}")
    @Min(value = 0, message = "{Min.questionNumber}")
    @Column(name = "questionNumber", unique = false, nullable = false)
    private Short questionNumber;

    /**
     * Question's text.
     */
    @NotBlank(message = "{NotBlank.question}")
    @Length(max = SelfDiagnosisConstants.SYMPTOM_QUESTION_LENGTH_MAX, message = "{Length.question}")
    @Column(name = "question", unique = false, nullable = false)
    private String question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SymptomEntity getSymptom() {
        return symptom;
    }

    public void setSymptom(SymptomEntity symptom) {
        this.symptom = symptom;
    }

    public Short getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Short questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}
