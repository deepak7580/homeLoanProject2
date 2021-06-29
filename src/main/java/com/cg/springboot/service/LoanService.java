package com.cg.springboot.service;

import java.util.List;

import com.cg.springboot.entity.LoanApplication;

public interface LoanService {

	String addLoanApplication(LoanApplication loanApplication);

	List<LoanApplication> retrieveAllLoanApplication();

	LoanApplication retrieveLoanApplicationById(long loanId);

	LoanApplication updateLoanApplication(long loanId, LoanApplication loan);

	LoanApplication deleteLoanApplication(long loanId);



}
