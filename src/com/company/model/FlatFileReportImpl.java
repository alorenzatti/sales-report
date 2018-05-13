package com.company.model;

class FlatFileReportImpl implements FlatFileReport {
	
	private final FlatFile flatFile;
	private final Integer amountOfCustomers;
	private final Integer amountOfSalesmen;
	private final Sale mostExpensiveSale;
	private final Salesman worstSalesmanEver;
	
	public FlatFileReportImpl(FlatFile flatFile, Integer amountOfCustomers, Integer amountOfSalesmen, Sale mostExpensiveSale, Salesman worstSalesmanEver) {
		super();
		
		this.flatFile = flatFile;
		this.amountOfCustomers = amountOfCustomers;
		this.amountOfSalesmen = amountOfSalesmen;
		this.mostExpensiveSale = mostExpensiveSale;
		this.worstSalesmanEver = worstSalesmanEver;
	}
	
	@Override
	public FlatFile getFlatFile() {
		return this.flatFile;
	}

	@Override
	public Integer getAmountOfCustomers() {
		return this.amountOfCustomers;
	}

	@Override
	public Integer getAmountOfSalesmen() {
		return this.amountOfSalesmen;
	}

	@Override
	public Sale getMostExpensiveSale() {
		return this.mostExpensiveSale;
	}

	@Override
	public Salesman getWorstSalesmanEver() {
		return this.worstSalesmanEver;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean equals = false;
		if(obj != null && obj instanceof FlatFileReportImpl) {
			final FlatFileReportImpl flatFileReport = (FlatFileReportImpl) obj;
			
			equals = this.amountOfCustomers == flatFileReport.amountOfCustomers &&
					 this.amountOfSalesmen == flatFileReport.amountOfSalesmen &&
					 this.mostExpensiveSale.equals(flatFileReport.mostExpensiveSale) &&
					 this.worstSalesmanEver.equals(flatFileReport.worstSalesmanEver);
		}
		return equals;
	}

}
