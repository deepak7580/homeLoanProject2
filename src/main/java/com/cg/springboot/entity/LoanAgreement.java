package com.cg.springboot.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;



@Entity
@Table(name="loan_agreement")
public class LoanAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanAgreementId;
	@Column(unique = true)
	private long loanApplicationId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "loanAgreement")
    private EMI emi;

	public EMI getEmi() {
		return emi;
	}
	@Transactional
	public void setEmi(EMI emi) {
	emi.setLoanAgreement(this);
	
		this.emi = emi;
	}

	
	public LoanAgreement(long loanAgreementId, long loanApplicationId, EMI emi) {
		super();
		this.loanAgreementId = loanAgreementId;
		this.loanApplicationId = loanApplicationId;
		
		this.emi = emi;
	}

	public LoanAgreement() {
		
	}
	

	public long getLoanApplicationId() {
		return loanApplicationId;
	}

	public void setLoanApplicationId(long loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	public long getLoanAgreementId() {
		return loanAgreementId;
	}



	public void setLoanAgreementId(long loanAgreementId) {
		this.loanAgreementId = loanAgreementId;
	}



	
}

