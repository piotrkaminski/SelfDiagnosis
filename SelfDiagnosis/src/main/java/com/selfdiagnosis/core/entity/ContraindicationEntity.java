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
 * Entity for contraindications. Used for drugs.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "Contraindication")
public class ContraindicationEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -4504750332088881033L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the contraindication.
     */
    @NotBlank(message = "NotBlank.name")
    @Length(max = SelfDiagnosisConstants.CONTRAINDICATION_NAME_LENGTH_MAX, message = "{Length.name}")
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the contraindication.
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
