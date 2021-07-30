package com.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table
public class UserLocation {
	@Id
	private int userId;
	@NotEmpty(message="requierd field")
	private String residenceType;
	@NotEmpty(message="requierd field")
	@Length(max = 50)
	private String address;
	@NotEmpty(message="requierd field")
	@Length(max = 20)
	private String city;
	@NotEmpty(message="requierd field")
	@Length(max = 20)
	private String state;
	@NotNull(message="requierd field")
	@Max(value = 1000000000)
	private int zip;
	@NotEmpty(message="requierd field")
	private String residenceUse;
	
	public UserLocation() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(String residenceType) {
		this.residenceType = residenceType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getResidenceUse() {
		return residenceUse;
	}

	public void setResidenceUse(String residenceUse) {
		this.residenceUse = residenceUse;
	}

	@Override
	public String toString() {
		return "UserLocation [userId=" + userId + ", residenceType=" + residenceType + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", residenceUse=" + residenceUse + "]";
	}

	public UserLocation(String residenceType, String address, String city, String state, int zip, String residenceUse) {
		super();
		this.residenceType = residenceType;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.residenceUse = residenceUse;
	}

	
	
	

}
