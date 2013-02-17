package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Entity that stores body parts.
 * @author mmieszkowski
 *
 */
@Entity
@Table(name = "BodyPart")
public class BodyPartEntity extends SelfDiagnosisEntity implements Serializable {
 

    /**
     * Serial.
     */
    private static final long serialVersionUID = -3935000687100000630L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the body part.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.BODY_PART_NAME_LENGTH_MAX)
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Parent body part. I.e head is a parent body part for the eyes.
     */
    @ManyToOne
    @JoinColumn(name = "parentBodyPart_id", nullable = true)
    private BodyPartEntity parentBodyPart;

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

    public BodyPartEntity getParentBodyPart() {
        return parentBodyPart;
    }

    public void setParentBodyPart(BodyPartEntity parentBodyPart) {
        this.parentBodyPart = parentBodyPart;
    }
}
