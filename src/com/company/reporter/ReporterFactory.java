package com.company.reporter;

public class ReporterFactory {
	
	public static FlatFileReporter newFlatFileReporter() {
		return new FlatFileReporterImpl();
	}
}
