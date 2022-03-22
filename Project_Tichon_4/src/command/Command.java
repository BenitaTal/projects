package command;

import model.Product;

public interface Command {
	boolean deleteProductById(String id);
	boolean deleteLast();
	boolean deleteAll();
	boolean addProduct(String id, Product product);
	boolean readAllProducts();
	String 	showAllProducts();
	String 	showProduct(String id);
	void	sendSales(String msg);
	void 	setMapSort(String choice);
	String 	getCurrentAccepted();
	String  ShowProfit();
}
