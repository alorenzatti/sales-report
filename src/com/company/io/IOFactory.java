package com.company.io;

public class IOFactory {
	
	public static FlatFileReader newFlatFileReader(String separator) {
		return new FlatFileReaderImpl(separator);
	}
}
