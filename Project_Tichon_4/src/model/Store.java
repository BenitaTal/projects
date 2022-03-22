package model;


import command.StoreCommand;

public class Store {
	private static Store _instance = null;
	private StoreCommand storeCommand;
	
	public static Store getInstance() {
		if(_instance==null)
			_instance = new Store();
		return _instance;
	}
	
	public Store() {
		storeCommand = new StoreCommand();
	}
	
	public StoreCommand getStoreCommand() {
		return storeCommand;
	}
	
}