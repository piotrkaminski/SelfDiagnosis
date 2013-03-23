package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Entity to hold relation between disease and a symptom.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "DiseaseSymptom")
public class DiseaseSymptomEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 8091460590278611579L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Related disease.
     */
    @NotNull(message = "{NotBlank.disease}")
    @ManyToOne
    @JoinColumn(name = "disease_id", nullable = false)
    private DiseaseEntity disease;

    /**
     * Related symptom.
     */
    @NotNull(message = "{NotNull.symptom}")
    @ManyToOne
    @JoinColumn(name = "symptom_id", nullable = false)
    private SymptomEntity symptom;

    /**
     * Rank of symptom in the disease. Higher the rank, higher the disease in
     * the diseases result list.
     */
    @NotNull(message = "{NotBlank.rank}")
    @Range(min = SelfDiagnosisConstants.DISEASE_SYMPTOM_RANK_MIN, 
            max = SelfDiagnosisConstants.DISEASE_SYMPTOM_RANK_MAX,
            message = "{Range.rank}")
    @Column(name = "rank", nullable = false)
    private Short rank;

    /**
     * Frequency of symptom in the disease. 0-100 where 100 means that 100% of
     * sick patients, has to have this symptom.
     */
    @NotNull(message = "{NotBlank.frequency}")
    @Range(min = SelfDiagnosisConstants.ENTITY_FREQUENCY_MIN, 
            max = SelfDiagnosisConstants.ENTITY_FREQUENCY_MAX,
            message = "{Range.frequency}")
    @Column(name = "frequency", nullable = false)
    private Short frequency;

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

    public Short getFrequency() {
        return frequency;
    }

    public void setFrequency(Short frequency) {
        this.frequency = frequency;
    }
}
