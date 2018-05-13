package com.company.reporter;

import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.io.FlatFileReader;
import com.company.io.IOFactory;
import com.company.model.FlatFile;
import com.company.model.FlatFileReport;

public class FlatFileReporterTest {
	
	private FlatFileReporter flatFileReporter;
	
	private FlatFile flatFile;
	private FlatFile flatFileEquals;
	private FlatFile flatFileNotEquals;
	
	@Before
	public void setup() {
		
		final FlatFileReader flatFileReader = IOFactory.newFlatFileReader("ç");
		this.flatFile = flatFileReader.getFlatFile(Paths.get("C:/Test/in/flatfile.dat"));
		this.flatFileEquals = flatFileReader.getFlatFile(Paths.get("C:/Test/in/flatfile_equals.dat"));
		this.flatFileNotEquals = flatFileReader.getFlatFile(Paths.get("C:/Test/in/flatfile_not_equals.dat"));
		
		this.flatFileReporter = ReporterFactory.newFlatFileReporter();
	}
	
	@Test
	public void testGetReport() {
		
		final FlatFileReport flatFileReport = this.flatFileReporter.getReport(this.flatFile);
		Assert.assertNotNull(flatFileReport);
		
		final FlatFileReport flatFileEqualsReport = this.flatFileReporter.getReport(this.flatFileEquals);
		Assert.assertNotNull(flatFileEqualsReport);
		
		Assert.assertTrue(flatFileReport.equals(flatFileEqualsReport));
		
		final FlatFileReport flatFileNotEqualsReport = this.flatFileReporter.getReport(this.flatFileNotEquals);
		Assert.assertNotNull(flatFileNotEqualsReport);
		
		Assert.assertFalse(flatFileReport.equals(flatFileNotEqualsReport));
	}

}
