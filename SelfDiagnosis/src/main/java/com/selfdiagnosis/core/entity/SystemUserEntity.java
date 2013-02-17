package com.selfdiagnosis.core.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.selfdiagnosis.SelfDiagnosisConstants;


/**
 * System user entity.
 * @author mmieszkowski
 *
 */
@Entity
@Table(name = "SystemUser")
public class SystemUserEntity extends SelfDiagnosisEntity implements Serializable {
    /**
     * Serial.
     */
    private static final long serialVersionUID = 1107457987110808863L;

    /**
     * Primary key.
     */
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    /**
     * First name of the user.
     */
    @Length(max = SelfDiagnosisConstants.SYSTEM_USER_FIRST_NAME_LENGTH_MAX)
    @Column(name = "firstName", unique = false, nullable = true)
    private String firstName;

    /**
     * Last name of the user.
     */
    @Length(max = SelfDiagnosisConstants.SYSTEM_USER_LAST_NAME_LENGTH_MAX)
    @Column(name = "lastName", unique = false, nullable = true)
    private String lastName;

    /**
     * Email address name of the user.
     */
    @Email
    @Column(name = "email", unique = false, nullable = true)
    private String email;

    /**
     * User's sign in date.
     */
    @Column(name = "signInDate", unique = false, nullable = true)
    private Date signInDate;

    /**
     * User's last log in time.
     */
    @Column(name = "lastLogIn", unique = false, nullable = true)
    private Date lastLogIn;

    /**
     * User's last ip.
     */
    @Length(max = SelfDiagnosisConstants.SYSTEM_USER_IP_LENGTH_MAX)
    @Column(name = "ip", unique = false, nullable = true)
    private String ip;

    /**
     * User's gender.
     */
    @Length(max = 1)
    @Column(name = "gender", unique = false, nullable = true)
    private String gender;

    /**
     * User's birth date.
     */
    @DateTimeFormat
    @Past
    @Column(name = "birthDate", unique = false, nullable = true)
    private Date birthDate;

    /**
     * User's password.
     */
    @NotBlank
    @Length(max = SelfDiagnosisConstants.SYSTEM_USER_PASSWORD_LENGTH_MAX)
    @Column(name = "password", unique = false, nullable = true)
    private String password;

    /**
     * Flag if account is enabled.
     */
    @Column(name = "enabled", unique = false, nullable = false)
    private Boolean enabled;

    /**
     * List of user's security roles.
     */
    @ManyToMany()
    @JoinTable(name = "SystemUserSecurityRole",
        joinColumns = { @JoinColumn(name = "systemUser_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "securityRole_id", referencedColumnName = "id") })
    private List<SecurityRoleEntity> securityRoles;

    /* Getters and setters */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getSignInDate() {
        return signInDate;
    }

    public void setSignInDate(Date signInDate) {
        this.signInDate = signInDate;
    }

    public Date getLastLogIn() {
        return lastLogIn;
    }

    public void setLastLogIn(Date lastLogIn) {
        this.lastLogIn = lastLogIn;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<SecurityRoleEntity> getSecurityRoles() {
        return securityRoles;
    }

    public void setSecurityRoles(List<SecurityRoleEntity> securityRoles) {
        this.securityRoles = securityRoles;
    }
}
