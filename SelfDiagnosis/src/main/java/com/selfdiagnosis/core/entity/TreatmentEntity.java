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

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Treatment entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "Treatment")
public class TreatmentEntity extends SelfDiagnosisEntity implements Serializable {
    
    /**
     * Serial.
     */
    private static final long serialVersionUID = -6991128940215294142L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the treatment.
     */
    @NotBlank(message = "{NotBlank.name}")
    @Length(max = SelfDiagnosisConstants.TREATMENT_NAME_LENGTH_MAX, message = "{Length.name}")
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the treatment.
     */
    @Column(name = "description", unique = false, nullable = true)
    private String description;

    /**
     * Treatment type. I.e rehabilitation, drugs etc.
     */
    @NotNull(message = "{NotNull.treatmentType}")
    @ManyToOne
    @JoinColumn(name = "treatmentType_id", unique = false, nullable = false)
    private TreatmentTypeEntity treatmentType;

    /**
     * If treatment type is drugs, this field holds relation with a drug.
     */
    @ManyToOne
    @JoinColumn(name = "drug_id", unique = false, nullable = true)
    private DrugEntity drug;

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

    public TreatmentTypeEntity getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(TreatmentTypeEntity treatmentType) {
        this.treatmentType = treatmentType;
    }

    public DrugEntity getDrug() {
        return drug;
    }

    public void setDrug(DrugEntity drug) {
        this.drug = drug;
    }

}
