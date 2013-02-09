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
@Table(name = "Disease")
public class DiseaseEntity {
	/**
	 * Primary key
	 */
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * Name of the disease
	 */
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	/**
	 * Description of the disease
	 */
	@Column(name = "description", unique = false, nullable = true)
	private String description;

	/**
	 * Frequency of disease
	 */
	@Column(name = "frequency", nullable = false)
	private Short frequncy;
	

	/**
	 * Specialties of doctors you should see having a disease
	 */
	@ManyToMany
	@JoinTable(
			name = "DiseaseDoctorSpecialty",
			joinColumns = @JoinColumn(name = "disease_id"),
			inverseJoinColumns = @JoinColumn(name = "doctorSpecialty_id"))
	private Collection<DoctorSpecialtyEntity> doctorSpecialtyCollection;
	

	/**
	 * Treatments that should be applied when having a disease
	 */
	@ManyToMany
	@JoinTable(
			name = "DiseaseTreatment",
			joinColumns = @JoinColumn(name = "disease_id"),
			inverseJoinColumns = @JoinColumn(name = "treatment_id"))
	private Collection<TreatmentEntity> treatmentCollection;

	
	
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

	public Short getFrequncy() {
		return frequncy;
	}

	public void setFrequncy(Short frequncy) {
		this.frequncy = frequncy;
	}

	public Collection<DoctorSpecialtyEntity> getDoctorSpecialtyCollection() {
		return doctorSpecialtyCollection;
	}

	public void setDoctorSpecialtyCollection(
			Collection<DoctorSpecialtyEntity> doctorSpecialtyCollection) {
		this.doctorSpecialtyCollection = doctorSpecialtyCollection;
	}

	public Collection<TreatmentEntity> getTreatmentCollection() {
		return treatmentCollection;
	}

	public void setTreatmentCollection(
			Collection<TreatmentEntity> treatmentCollection) {
		this.treatmentCollection = treatmentCollection;
	}
 

}
