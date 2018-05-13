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
}
