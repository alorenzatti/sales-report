package com.company.model;

class SaleItemImpl implements SaleItem {
	
	private Integer id;
	private Integer quantity;
	private Float price;
	
	public SaleItemImpl(Integer id, Integer quantity, Float price) {
		super();
		
		this.id = id;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Integer getQuantity() {
		return this.quantity;
	}

	@Override
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public Float getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(Float price) {
		this.price = price;
	}
	
	@Override
	public Float getTotalPrice() {
		
		return this.quantity * this.price;
	}	
	
	@Override
	public boolean equals(Object obj) {
		
		boolean equals = false;
		if(obj != null && obj instanceof SaleItemImpl) {
			final SaleItemImpl saleItem = (SaleItemImpl) obj;

			equals = this.id == saleItem.id &&
					 this.quantity == saleItem.quantity &&
					 Math.abs(this.price - saleItem.price) < 0.001f;
		}
		return equals;
	}
}
