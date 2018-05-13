package com.company.io;

import java.io.File;

public class IOFactory {
	
	public static FlatFileReader newFlatFileReader(File flatFile) {
		return new FlatFileReaderImpl("ç", flatFile);
	}
}
