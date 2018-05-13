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
	
	@Override
	public boolean equals(Object obj) {
		
		boolean equals = false;
		if(obj != null && obj instanceof PersonImpl) {
			final PersonImpl person = (PersonImpl) obj;
			equals = this.name.equals(person.name);
		}
		return equals;
	}
}
