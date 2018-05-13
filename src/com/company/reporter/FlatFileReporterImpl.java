package com.company.reporter;

import com.company.model.FlatFile;
import com.company.model.FlatFileReport;
import com.company.model.ModelFactory;
import com.company.model.Sale;
import com.company.model.Salesman;

public class FlatFileReporterImpl implements FlatFileReporter {
	
	@Override
	public FlatFileReport getReport(FlatFile flatFile) {
		
		final Integer amountOfCustomers = flatFile.getCustomerData().size();
		final Integer amountOfSalesmen = flatFile.getSalesmanData().size();
		final Sale mostExpensiveSale = flatFile.getMostExpensiveSale();
		final Salesman worstSalesmanEver = flatFile.getWorstSalesmanEver();
		
		final FlatFileReport flatFileReport = ModelFactory.newFlatFileReport(flatFile, amountOfCustomers, amountOfSalesmen, mostExpensiveSale, worstSalesmanEver);
		
		return flatFileReport;
	}
}
