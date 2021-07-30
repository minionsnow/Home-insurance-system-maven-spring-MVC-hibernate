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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class HomeOwner {
	@Id
	private int userId;
	@NotEmpty(message="requierd field")
	@Length(max = 10)
	private String firstNmae;
	@NotEmpty(message="requierd field")
	@Length(max = 20)
	private String lastName;
	@NotNull
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@NotNull(message="requierd field")
	private String retired;
	@NotNull(message="requierd field")
	@Min(value = 100000000, message="should be a valid 9-digit numeric value")
	private long ssNumber;
	@NotEmpty(message="requierd field")
	@Email
	private String email;
	
	public HomeOwner() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstNmae() {
		return firstNmae;
	}

	public void setFirstNmae(String firstNmae) {
		this.firstNmae = firstNmae;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public long getSsNumber() {
		return ssNumber;
	}

	public void setSsNumber(long ssNumber) {
		this.ssNumber = ssNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "HomeOwner [userId=" + userId + ", firstNmae=" + firstNmae + ", lastName=" + lastName + ", dob=" + dob
				+ ", retired=" + retired + ", ssNumber=" + ssNumber + ", email=" + email + "]";
	}

	public HomeOwner(String firstNmae, String lastName, Date dob, @NotNull(message = "requierd field") String retired,
			@NotNull(message = "requierd field") @Min(value = 100000000, message = "should be a valid 9-digit numeric value") long ssNumber,
			String email) {
		super();
		this.firstNmae = firstNmae;
		this.lastName = lastName;
		this.dob = dob;
		this.retired = retired;
		this.ssNumber = ssNumber;
		this.email = email;
	}

	

	

	

	
	
}
