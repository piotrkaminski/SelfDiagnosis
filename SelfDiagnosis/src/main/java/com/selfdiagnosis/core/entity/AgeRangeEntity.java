package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

import com.selfdiagnosis.SelfDiagnosisConstants;
/**
 * Entity with Age range. Used for base test results.
 * @author mmieszkowski
 *
 */
/**
     * Serial.
     */
/**
     * Primary key.
     */
/**
     * Name of the test.
     */
/**
     * Description of the test.
     */
/**
 * Entity with Age range. Used for base test results.
 * @author mmieszkowski
 *
 */
@Entity
@Table(name = "AgeRange")
public class AgeRangeEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -5592671453853458069L;

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
    @Range(min = SelfDiagnosisConstants.AGE_RANGE_AGE_MIN, 
            max = SelfDiagnosisConstants.AGE_RANGE_AGE_MAX)
    @Column(name = "yearsFrom", unique = false, nullable = true)
    private Integer yearsFrom;

    /**
     * Description of the test.
     */
    @Range(min = SelfDiagnosisConstants.AGE_RANGE_AGE_MIN, 
            max = SelfDiagnosisConstants.AGE_RANGE_AGE_MAX)
    @Column(name = "yearsTo", unique = false, nullable = true)
    private Integer yearsTo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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