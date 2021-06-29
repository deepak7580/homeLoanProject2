package com.cg.springboot.entity;

import java.time.LocalDate;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="LoanApplication",uniqueConstraints= {@UniqueConstraint(columnNames= {"customer_customer_id"})})

public class LoanApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long applicationId;

//	@JsonFormat(pattern="yyyy-mm-dd")
	private LocalDate applicationDate;
	
	@DecimalMin(value = "0", message = "Loan applied amount should not be less than thousand values")
	private double loanAppliedAmount;
	
	@DecimalMin(value = "0", message = "Loan approved amount should not be less than thousand values")
	private double loanApprovedAmount;
	private boolean landVerificationApproval;
	private boolean finananceVerificationApproval;
	private boolean adminApproval;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE,
            CascadeType.REFRESH, CascadeType.DETACH})
	
	private Customer customer;

	public LoanApplication() {
		super();
	}

	public LoanApplication( LocalDate applicationDate, double loanAppliedAmount,
			double loanApprovedAmount, boolean landVerificationApproval, boolean finananceVerificationApproval,
			boolean adminApproval, Status status, Customer customer) {
		super();
		
		this.applicationDate = applicationDate;
		this.loanAppliedAmount = loanAppliedAmount;
		this.loanApprovedAmount = loanApprovedAmount;
		this.landVerificationApproval = landVerificationApproval;
		this.finananceVerificationApproval = finananceVerificationApproval;
		this.adminApproval = adminApproval;
		this.status = status;
		this.customer = customer;
	}

	public long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(long applicationId) {
		this.applicationId = applicationId;
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public double getLoanAppliedAmount() {
		return loanAppliedAmount;
	}

	public void setLoanAppliedAmount(double loanAppliedAmount) {
		this.loanAppliedAmount = loanAppliedAmount;
	}

	public double getLoanApprovedAmount() {
		return loanApprovedAmount;
	}

	public void setLoanApprovedAmount(double loanApprovedAmount) {
		this.loanApprovedAmount = loanApprovedAmount;
	}

	public boolean isLandVerificationApproval() {
		return landVerificationApproval;
	}

	public void setLandVerificationApproval(boolean landVerificationApproval) {
		this.landVerificationApproval = landVerificationApproval;
	}

	public boolean isFinananceVerificationApproval() {
		return finananceVerificationApproval;
	}

	public void setFinananceVerificationApproval(boolean finananceVerificationApproval) {
		this.finananceVerificationApproval = finananceVerificationApproval;
	}

	public boolean isAdminApproval() {
		return adminApproval;
	}

	public void setAdminApproval(boolean adminApproval) {
		this.adminApproval = adminApproval;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer c) {
		this.customer = c;
	}

	@Override
	public String toString() {
		return "LoanApplication [applicationId=" + applicationId + ", applicationDate=" + applicationDate
				+ ", loanAppliedAmount=" + loanAppliedAmount + ", loanApprovedAmount=" + loanApprovedAmount
				+ ", landVerificationApproval=" + landVerificationApproval + ", finananceVerificationApproval="
				+ finananceVerificationApproval + ", adminApproval=" + adminApproval + ", status=" + status
				+ ", customer=" + customer + "]";
	}
	
	
	
	

}
