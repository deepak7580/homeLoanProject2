package com.cg.springboot.calculate;

public class HomeLoanBorrowingAmountCalculator {
	
	private double totalAnnualIncome;
	private double monthlyExpenses;
	private double otherMonthlyExpenses;
	
	
	public double getTotalAnnualIncome() {
		return totalAnnualIncome;
	}
	public void setTotalAnnualIncome(double totalAnnualIncome) {
		this.totalAnnualIncome = totalAnnualIncome;
	}
	public double getMonthlyExpenses() {
		return monthlyExpenses;
	}
	public void setMonthlyExpenses(double monthlyExpenses) {
		this.monthlyExpenses = monthlyExpenses;
	}
	public double getOtherMonthlyExpenses() {
		return otherMonthlyExpenses;
	}
	public void setOtherMonthlyExpenses(double otherMonthlyExpenses) {
		this.otherMonthlyExpenses = otherMonthlyExpenses;
	}
	
	
	@Override
	public String toString() {
		return "HomeLoanBorrowingAmountCalculator [totalAnnualIncome=" + totalAnnualIncome + ", monthlyExpenses="
				+ monthlyExpenses + ", otherMonthlyExpenses=" + otherMonthlyExpenses + "]";
	}
	
	
	public HomeLoanBorrowingAmountCalculator(double totalAnnualIncome, double monthlyExpenses,
			double otherMonthlyExpenses) {
		super();
		this.totalAnnualIncome = totalAnnualIncome;
		this.monthlyExpenses = monthlyExpenses;
		this.otherMonthlyExpenses = otherMonthlyExpenses;
	}
	
	
	public HomeLoanBorrowingAmountCalculator() {
		super();
	}
	
	public double getHomeLoanBorrowingAmount() {
		return (totalAnnualIncome-(monthlyExpenses+otherMonthlyExpenses));  //return the amount(then this amount will be subtracted
		//by the applied amount.) then this calculated amount will be updated in the approved amount field in 
		//loan application--emi--emi calculator
	}


}
