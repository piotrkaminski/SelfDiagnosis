package com.selfdiagnosis.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Entity to store user and test relation.
 * 
 * @author mmieszkowski
 * 
 */
@Entity
@Table(name = "UserTest")
public class UserTestEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -525214009201704315L;

    /**
     * Primary key.
     */
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * Related user.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private SystemUserEntity user;

    /**
     * Related test.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "test_id", nullable = false)
    private TestEntity test;

    /**
     * Test result.
     */
    @Column(name = "testValue", nullable = true)
    private Double testValue;

    /**
     * Unit in which test result is stored.
     */
    @NotNull
    @ManyToOne
    @JoinColumn(name = "testUnit_id", nullable = true)
    private TestUnitEntity testUnit;

    /**
     * Test flag. I.e. below normal, correct etc.
     */
    @ManyToOne
    @JoinColumn(name = "testFlag_id", nullable = true)
    private TestFlagEntity testFlag;

    /**
     * Date when test was performed.
     */
    @Column(name = "testDate", nullable = true)
    private Date testDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SystemUserEntity getUser() {
        return user;
    }

    public void setUser(SystemUserEntity user) {
        this.user = user;
    }

    public TestEntity getTest() {
        return test;
    }

    public void setTest(TestEntity test) {
        this.test = test;
    }

    public Double getTestValue() {
        return testValue;
    }

    public void setTestValue(Double testValue) {
        this.testValue = testValue;
    }

    public TestUnitEntity getTestUnit() {
        return testUnit;
    }

    public void setTestUnit(TestUnitEntity testUnit) {
        this.testUnit = testUnit;
    }

    public TestFlagEntity getTestFlag() {
        return testFlag;
    }

    public void setTestFlag(TestFlagEntity testFlag) {
        this.testFlag = testFlag;
    }

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

}
