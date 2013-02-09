package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SymptomQuestion")
public class SymptomQuestionEntity {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/** 
	 * Symptom, this question relates to
	 */
	@ManyToOne
	@JoinColumn(name = "symptom_id", unique = false, nullable = false)
	private SymptomEntity symptom;
	
	/**
	 * Question's number within given symptom.
	 * First question is always about having a symptom.
	 */
	@Column(name = "questionNumber", unique = false, nullable = false)
	private Short questionNumber;
	
	/**
	 * Question's text
	 */
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
