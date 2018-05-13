package com.company.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.company.model.FlatFileReport;

class FlatFileReportWriterImpl implements FlatFileReportWriter {

	@Override
	public void writeFlatFileReport(FlatFileReport flatFileReport, File outDirectory) {
		
		String flatFileName = flatFileReport.getFlatFile().getName();
		flatFileName = flatFileName.substring(0, flatFileName.length() - 4);
		flatFileName = flatFileName + ".done.dat";
		
		final File outFile = new File(outDirectory, flatFileName);
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
			
			writer.write(String.format("Amount of clients: %d\n", flatFileReport.getAmountOfCustomers()));
			writer.write(String.format("Amount of salesman: %d\n", flatFileReport.getAmountOfSalesmen()));
			writer.write(String.format("Most expensive sale ID: %d\n", flatFileReport.getMostExpensiveSale().getId()));
			writer.write(String.format("Worst salesman ever: %s\n", flatFileReport.getWorstSalesmanEver().getName()));
			writer.flush();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
