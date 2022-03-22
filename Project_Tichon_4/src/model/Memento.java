package model;

import java.util.Map;
import java.util.TreeMap;

public class Memento {
	
	private Map<String,Product> productsMap;
	
	public Memento(Map<String,Product> map) {
		this.productsMap = new TreeMap<String,Product>(map);
	}

	public Map<String,Product> getProductMap(){
		return productsMap;
	}
}
