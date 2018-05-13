package com.company.io;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.company.model.FlatFile;
import com.company.model.FlatFileReport;
import com.company.reporter.FlatFileReporter;
import com.company.reporter.ReporterFactory;

public class FlatFileReportWriterTest {
	
	private FlatFileReportWriter flatFileReportWriter;
	
	private FlatFileReport flatFileReport;
	private FlatFileReport flatFileNotEqualsReport; 
	
	@Before
	public void setup() {
		
		
		final FlatFileReader flatFileReader = IOFactory.newFlatFileReader("ç");
		final FlatFileReporter flatFileReporter = ReporterFactory.newFlatFileReporter();
		
		final FlatFile flatFile = flatFileReader.getFlatFile(new File("C:/Test/in/flatfile.dat"));
		this.flatFileReport = flatFileReporter.getReport(flatFile);
		
		final FlatFile flatFileNotEquals = flatFileReader.getFlatFile(new File("C:/Test/in/flatfile_not_equals.dat"));
		this.flatFileNotEqualsReport = flatFileReporter.getReport(flatFileNotEquals);
		
		this.flatFileReportWriter = IOFactory.newFlatFileReportWriter();
	}
	
	@Test
	public void writeFlatFileReport() {
		
		this.flatFileReportWriter.writeFlatFileReport(this.flatFileReport, new File("C:/Test/out"));
		this.flatFileReportWriter.writeFlatFileReport(this.flatFileNotEqualsReport, new File("C:/Test/out"));
	}

}
