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
	
	@Override
	public boolean equals(Object obj) {
		final boolean superEquals = super.equals(obj);
		
		boolean equals = false;
		if(obj != null && obj instanceof CustomerImpl) {
			final CustomerImpl customer = (CustomerImpl) obj;
			
			equals = this.businessArea.equals(customer.businessArea);
		}
		return superEquals && equals;
	}
}
