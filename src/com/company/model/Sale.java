package com.company.model;

import java.util.List;

public interface Sale {

	public Integer getId();
	
	public List<SaleItem> getItems();
	
	public void addItem(SaleItem item);
	
	public Salesman getSalesman();
}
