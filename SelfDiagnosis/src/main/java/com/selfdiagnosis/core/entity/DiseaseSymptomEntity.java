package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DiseaseSymptom")
public class DiseaseSymptomEntity {
	
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	/**
	 * Related disease
	 */
	@ManyToOne
	@JoinColumn(name = "disease_id", nullable = false)
	private DiseaseEntity disease;
	
	/**
	 * Related symptom
	 */
	@ManyToOne
	@JoinColumn(name = "symptom_id", nullable = false)
	private SymptomEntity symptom;

	/**
	 * Rank of symptom in the disease. Higher the rank, higher the disease in the diseases result list
	 */
	@Column(name = "rank", nullable = false)
	private Short rank;
	
	/**
	 * Frequency of symptom in the disease. 0-100 where 100 means that 100% of sick patients, has to have this symptom.
	 */
	@Column(name = "frequency", nullable = false)
	private Short frequncy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiseaseEntity getDisease() {
		return disease;
	}

	public void setDisease(DiseaseEntity disease) {
		this.disease = disease;
	}

	public SymptomEntity getSymptom() {
		return symptom;
	}

	public void setSymptom(SymptomEntity symptom) {
		this.symptom = symptom;
	}

	public Short getRank() {
		return rank;
	}

	public void setRank(Short rank) {
		this.rank = rank;
	}

	public Short getFrequncy() {
		return frequncy;
	}

	public void setFrequncy(Short frequncy) {
		this.frequncy = frequncy;
	}
}
