package com.company.model;

class JuridicalPersonImpl extends PersonImpl {
	
	private String CNPJ;
	
	public JuridicalPersonImpl(String name, String CNPJ) {
		super(name);
		
		this.CNPJ = CNPJ;
	}
	
	@Override
	public String getRegistration() {
		return this.CNPJ;
	}
	
	@Override
	public void setRegistration(String registration) {
		this.CNPJ = registration;
	}
}
