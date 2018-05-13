package com.company.model;

abstract class PersonImpl implements Person {
	
	private String name;
	
	public PersonImpl(String name) {
		super();
		
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
