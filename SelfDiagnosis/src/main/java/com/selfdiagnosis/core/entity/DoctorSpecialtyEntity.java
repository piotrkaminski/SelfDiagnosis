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
 * Doctor specialty entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "DoctorSpecialty")
public class DoctorSpecialtyEntity extends SelfDiagnosisEntity implements Serializable {
    
    /**
     * Serial.
     */
    private static final long serialVersionUID = 2830645340130553002L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the specialty.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.DOCTOR_SPECIALTY_NAME_LENGTH_MAX)
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the specialty.
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
