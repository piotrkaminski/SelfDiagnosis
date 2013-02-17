package com.selfdiagnosis.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.selfdiagnosis.SelfDiagnosisConstants;

/**
 * Security role entity. Necessary for spring security.
 * 
 * @author pkaminski
 * 
 */
@Entity
@Table(name = "SecurityRole")
public class SecurityRoleEntity extends SelfDiagnosisEntity implements Serializable {

    /**
     * Serial.
     */
    private static final long serialVersionUID = -8374640937693525840L;

    /**
     * Primary key for entity.
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    /**
     * Security role name.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.SECURITY_ROLE_NAME_LENGTH_MAX)
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
