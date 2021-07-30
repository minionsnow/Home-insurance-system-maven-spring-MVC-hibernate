package com.to;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ValidationQuote {
	@Id
	private int userId;
	private int quoteId;
	private double premium;
	private double dwelling_coverage;
	private double detached_structures;
	private double personal_property;
	private double living_expense;
	private double medical_expense;
	private double deductible;
	
	public ValidationQuote() {
		
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

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getDwelling_coverage() {
		return dwelling_coverage;
	}

	public void setDwelling_coverage(double dwelling_coverage) {
		this.dwelling_coverage = dwelling_coverage;
	}

	public double getDetached_structures() {
		return detached_structures;
	}

	public void setDetached_structures(double detached_structures) {
		this.detached_structures = detached_structures;
	}

	public double getPersonal_property() {
		return personal_property;
	}

	public void setPersonal_property(double personal_property) {
		this.personal_property = personal_property;
	}

	public double getLiving_expense() {
		return living_expense;
	}

	public void setLiving_expense(double living_expense) {
		this.living_expense = living_expense;
	}

	public double getMedical_expense() {
		return medical_expense;
	}

	public void setMedical_expense(double medical_expense) {
		this.medical_expense = medical_expense;
	}

	public double getDeductible() {
		return deductible;
	}

	public void setDeductible(double deductible) {
		this.deductible = deductible;
	}

	@Override
	public String toString() {
		return "ValidationQuote [userId=" + userId + ", quoteId=" + quoteId + ", premium=" + premium
				+ ", dwelling_coverage=" + dwelling_coverage + ", detached_structures=" + detached_structures
				+ ", personal_property=" + personal_property + ", living_expense=" + living_expense
				+ ", medical_expense=" + medical_expense + ", deductible=" + deductible + "]";
	}

	public ValidationQuote(double premium, double dwelling_coverage, double detached_structures,
			double personal_property, double living_expense, double medical_expense, double deductible) {
		super();
		this.premium = premium;
		this.dwelling_coverage = dwelling_coverage;
		this.detached_structures = detached_structures;
		this.personal_property = personal_property;
		this.living_expense = living_expense;
		this.medical_expense = medical_expense;
		this.deductible = deductible;
	}

	
	
	
}
