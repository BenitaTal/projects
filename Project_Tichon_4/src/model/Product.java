package model;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Product {
	private String name;
	private int storePrice;
	private int customerPrice;
	private Customer productCustomer;
	private int profit;

	public int getProfit() {
		return profit;
	}

	public Product() {
		this.name = "";
		this.storePrice = 0;
		this.customerPrice = 0;
		this.productCustomer = null;
		this.profit = 0;
	}

	public Product(String name, int storePrice, int customerPrice, Customer productCustomer) {
		if (setStorePrice(storePrice) && setCustomerPrice(customerPrice) && setProductCustomer(productCustomer)) {
			this.name = name;
		}
	}
	
	public boolean setAllValues(String name, int storePrice, int customerPrice, Customer productCustomer) {
		if (setStorePrice(storePrice) && setCustomerPrice(customerPrice) && setProductCustomer(productCustomer)) {
			this.name = name;
			this.profit = storePrice - customerPrice;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "==>  Product:  " + name + " , Store Price:  " + storePrice + " , Customer Price:  " + customerPrice
				+ "\n" + productCustomer + "\n";
	}

	// create product from file
	public Product(RandomAccessFile raf) {
		try {
			this.name = raf.readUTF();
			this.storePrice = raf.readInt();
			this.customerPrice = raf.readInt();
			this.productCustomer = new Customer(raf);
			this.profit = storePrice - customerPrice;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStorePrice() {
		return storePrice;
	}

	public boolean setStorePrice(int storePrice) {
		if (storePrice < 0) {
			return false;
		} else {
			this.storePrice = storePrice;
			return true;
		}
	}

	public int getCustomerPrice() {
		return customerPrice;
	}

	public boolean setCustomerPrice(int customerPrice) {
		if (customerPrice < 0) {
			return false;
		} else {
			this.customerPrice = customerPrice;
			return true;
		}
	}

	public Customer getProductCustomer() {
		return productCustomer;
	}

	public boolean setProductCustomer(Customer productCustomer) {

		if (productCustomer != null) {
			this.productCustomer = productCustomer;
			return true;
		}
		return false;
	}

	public boolean writeProductToBinFile(RandomAccessFile raf) {
		try {
			raf.writeUTF(name);
			raf.writeInt(storePrice);
			raf.writeInt(customerPrice);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		if (productCustomer.writeCustomerToBinFile(raf))
			return true;
		return false;
	}

	public boolean readProductFromBinFile(RandomAccessFile raf) {
		try {
			raf.writeUTF(name);
			raf.writeInt(storePrice);
			raf.writeInt(customerPrice);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		if (productCustomer.writeCustomerToBinFile(raf))
			return true;
		return false;
	}
}
