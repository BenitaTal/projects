package command;

import model.Product;
import model.StoreFunc;

public class StoreCommand {
	private Command removeProductByIdCommand;
	private Command removeLastProductCommand;
	private Command removeAllProductsCommand;
	private Command addProductCommand;
	private Command showProductsCommand;
	private Command readProductsFromFileCommand;
	private Command sendSalesCommand;
	private Command setMapSortCommand;
	private Command showProductByIdCommand;
	private Command getCurrentAcceptedCommand;
	private Command	getProfitCommand;

	public StoreCommand() {
		StoreFunc storeFunc = new StoreFunc();
		removeProductByIdCommand = new RemoveByIdCommand(storeFunc);
		removeLastProductCommand = new RemoveLastCommand(storeFunc);
		removeAllProductsCommand = new RemoveAllCommand(storeFunc);
		addProductCommand = new AddProductCommand(storeFunc);
		showProductsCommand = new ShowAllProductsCommand(storeFunc);
		readProductsFromFileCommand = new ReadProductsFromFileCommand(storeFunc);
		sendSalesCommand = new SendSalesCommand(storeFunc);
		setMapSortCommand = new SetMapSortCommand(storeFunc);
		showProductByIdCommand = new ShowProductByIdCommad(storeFunc);
		getCurrentAcceptedCommand = new getCurrentAcceptedCommand(storeFunc);
		getProfitCommand = new getProfit(storeFunc);
	}

	public boolean removeProductByIdCommand(String id) {
		return removeProductByIdCommand.deleteProductById(id);
	}

	public boolean removeLastProductCommand() {
		return removeLastProductCommand.deleteLast();
	}

	public boolean removeAllProductsCommand() {
		return removeAllProductsCommand.deleteAll();
	}

	public boolean addProductCommand(String id, Product product) {
		return addProductCommand.addProduct(id, product);
	}

	public String showProductsCommand() {
		return showProductsCommand.showAllProducts();
	}
	
	public String showProductByIdCommand(String id) {
		return showProductByIdCommand.showProduct(id);
	}

	public String getCurrentAcceptedCommand() {
		return getCurrentAcceptedCommand.getCurrentAccepted();
	}
	
	public boolean readProductsFromFileCommand() {
		return readProductsFromFileCommand.readAllProducts();
	}
	
	public void sendSaleCommand(String msg) {
		sendSalesCommand.sendSales(msg);
	}
	
	public void setMapSortCommand(String choice) {
		setMapSortCommand.setMapSort(choice);
	}
	
	public String getProfit() {
		return getProfitCommand.ShowProfit();
	}

}
