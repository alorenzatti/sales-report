package com.company.model;

import java.util.List;

public class ModelFactory {
	
	public static Salesman newSalesman(String name, String CPF, Float salary) {
		return new SalesmanImpl(name, CPF, salary);
	}
	
	public static Customer newCustomer(String CNPJ, String name, String businessArea) {
		return new CustomerImpl(name, CNPJ, businessArea);
	}
	
	public static SaleItem newSaleItem(Integer id, Integer quantity, Float price) {
		return new SaleItemImpl(id, quantity, price);
	}
	
	public static Sale newSale(Integer id, List<SaleItem> saleItems, Salesman salesman) {
		return new SaleImpl(id, saleItems, salesman);
	}
	
	public static FlatFile newFlatFile(String name) {
		return new FlatFileImpl(name);
	}
	
	public static FlatFileReport newFlatFileReport(FlatFile flatFile, Integer amountOfCustomers, Integer amountOfSalesmen, Sale mostExpensiveSale, Salesman worstSalesmanEver) {
		return new FlatFileReportImpl(flatFile, amountOfCustomers, amountOfSalesmen, mostExpensiveSale, worstSalesmanEver);
	}
}
