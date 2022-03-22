package command;


import model.Product;
import model.StoreFunc;

public class RemoveByIdCommand implements Command {
	private StoreFunc storeFunc;

	public RemoveByIdCommand(StoreFunc sFunc) {
		storeFunc = sFunc;
	}

	@Override
	public boolean deleteProductById(String id) {
		if (storeFunc.deleteProductFromFile(id))
			return true;
		return false;
	}

	@Override
	public boolean deleteLast() {

		return false;
	}

	@Override
	public boolean deleteAll() {

		return false;
	}

	@Override
	public boolean addProduct(String id, Product product) {
		return false;
	}

	@Override
	public boolean readAllProducts() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String showAllProducts() {
		// TODO Auto-generated method stub
		return "";
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
