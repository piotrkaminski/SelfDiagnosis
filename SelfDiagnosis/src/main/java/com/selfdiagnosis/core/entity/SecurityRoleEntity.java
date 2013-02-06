package com.selfdiagnosis.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SecurityRole")
public class SecurityRoleEntity {

	/**
	 * Primary key for entity
	 */
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	/**
	 * Security role name.
	 */
	@Column(name = "roleName", nullable = false, unique = true)
	private String roleName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
