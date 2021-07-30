package com.to;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class Policy {
	@Id
	private int userId;
	private int quoteId;
	private int policyKey;
	@NotNull
	@Future
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date effectiveDate;
	@NotNull
	@Future
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	private String policyTerm;
	private String policyStatus;
	
	public Policy() {
		
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public int getPolicyKey() {
		return policyKey;
	}

	public void setPolicyKey(int policyKey) {
		this.policyKey = policyKey;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	@Override
	public String toString() {
		return "Policy [userId=" + userId + ", quoteId=" + quoteId + ", policyKey=" + policyKey + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate + ", policyTerm=" + policyTerm + ", policyStatus="
				+ policyStatus + "]";
	}

	public Policy(@Future Date effectiveDate, @Future Date endDate) {
		super();
		this.effectiveDate = effectiveDate;
		this.endDate = endDate;
	}

	
	
	
}
