package com.company.io;

public class IOFactory {
	
	public static FlatFileReader newFlatFileReader(String separator) {
		return new FlatFileReaderImpl(separator);
	}
	
	public static FlatFileReportWriter newFlatFileReportWriter() {
		return new FlatFileReportWriterImpl();
	}
}
