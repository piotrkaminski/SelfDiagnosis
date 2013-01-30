package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
public class TestEntity {
	
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the test
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the test
	 */
	@Column(name = "description", unique = false, nullable = true)
	private String description;
 
	/**
	 * Type of the test - i.e. blood, urine etc.
	 */
	@ManyToOne
	@JoinColumn(name = "testType_id")
	private TestTypeEntity testType;
	
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
	
	/**
	 * For how many days, test result is valid
	 */
	@Column(name = "validForDays", unique = false, nullable = true)
	private Integer validForDays;
	

	/**
	 * The cost of the test
	 */
	@Column(name = "cost", unique = false, nullable = true)
	private Integer cost;


	
	public TestTypeEntity getTestType() {
		return testType;
	}

	public void setTestType(TestTypeEntity testType) {
		this.testType = testType;
	}

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

	public Integer getValidForDays() {
		return validForDays;
	}

	public void setValidForDays(Integer validForDays) {
		this.validForDays = validForDays;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
