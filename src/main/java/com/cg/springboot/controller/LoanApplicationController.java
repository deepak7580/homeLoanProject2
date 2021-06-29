package com.cg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.springboot.entity.LoanApplication;
import com.cg.springboot.service.LoanService;

@RestController
public class LoanApplicationController {
	@Autowired
	LoanService loanService;

//	@PostMapping("/addLoan")
//	public ResponseEntity<String> addLoanApplication(@RequestBody LoanApplication loanApplication) {
//		return (loanService.addLoanApplication(loanApplication).equals("ok")) ? ResponseEntity.ok("saved")
//				: ResponseEntity.ok("Already exist");
//	}
	
	@PostMapping("/addLoan")
	public LoanApplication addLoanApplication(@RequestBody LoanApplication loan) {
		String result=loanService.addLoanApplication(loan);
		System.out.println(result);
		return loan;
	}
	
	@GetMapping("/viewAll")
	public List<LoanApplication> retrieveAllLoanApplication()
	{
		List<LoanApplication>loan=loanService.retrieveAllLoanApplication();
		return loan;
	}
	
	
	@GetMapping("/view/{loanId}")
	public LoanApplication retrieveLoanApplicationById(@PathVariable("loanId")long loanId) 
	{
		LoanApplication loanApplication=loanService.retrieveLoanApplicationById(loanId);
		return loanApplication;
	}
	
	@PutMapping("/update/{loanId}")
	public LoanApplication updateLoanApplication(@PathVariable("loanId")long loanId,@RequestBody LoanApplication loan) 
	{
		LoanApplication loanApp=loanService.updateLoanApplication(loanId,loan);
		return loanApp;
	}
	
	@DeleteMapping("delete/{loanId}")
	public LoanApplication deleteLoanApplication(@PathVariable("loanId")long loanId) 
	{
		return loanService.deleteLoanApplication(loanId);
	}


}
