package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class SaleImpl implements Sale {
	
	private Integer id;
	private final Salesman salesman;
	
	private final List<SaleItem> items;
	
	public SaleImpl(Integer id, Salesman salesman) {
		
		this.id = id;
		this.salesman = salesman;
		
		this.items = new ArrayList<>();
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}
	
	@Override
	public void addItem(SaleItem item) {
		this.items.add(item);
	}
	
	@Override
	public List<SaleItem> getItems() {
		return new ArrayList<>(this.items);
	}
}
