package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SymptomQuestionAnswer")
public class SymptomQuestionAnswerEntity {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Question, this answer relates to
	 */
	@ManyToOne
	@JoinColumn(name = "symptomQuestion_id", unique = false, nullable = false)
	private SymptomQuestionEntity symptomQuestion;
	
	/**
	 * Answers's number within given symptom question.
	 */
	@Column(name = "answerNumber", unique = false, nullable = false)
	private Short answerNumber;
	
	/**
	 * Answer's text
	 */
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
