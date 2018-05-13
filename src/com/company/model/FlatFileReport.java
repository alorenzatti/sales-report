package com.company.model;

public interface FlatFileReport {

	public FlatFile getFlatFile();
	
	public Integer getAmountOfCustomers();
	
	public Integer getAmountOfSalesmen();
	
	public Sale getMostExpensiveSale();
	
	public Salesman getWorstSalesmanEver();
}
