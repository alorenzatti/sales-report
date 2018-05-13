package com.company.reporter;

import com.company.model.FlatFile;
import com.company.model.FlatFileReport;

public interface FlatFileReporter {
	
	public FlatFileReport getReport(FlatFile flatFile);
}
