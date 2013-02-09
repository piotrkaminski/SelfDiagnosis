package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TestBaseResult")
public class TestBaseResultEntity {
	
	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Type of the test - i.e. blood, urine etc.
	 */
	@ManyToOne
	@JoinColumn(name = "test_id")
	private TestEntity test;
	
	/**
	 * Type of the test - i.e. blood, urine etc.
	 */
	@ManyToOne
	@JoinColumn(name = "ageRange_id")
	private AgeRangeEntity ageRange;
	
	/**
	 * Type of the test - i.e. blood, urine etc.
	 */
	@ManyToOne
	@JoinColumn(name = "gender_id")
	private GenderEntity gender;
	
	/**
	 * Minimum correct value for the test
	 */
	@Column(name = "minimumValue", unique = false, nullable = true)
	private Double minimumValue;
 
	/**
	 * Maximum correct value for the test
	 */
	@Column(name = "maximumValue", unique = false, nullable = true)
	private Double maximumValue;
 
	/**
	 * Unit in which test result is being stored
	 */
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

	public AgeRangeEntity getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(AgeRangeEntity ageRange) {
		this.ageRange = ageRange;
	}

	public GenderEntity getGender() {
		return gender;
	}

	public void setGender(GenderEntity gender) {
		this.gender = gender;
	}

}
