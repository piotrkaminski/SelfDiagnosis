package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
public class TestEntity {
	
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "Id", unique = true, nullable = false)
	private Integer id;
	
	/**
	 * folder where file is located
	 */
	@Column(name = "Location", unique = false, nullable = false)
	private String location;
	
	/**
	 * File name
	 */
	@Column(name = "FileName", unique = false, nullable = false)
	private String fileName;
 
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("Order file [id: ");
		str.append(this.id);
		
		if (this.location != null) {
			str.append(", location: " + this.location);
		}
		if (this.fileName != null) {
			str.append(", fileName: " + this.fileName);
		}
		str.append("]");
		return str.toString();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
