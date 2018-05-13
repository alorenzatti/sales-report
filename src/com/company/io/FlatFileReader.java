package com.company.io;

import java.io.File;

import com.company.model.FlatFile;

public interface FlatFileReader {
	
	public FlatFile getFlatFile(File flatFile);
}
