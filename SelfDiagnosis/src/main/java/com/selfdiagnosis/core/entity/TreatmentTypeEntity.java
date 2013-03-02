package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Treatment type entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "TreatmentType")
public class TreatmentTypeEntity extends SelfDiagnosisEntity implements Serializable {
    
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
     * Name of the treatment type.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.TREATMENT_NAME_LENGTH_MAX)
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the treatment type.
     */
    @Column(name = "description", unique = false, nullable = true)
    private String description;

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

}
