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
 * Entity for test base results.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "TestBaseResult")
public class TestBaseResultEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = 4823858939745944679L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Type of the test - i.e. blood, urine etc.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "test_id")
    private TestEntity test;

    /**
     * Bottom of the age range.
     */
    @Range(min = SelfDiagnosisConstants.AGE_RANGE_AGE_MIN, 
            max = SelfDiagnosisConstants.AGE_RANGE_AGE_MAX)
    @Column(name = "yearsFrom", unique = false, nullable = true)
    private Integer yearsFrom;

    /**
     * Age range top.
     */
    @Range(min = SelfDiagnosisConstants.AGE_RANGE_AGE_MIN, 
            max = SelfDiagnosisConstants.AGE_RANGE_AGE_MAX)
    @Column(name = "yearsTo", unique = false, nullable = true)
    private Integer yearsTo;

    /**
     * Gender with which this base result is related.
     */
    @Column(name = "gender_id")
    private GenderEnum gender;

    /**
     * Minimum correct value for the test.
     */
    @Column(name = "minimumValue", unique = false, nullable = true)
    private Double minimumValue;

    /**
     * Maximum correct value for the test.
     */
    @Column(name = "maximumValue", unique = false, nullable = true)
    private Double maximumValue;

    /**
     * Unit in which test result is being stored.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "testUnit_id")
    private TestUnitEntity testUnit;

    public TestUnitEntity getTestUnit() {
        return testUnit;
    }

    public void setTestUnit(TestUnitEntity testUnit) {
        this.testUnit = testUnit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMinimumValue() {
        return minimumValue;
    }

    public void setMinimumValue(Double minimumValue) {
        this.minimumValue = minimumValue;
    }

    public Double getMaximumValue() {
        return maximumValue;
    }

    public void setMaximumValue(Double maximumValue) {
        this.maximumValue = maximumValue;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Integer getYearsFrom() {
        return yearsFrom;
    }

    public void setYearsFrom(Integer yearsFrom) {
        this.yearsFrom = yearsFrom;
    }

    public Integer getYearsTo() {
        return yearsTo;
    }

    public void setYearsTo(Integer yearsTo) {
        this.yearsTo = yearsTo;
    }

}
