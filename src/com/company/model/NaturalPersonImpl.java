package com.company.model;

class NaturalPersonImpl extends PersonImpl {
	
	private String CPF;
	
	public NaturalPersonImpl(String name, String CPF) {
		super(name);
		
		this.CPF = CPF;
	}
	
	@Override
	public String getRegistration() {
		return this.CPF;
	}
	
	@Override
	public void setRegistration(String registration) {
		this.CPF = registration;
	}
}
