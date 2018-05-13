package com.company.model;

import java.util.ArrayList;
import java.util.List;

class FlatFileImpl implements FlatFile {
	
	private final List<Salesman> salesmans;
	private final List<Customer> customers;
	private final List<Sale> sales;
	
	public FlatFileImpl() {
		super();
		
		this.salesmans = new ArrayList<>();
		this.customers = new ArrayList<>();
		this.sales = new ArrayList<>();
	}
	
	@Override
	public List<Salesman> getSalesmanData() {
		return new ArrayList<>(this.salesmans);
	}
	
	@Override
	public Salesman getSalesmanByName(String name) {
		
		for(Salesman salesman : salesmans) {
			if(salesman.getName().equals(name)) {
				return salesman;
			}
		}
		return null;
	}

	@Override
	public void addSalesman(Salesman salesman) {
		this.salesmans.add(salesman);
	}

	@Override
	public List<Customer> getCustomerData() {
		return new ArrayList<>(this.customers);
	}

	@Override
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}

	@Override
	public List<Sale> getSalesData() {
		return new ArrayList<>(this.sales);
	}

	@Override
	public void addSale(Sale sale) {
		this.sales.add(sale);
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean equals = false;
		if(obj != null && obj instanceof FlatFileImpl) {
			final FlatFileImpl flatFile = (FlatFileImpl) obj;
			
			equals = this.salesmans.equals(flatFile.salesmans) &&
					 this.customers.equals(flatFile.customers) &&
					 this.sales.equals(flatFile.sales);
		}
		return equals;
	}
}