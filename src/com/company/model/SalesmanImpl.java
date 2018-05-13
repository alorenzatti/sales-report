package com.company.model;

class SalesmanImpl extends NaturalPersonImpl implements Salesman {
	
	private Float salary;
	
	public SalesmanImpl(String name, String CPF, Float salary) {
		super(name, CPF);
		
		this.salary = salary;
	}
	@Override
	public Float getSalary() {
		return this.salary;
	}
	
	@Override
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	@Override
	public boolean equals(Object obj) {
		final boolean superEquals = super.equals(obj);
		
		boolean equals = false;
		if(obj != null && obj instanceof SalesmanImpl) {
			final SalesmanImpl salesman = (SalesmanImpl) obj;
			
			equals = Math.abs(this.salary - salesman.salary) < 0.001f;
		}
		
		return superEquals && equals;
	}
}
