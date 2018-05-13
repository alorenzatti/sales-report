package com.company.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	
	private final File flatFile;
	
	public FlatFileReaderImpl(String separator, File flatFile) {
		super();
		
		this.separator = separator;
		this.flatFile = flatFile;
	}
	
	public FlatFile getFlatFile() {
		return this.processFlatFile(this.init());
	}
	
	private BufferedReader init() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(this.flatFile));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return reader;
	}
	
	private FlatFile processFlatFile(BufferedReader reader) {
		final FlatFile flatFile = ModelFactory.newFlatFile(this.flatFile.getName());

		try {
			while(reader.ready()) {
				final StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), this.separator);
				final Integer format = Integer.parseInt(tokenizer.nextToken());
				
				switch(format) {
					case SALESMAN_FORMAT: {
						final Salesman salesman = this.processSalesman(tokenizer);
						flatFile.addSalesman(salesman);
						break;
					}
					case CUSTOMER_FORMAT: {
						final Customer customer = this.processCustomer(tokenizer);
						flatFile.addCustomer(customer);
						break;
					}
					case SALE_FORMAT: {
						final Sale sale = this.processSale(tokenizer, flatFile);
						flatFile.addSale(sale);
						break;
					}
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return flatFile;
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
