package command;


import model.Product;
import model.StoreFunc;

public class ShowAllProductsCommand implements Command {
	private StoreFunc sFunc;

	public ShowAllProductsCommand(StoreFunc sFunc) {
		this.sFunc = sFunc;
	}

	@Override
	public boolean deleteProductById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLast() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean readAllProducts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addProduct(String id, Product product) {
		return false;
	}

	@Override
	public String showAllProducts() {
		return sFunc.showAllProducts();

	}

	@Override
	public void sendSales(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMapSort(String choice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String showProduct(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCurrentAccepted() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ShowProfit() {
		// TODO Auto-generated method stub
		return null;
	}

}
