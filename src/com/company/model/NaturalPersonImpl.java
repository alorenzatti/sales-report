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
	
	@Override
	public boolean equals(Object obj) {
		final boolean superEquals = super.equals(obj);
		
		boolean equals = false;
		if(obj != null && obj instanceof NaturalPersonImpl) {
			final NaturalPersonImpl naturalPerson = (NaturalPersonImpl) obj;
			
			equals = this.CPF.equals(naturalPerson.CPF);
		}
		return superEquals && equals;
	}
}
