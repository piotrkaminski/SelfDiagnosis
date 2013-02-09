package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AgeRange")
public class AgeRangeEntity {

	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the test
	 */
	@Column(name = "yearsFrom", unique = false, nullable = true)
	private Integer yearsFrom;
	
	/**
	 * Description of the test
	 */
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
