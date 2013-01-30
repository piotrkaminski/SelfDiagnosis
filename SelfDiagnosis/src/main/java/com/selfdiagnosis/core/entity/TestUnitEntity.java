package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TestUnit")
public class TestUnitEntity {

	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the test type
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the test type
	 */
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
