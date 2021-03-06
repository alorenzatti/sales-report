package com.company.io;

import java.io.File;
import java.nio.file.Paths;

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
		
		final FlatFile flatFile = flatFileReader.getFlatFile(Paths.get("data/in/flatfile.dat"));
		this.flatFileReport = flatFileReporter.getReport(flatFile);
		
		final FlatFile flatFileNotEquals = flatFileReader.getFlatFile(Paths.get("data/in/flatfile_not_equals.dat"));
		this.flatFileNotEqualsReport = flatFileReporter.getReport(flatFileNotEquals);
		
		this.flatFileReportWriter = IOFactory.newFlatFileReportWriter();
	}
	
	@Test
	public void writeFlatFileReport() {
		
		this.flatFileReportWriter.writeFlatFileReport(this.flatFileReport, new File("data/out"));
		this.flatFileReportWriter.writeFlatFileReport(this.flatFileNotEqualsReport, new File("data/out"));
	}

}
