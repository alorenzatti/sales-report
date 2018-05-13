package com.company.io;

import java.nio.file.FileSystemException;
import java.nio.file.Path;

import com.company.model.FlatFile;

public interface FlatFileReader {
	
	public FlatFile getFlatFile(Path flatFile);
}
