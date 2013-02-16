package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Symptom")
public class SymptomEntity implements SelfDiagnosisEntity, Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 7426824635548340022L;

	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the disease
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the disease
	 */
	@Column(name = "description", unique = false, nullable = true)
	private String description;

	/**
	 * Type of the symptom
	 */
	@ManyToOne
	@JoinColumn(name = "symptomType_id", nullable = false)
	private SymptomTypeEntity symptomType;
	
	/**
	 * body part the symptom is related with
	 */
	@ManyToOne
	@JoinColumn(name = "bodyPart_id", nullable = true)
	private BodyPartEntity bodyPart;
	
	/**
	 * test related with symptom, not null for 'test' symptom types
	 */
	@ManyToOne
	@JoinColumn(name = "test_id", nullable = true)
	private TestEntity test;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SymptomTypeEntity getSymptomType() {
		return symptomType;
	}

	public void setSymptomType(SymptomTypeEntity symptomType) {
		this.symptomType = symptomType;
	}

	public BodyPartEntity getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(BodyPartEntity bodyPart) {
		this.bodyPart = bodyPart;
	}

	public TestEntity getTest() {
		return test;
	}

	public void setTest(TestEntity test) {
		this.test = test;
	}
	
	
	
}
