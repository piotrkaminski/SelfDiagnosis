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
 * Test unit entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "TestUnit")
public class TestUnitEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -5723789531683082034L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the test unit.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.TEST_UNIT_NAME_LENGTH_MAX)
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the test unit.
     */
    @Length(max = SelfDiagnosisConstants.TEST_UNIT_SHORT_NAME_LENGTH_MAX)
    @Column(name = "shortName", unique = false, nullable = true)
    private String shortName;

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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

}
