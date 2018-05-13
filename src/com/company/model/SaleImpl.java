package com.company.model;

import java.util.ArrayList;
import java.util.List;

public class SaleImpl implements Sale {
	
	private Integer id;
	private final Salesman salesman;
	
	private final List<SaleItem> items;
	
	public SaleImpl(Integer id, List<SaleItem> items, Salesman salesman) {
		
		this.id = id;
		this.salesman = salesman;
		
		this.items = new ArrayList<>(items);
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
	
	@Override
	public Salesman getSalesman() {
		return this.salesman;
	}
	
	@Override
	public Float getSaleSum() {
		
		Float sum = 0.0f;
		for(SaleItem saleItem : this.items) {
			sum += saleItem.getTotalPrice();
		}
		return sum;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean equals = false;
		if(obj != null && obj instanceof SaleImpl) {
			final SaleImpl sale = (SaleImpl) obj;
			
			equals = this.id == sale.id &&
					 this.salesman.equals(sale.salesman) &&
					 this.items.equals(sale.items);
		}
		return equals;
	}
}
