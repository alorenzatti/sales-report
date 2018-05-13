package com.company.model;

class CustomerImpl extends JuridicalPersonImpl implements Customer {
	
	private String businessArea;
	
	public CustomerImpl(String name, String CNPJ, String businessArea) {
		super(name, CNPJ);
		
		this.businessArea = businessArea;
	}
	
	@Override
	public String getBusinessArea() {
		return this.businessArea;
	}
	
	@Override
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
}
