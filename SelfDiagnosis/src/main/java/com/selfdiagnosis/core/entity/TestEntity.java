package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Test entity.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "Test")
public class TestEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 698761121334069642L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Name of the test.
     */
    @NotBlank(message = "{NotBlank.name}")
    @Length(max = SelfDiagnosisConstants.TEST_NAME_LENGTH_MAX, message = "{Length.name}")
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     * Description of the test.
     */
    @Column(name = "description", unique = false, nullable = true)
    private String description;

    /**
     * Type of the test - i.e. blood, urine etc.
     */
    @NotNull(message = "{NotNull.testType}")
    @ManyToOne
    @JoinColumn(name = "testType_id")
    private TestTypeEntity testType;

    /**
     * For how many days, test result is valid.
     */
    @Min(value = 0, message = "{Min.validForDays}")
    @Column(name = "validForDays", unique = false, nullable = true)
    private Integer validForDays;

    public TestTypeEntity getTestType() {
        return testType;
    }

    public void setTestType(TestTypeEntity testType) {
        this.testType = testType;
    }

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

    public Integer getValidForDays() {
        return validForDays;
    }

    public void setValidForDays(Integer validForDays) {
        this.validForDays = validForDays;
    }

}
