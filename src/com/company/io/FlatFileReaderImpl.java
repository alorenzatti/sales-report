package com.company.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.company.model.Customer;
import com.company.model.FlatFile;
import com.company.model.ModelFactory;
import com.company.model.Sale;
import com.company.model.SaleItem;
import com.company.model.Salesman;

class FlatFileReaderImpl implements FlatFileReader {
	
	private static final int SALESMAN_FORMAT = 001;
	private static final int CUSTOMER_FORMAT = 002;
	private static final int SALE_FORMAT = 003;
	
	private final String separator;
	
	public FlatFileReaderImpl(String separator) {
		super();
		
		this.separator = separator;
	}
	
	public FlatFile getFlatFile(Path flatFile) {
		
		final BufferedReader reader = this.init(flatFile);
		
		final FlatFile flatFileModel = this.processFlatFile(reader, flatFile);
		
		this.finish(reader);
		
		return flatFileModel;
	}
	
	private BufferedReader init(Path flatFile) {
		BufferedReader reader = null;
		try {
			reader = Files.newBufferedReader(flatFile);
		} catch(FileSystemException e) {
			e.printStackTrace();

		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return reader;
	}
	
	private void finish(BufferedReader reader) {
		try {
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private FlatFile processFlatFile(BufferedReader reader, Path flatFile) {
		final FlatFile flatFileModel = ModelFactory.newFlatFile(flatFile.getFileName().toString());

		try {
			while(reader.ready()) {
				final StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), this.separator);
				final Integer format = Integer.parseInt(tokenizer.nextToken());
				
				switch(format) {
					case SALESMAN_FORMAT: {
						final Salesman salesman = this.processSalesman(tokenizer);
						flatFileModel.addSalesman(salesman);
						break;
					}
					case CUSTOMER_FORMAT: {
						final Customer customer = this.processCustomer(tokenizer);
						flatFileModel.addCustomer(customer);
						break;
					}
					case SALE_FORMAT: {
						final Sale sale = this.processSale(tokenizer, flatFileModel);
						flatFileModel.addSale(sale);
						break;
					}
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return flatFileModel;
	}
	
	private Salesman processSalesman(StringTokenizer tokenizer) {
		final String CPF = tokenizer.nextToken();
		final String name = tokenizer.nextToken();
		final Float salary = Float.parseFloat(tokenizer.nextToken());
		
		return ModelFactory.newSalesman(name, CPF, salary);
	}
	
	private Customer processCustomer(StringTokenizer tokenizer) {
		final String CNPJ = tokenizer.nextToken();
		final String name = tokenizer.nextToken();
		final String businessArea = tokenizer.nextToken();
		
		return ModelFactory.newCustomer(CNPJ, name, businessArea);
	}
	
	private Sale processSale(StringTokenizer tokenizer, FlatFile flatFile) {
		final Integer id = Integer.parseInt(tokenizer.nextToken());
		final List<SaleItem> saleItems = this.processSalesItems(tokenizer.nextToken());
		final Salesman salesman = flatFile.getSalesmanByName(tokenizer.nextToken());
		
		return ModelFactory.newSale(id, saleItems, salesman);
	}
	
	private List<SaleItem> processSalesItems(String saleItemsStr) {
		
		saleItemsStr = saleItemsStr.substring(1, saleItemsStr.length() - 1);
		final List<SaleItem> saleItems = new ArrayList<>();
		
		final StringTokenizer tokenizer = new StringTokenizer(saleItemsStr, ",");
		while(tokenizer.hasMoreTokens()) {
			saleItems.add(this.processSaleItem(tokenizer.nextToken()));
		}
		return saleItems;
	}
	
	private SaleItem processSaleItem(String saleItemStr) {
		final StringTokenizer tokenizer = new StringTokenizer(saleItemStr, "-");
		
		final Integer id = Integer.parseInt(tokenizer.nextToken()); 
		final Integer quantity = Integer.parseInt(tokenizer.nextToken()); 
		final Float price = Float.parseFloat(tokenizer.nextToken()); 
				
		return ModelFactory.newSaleItem(id, quantity, price);
	}
}
