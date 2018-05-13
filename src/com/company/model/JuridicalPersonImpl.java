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
	
	@Override
	public boolean equals(Object obj) {
		final boolean superEquals = super.equals(obj);
		
		boolean equals = false;
		if(obj != null && obj instanceof JuridicalPersonImpl) {
			final JuridicalPersonImpl juridicalPerson = (JuridicalPersonImpl) obj;

			equals = this.CNPJ.equals(juridicalPerson.CNPJ);
		}
		return superEquals && equals;
	}
}
