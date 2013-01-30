package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SymptomType")
public class SymptomTypeEntity {
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	/**
	 * Name of the symptom type
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the symptom type
	 */
	@Column(name = "description", unique = false, nullable = true)
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
 

}
