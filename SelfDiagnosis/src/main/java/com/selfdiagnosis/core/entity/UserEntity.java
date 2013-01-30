package com.selfdiagnosis.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {
	/**
	 * Primary key
	 */
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	/**
	 * First name of the user
	 */
	@Column(name = "firstName", unique = false, nullable = true)
	private String firstName;

	/**
	 * Last name of the user
	 */
	@Column(name = "lastName", unique = false, nullable = true)
	private String lastName;

	/**
	 * Email address name of the user
	 */
	@Column(name = "email", unique = false, nullable = true)
	private String email;
	
	/**
	 * Telephone number of the user
	 */
	@Column(name = "tel", unique = false, nullable = true)
	private String tel;

	/**
	 * Zip code for user's address
	 */
	@Column(name = "zipCode", unique = false, nullable = true)
	private String zipCode;
	
	/**
	 * User's city
	 */
	@Column(name = "city", unique = false, nullable = true)
	private String city;
	
	/**
	 * User's address
	 */
	@Column(name = "address", unique = false, nullable = true)
	private String address;

	
	/**
	 * User's sign in date
	 */
	@Column(name = "signInDate", unique = false, nullable = true)
	private Date signInDate;
	
	/**
	 * User's last log in time
	 */
	@Column(name = "lastLogIn", unique = false, nullable = true)
	private Date lastLogIn;

	/**
	 * User's last ip
	 */
	@Column(name = "ip", unique = false, nullable = true)
	private String ip;

	/**
	 * User's gender
	 */
	@Column(name = "gender", unique = false, nullable = true)
	private String gender;

	/**
	 * User's birth date
	 */
	@Column(name = "birthDate", unique = false, nullable = true)
	private Date birthDate;

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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

}
