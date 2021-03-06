package com.company.model;

import java.util.List;

public interface FlatFile {
	
	public String getName();

	public List<Salesman> getSalesmanData();
	
	public Salesman getSalesmanByName(String name);
	
	public Salesman getWorstSalesmanEver();
	
	public void addSalesman(Salesman salesman);
	
	public List<Customer> getCustomerData();
	
	public void addCustomer(Customer customer);
	
	public List<Sale> getSalesData();
	
	public Sale getMostExpensiveSale();
	
	public void addSale(Sale sale);
}
