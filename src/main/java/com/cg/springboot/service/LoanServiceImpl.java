package com.cg.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springboot.dao.CustomerRepository;
import com.cg.springboot.dao.LoanRepo;
import com.cg.springboot.entity.Customer;
import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.exception.CustomerNotFoundException;
@Service
public class LoanServiceImpl implements LoanService {
	@Autowired
	LoanRepo loanrepo;
	@Autowired
	CustomerRepository custRepo;

	@Override
	public String addLoanApplication(LoanApplication loanApplication) {
	//loanrepo.save(loanApplication);

		Customer cust=loanApplication.getCustomer();
		int id =cust.getCustomerId();
		try
		{
			Customer c =custRepo.findById(id).get();
			
		}catch(Exception e)
		{
			throw new CustomerNotFoundException("register first");
		}
		
		Customer c =custRepo.findById(id).get();
		System.out.println(c);
		loanApplication.setCustomer(c);
		
		LoanApplication l=loanrepo.findByCustomer(c);
		System.out.println(l);
		if(l!=null)
		{
//			return "custemer is already registered";
			throw new CustomerNotFoundException("custemer is already registered");
			
		}
			
			loanrepo.save(loanApplication);
			return "ok";
		
		
		
//	try {
//		loanrepo.save(loanApplication);
//		return "ok";
//	}catch(Exception e)
//	{
//		System.out.println(e);
//		return "jnjn";
//	}
//	
		
		
	}

	@Override
	public List<LoanApplication> retrieveAllLoanApplication() {
		List<LoanApplication> loan=loanrepo.findAll();
		return loan;
	}

	@Override
	public LoanApplication retrieveLoanApplicationById(long loanId) {
		Optional<LoanApplication> loan= loanrepo.findById(loanId);
		return loan.get();
	}

	@Override
	public LoanApplication updateLoanApplication(long loanId, LoanApplication loanApp) {
		Optional<LoanApplication>loan= loanrepo.findById(loanId);
		loan.get().setApplicationId(loanId);
		loan.get().setApplicationDate(loanApp.getApplicationDate());
		loan.get().setLoanAppliedAmount(loanApp.getLoanAppliedAmount());
		loan.get().setLoanApprovedAmount(loanApp.getLoanApprovedAmount());
		loan.get().setLandVerificationApproval(false);
		loan.get().setFinananceVerificationApproval(false);
		loan.get().setAdminApproval(false);
		loan.get().setStatus(loanApp.getStatus());
	
		
		loanrepo.save(loan.get());
		custRepo.save(loan.get().getCustomer());
		return loan.get();
	}

	@Override
	public LoanApplication deleteLoanApplication(long loanId) {
		LoanApplication loan=loanrepo.getById(loanId);
		loanrepo.deleteById(loan.getApplicationId());
		return loan;
	}
	




}



