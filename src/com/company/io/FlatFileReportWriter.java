package com.company.io;

import java.io.File;

import com.company.model.FlatFileReport;

public interface FlatFileReportWriter {

	public void writeFlatFileReport(FlatFileReport flatFileReport, File outDirectory);
}
