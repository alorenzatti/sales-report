package com.company.model;

public class ModelFactory {
	
	public static Salesman newSalesman(String CPF, String name, Float salary) {
		return new SalesmanImpl(name, CPF, salary);
	}
	
	public static Customer newCustomer(String CNPJ, String name, String businessArea) {
		return new CustomerImpl(name, CNPJ, businessArea);
	}
	
	public static SaleItem newSaleItem(Integer id, Integer quantity, Float price) {
		return new SaleItemImpl(id, quantity, price);
	}
	
	public static Sale newSale(Integer id, Salesman salesman) {
		return new SaleImpl(id, salesman);
	}

}
