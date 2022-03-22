package model;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import observer.Observable;
import observer.Observer;

public class StoreFunc implements Observable {
	private Map<String, Product> myMap;
	private final String FILENAME = "products.txt";
	private List<Observer> customers;
	private Memento mapLastPos;
	private List<String> acceptedCustomerNames;
	private int currentAccepted = -1;
	private int totalProfit;

	public StoreFunc() {
		customers = new ArrayList<Observer>();
	}

	public List<String> getAcceptedCustomerNames() {
		return acceptedCustomerNames;
	}

	public void setAcceptedCustomerNames(List<String> acceptedCustomerNames) {
		this.acceptedCustomerNames = acceptedCustomerNames;
	}

	public Memento getMapLastPos() {
		return mapLastPos;
	}

	public List<Observer> getCustomers() {
		return customers;
	}

	public void setMyMap(String choice) {
		switch (choice) {
		case "Ascend":
			myMap = new TreeMap<String, Product>(new compareByUp());
			break;
		case "Descend":
			myMap = new TreeMap<String, Product>(new compareByDown());
			break;
		case "Insert":
			myMap = new LinkedHashMap<String, Product>();
			break;
		}
	}

	public String getFILENAME() {
		return FILENAME;
	}

	public Map<String, Product> getMyMap() {
		return myMap;
	}

	public boolean addProductsToFile() {
		try {
			RandomAccessFile raf = new RandomAccessFile(FILENAME, "rw");
			for (Map.Entry<String, Product> entry : myMap.entrySet()) {
				raf.writeUTF(entry.getKey());
				entry.getValue().writeProductToBinFile(raf);
			}
			raf.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addProductToMap(String id, Product product) {
		mapLastPos = new Memento(getMyMap());
		getMyMap().put(id, product);
		if (product.getProductCustomer().isInterested())
			getCustomers().add(product.getProductCustomer());
		return addProductsToFile();
	}

	public boolean readProductsFromFile() {
		try {
			boolean is1st;
			ProductEntry entry;
			fileIterator fIterator = new fileIterator(FILENAME);
			if (fIterator.isEmpty()) {
				fIterator.getRaf().close();
				return false;
			}
			while (fIterator.hasNext()) {
				is1st = false;
				entry = new ProductEntry((ProductEntry) fIterator.next());
				if (!getMyMap().containsValue(entry.getValue()))
					is1st = true;
				getMyMap().put(entry.getKey(), entry.getValue());
				if (entry.getValue().getProductCustomer().isInterested() && is1st)
					getCustomers().add(entry.getValue().getProductCustomer());
			}
			fIterator.getRaf().close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String showProductFromFile(String id) {
		ProductEntry entry = getProductFromFile(id);
		if (entry != null)
			return entry.toString();
		else
			return "no product found";

	}

	public ProductEntry getProductFromFile(String id) {
		try {
			ProductEntry entry;
			fileIterator fIterator = new fileIterator(FILENAME);
			if (fIterator.isEmpty()) {
				fIterator.getRaf().close();
				return null;
			}
			while (fIterator.hasNext()) {
				entry = new ProductEntry((ProductEntry) fIterator.next());
				if (entry.getKey().equals(id)) {
					return entry;
				}
			}
			fIterator.getRaf().close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteProductFromFile(String id) {
		try {
			ProductEntry entry;
			fileIterator fIterator = new fileIterator(FILENAME);
			if (fIterator.isEmpty()) {
				fIterator.getRaf().close();
				return false;
			}
			while (fIterator.hasNext()) {
				entry = new ProductEntry((ProductEntry) fIterator.next());
				if (entry.getKey().equals(id)) {
					fIterator.remove();
					getMyMap().remove(id);
					fIterator.getRaf().close();
					return true;
				}
			}
			fIterator.getRaf().close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteLastProductFromFile() {
		try {
			ProductEntry entry = null;
			fileIterator fIterator = new fileIterator(FILENAME);
			if (fIterator.isEmpty()) {
				fIterator.getRaf().close();
				return false;
			}
			while (fIterator.hasNext())
				entry = new ProductEntry((ProductEntry) fIterator.next());
			fIterator.remove();
			if (entry.getValue().getProductCustomer().isInterested()) {
				customers.remove(entry.getValue().getProductCustomer());
			}
			// memento
			myMap = getMapLastPos().getProductMap();
			fIterator.getRaf().close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAllProductsFromFile() {
		try {
			ProductEntry entry = null;
			fileIterator fIterator = new fileIterator(FILENAME);
			if (fIterator.isEmpty()) {
				fIterator.getRaf().close();
				return false;
			}
			while (fIterator.hasNext()) {
				entry = new ProductEntry((ProductEntry) fIterator.next());
				fIterator.remove();
				customers.remove(entry.getValue().getProductCustomer());
				getMyMap().remove(entry.getKey());
			}
			fIterator.setCurrentPos(0);
			if (fIterator.getRaf().length() != 0) {
				entry = new ProductEntry((ProductEntry) fIterator.next());
				getMyMap().remove(entry.getKey());
				customers.remove(entry.getValue().getProductCustomer());
				fIterator.remove();
			}
			fIterator.getRaf().close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String showAllProducts() {
		StringBuffer sb = new StringBuffer();

		for (Map.Entry<String, Product> entry : myMap.entrySet()) {
			sb.append(entry.toString() + "\n");
		}
		return sb.toString();
	}

	public void sendSale(String msg) {
		notifyObservers();
	}

	@Override
	public void addObserver(Observer obs) {
		customers.add(obs);

	}

	@Override
	public void deleteObserver(Observer obs) {
		customers.remove(obs);

	}

	@Override
	public void notifyObservers() {
		acceptedCustomerNames = new ArrayList<String>();
		for (Observer observer : customers) {

			acceptedCustomerNames.add(observer.update(this));
		}
	}

	public String currentAccepted() {
		setCurrentAccepted(getCurrentAccepted() + 1);
		if (currentAccepted < acceptedCustomerNames.size())
			return acceptedCustomerNames.get(currentAccepted).toString();
		setCurrentAccepted(-1);
		acceptedCustomerNames.clear();
		return null;
	}

	public int getCurrentAccepted() {
		return currentAccepted;
	}

	public void setCurrentAccepted(int currentAccepted) {
		this.currentAccepted = currentAccepted;
	}
	
	public String getProfit() {
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (Map.Entry<String, Product> entry : myMap.entrySet()) {
			sb.append(entry.getValue().getName() + ":");
			sb.append(entry.getValue().getProfit() + "\n");
			sum+=entry.getValue().getProfit();
		}
		sb.append("Total Profit = "+ sum+"\n");
		return sb.toString();
		 
	}

}
