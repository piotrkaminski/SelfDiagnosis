package com.selfdiagnosis.core.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Drug")
public class DrugEntity {
	
	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the drug
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the drug
	 */
	@Column(name = "description", unique = false, nullable = true)
	private String description;
	
	/**
	 * Drug's contraindications
	 */
	@ManyToMany
	@JoinTable(
			name = "DrugContraindication",
			joinColumns = @JoinColumn(name = "drug_id"),
			inverseJoinColumns = @JoinColumn(name = "contraindication_id"))
	private Collection<ContraindicationEntity> contraindicationCollection;
 
		
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

}
