package com.company.io;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.company.model.Customer;
import com.company.model.FlatFile;
import com.company.model.ModelFactory;
import com.company.model.Sale;
import com.company.model.SaleItem;
import com.company.model.Salesman;

public class FlatFileReaderTest {
	
	private FlatFileReader flatFileReader;
	
	private FlatFile flatFile;
	
	@Before
	public void setup() {
		
		this.flatFileReader = IOFactory.newFlatFileReader("ç");
		
		this.flatFile = ModelFactory.newFlatFile("mockflatfile.dat");
		
		final Salesman diego = ModelFactory.newSalesman("Diego", "1234567891234", 50000f);
		this.flatFile.addSalesman(diego);
		final Salesman renato = ModelFactory.newSalesman("Renato", "3245678865434", 40000.99f);
		this.flatFile.addSalesman(renato);
		
		this.flatFile.addCustomer(ModelFactory.newCustomer("2345675434544345", "Jose da Silva", "Rural"));
		this.flatFile.addCustomer(ModelFactory.newCustomer("2345675433444345", "Eduardo Pereira", "Rural"));
		
		final List<SaleItem> saleDiegoItems = new ArrayList<>();
		saleDiegoItems.add(ModelFactory.newSaleItem(1, 10, 100f));
		saleDiegoItems.add(ModelFactory.newSaleItem(2, 30, 2.5f));
		saleDiegoItems.add(ModelFactory.newSaleItem(3, 40, 3.1f));
		final Sale saleDiego = ModelFactory.newSale(10, saleDiegoItems, diego);
		this.flatFile.addSale(saleDiego);
		
		final List<SaleItem> saleRenatoItems = new ArrayList<>();
		saleRenatoItems.add(ModelFactory.newSaleItem(1, 34, 10f));
		saleRenatoItems.add(ModelFactory.newSaleItem(2, 33, 1.5f));
		saleRenatoItems.add(ModelFactory.newSaleItem(3, 40, 0.1f));
		final Sale saleRenato = ModelFactory.newSale(8, saleRenatoItems, renato);
		this.flatFile.addSale(saleRenato);
	}
	
	@Test
	public void testGetFlatFile() {
		
		final FlatFile flatFile = this.flatFileReader.getFlatFile(Paths.get("C:/Test/in/flatfile.dat"));
		Assert.assertNotNull(flatFile);
		
//		this.printFlatFile(this.flatFile);
//		this.printFlatFile(flatFile);
		
		Assert.assertTrue(this.flatFile.equals(flatFile));
	}
	
	private void printFlatFile(FlatFile flatFile) {
		
		System.out.println(String.format("FLATFILE: %s", flatFile.getName()));
		
		for(Salesman salesman : flatFile.getSalesmanData()) {
			System.out.println(String.format("SALESMAN: %s, %s, %.2f", salesman.getName(), salesman.getRegistration(), salesman.getSalary()));
		}
		
		for(Customer customer : flatFile.getCustomerData()) {
			System.out.println(String.format("CUSTOMER: %s, %s, %s", customer.getName(), customer.getRegistration(), customer.getBusinessArea()));
		}
		
		for(Sale sale : flatFile.getSalesData()) {
			System.out.print(String.format("SALE: %s [ ", sale.getId()));
			
			for(SaleItem saleItem : sale.getItems()) {
				
				System.out.print(String.format("%d-%d-%.2f ", saleItem.getId(), saleItem.getQuantity(), saleItem.getPrice()));
			}
			System.out.println(String.format("],%s", sale.getSalesman().getName()));
		}
	}
}
