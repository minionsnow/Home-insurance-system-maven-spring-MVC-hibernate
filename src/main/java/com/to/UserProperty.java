package com.to;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class UserProperty {
	@Id
	private int userId;
	@NotNull(message="requierd field")
	@Min(value=0)
	private int marketValue;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy")
	@Temporal(TemporalType.DATE)
	private Date builtYear;
	@NotNull(message="requierd field")
	private int sqFoot;
	@NotEmpty(message="requierd field")
	private String dwellingStyle;
	@NotEmpty(message="requierd field")
	private String roofMaterial;
	@NotEmpty(message="requierd field")
	private String garageType;
	@NotNull(message="requierd field")
	private int fullBath;
	@NotNull(message="requierd field")
	private int halfBath;
	@NotNull(message="requierd field")
	private boolean swimmingPool;
	
	public UserProperty() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(int marketValue) {
		this.marketValue = marketValue;
	}


	public Date getBuiltYear() {
		return builtYear;
	}

	public void setBuiltYear(Date builtYear) {
		this.builtYear = builtYear;
	}

	public int getSqFoot() {
		return sqFoot;
	}

	public void setSqFoot(int sqFoot) {
		this.sqFoot = sqFoot;
	}

	public String getDwellingStyle() {
		return dwellingStyle;
	}

	public void setDwellingStyle(String dwellingStyle) {
		this.dwellingStyle = dwellingStyle;
	}

	public String getRoofMaterial() {
		return roofMaterial;
	}

	public void setRoofMaterial(String roofMaterial) {
		this.roofMaterial = roofMaterial;
	}

	public String getGarageType() {
		return garageType;
	}

	public void setGarageType(String garageType) {
		this.garageType = garageType;
	}

	public int getFullBath() {
		return fullBath;
	}

	public void setFullBath(int fullBath) {
		this.fullBath = fullBath;
	}

	public int getHalfBath() {
		return halfBath;
	}

	public void setHalfBath(int halfBath) {
		this.halfBath = halfBath;
	}

	public boolean isSwimmingPool() {
		return swimmingPool;
	}

	public void setSwimmingPool(boolean swimmingPool) {
		this.swimmingPool = swimmingPool;
	}

	@Override
	public String toString() {
		return "UserProperty [userId=" + userId + ", marketValue=" + marketValue + ", builtYear=" + builtYear
				+ ", sqFoot=" + sqFoot + ", dwellingStyle=" + dwellingStyle + ", roofMaterial=" + roofMaterial
				+ ", garageType=" + garageType + ", fullBath=" + fullBath + ", halfBath=" + halfBath + ", swimmingPool="
				+ swimmingPool + "]";
	}

	public UserProperty(@NotNull(message = "requierd field") @Min(0) int marketValue, @NotNull @Past Date builtYear,
			@NotNull(message = "requierd field") int sqFoot, String dwellingStyle, String roofMaterial,
			String garageType, @NotNull(message = "requierd field") int fullBath,
			@NotNull(message = "requierd field") int halfBath,
			@NotNull(message = "requierd field") boolean swimmingPool) {
		super();
		this.marketValue = marketValue;
		this.builtYear = builtYear;
		this.sqFoot = sqFoot;
		this.dwellingStyle = dwellingStyle;
		this.roofMaterial = roofMaterial;
		this.garageType = garageType;
		this.fullBath = fullBath;
		this.halfBath = halfBath;
		this.swimmingPool = swimmingPool;
	}

	

	
}
