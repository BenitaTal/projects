package model;
import java.util.Map.Entry;

public class ProductEntry implements Entry<String, Product>{
	private String String;
	private Product Product;
	
	public ProductEntry(String id,Product product) {
		this.String = id;
		this.Product = product;
	}
	
	public ProductEntry(ProductEntry other) {
		this.String = other.getKey();
		this.Product = other.getValue();
	}
	
	@Override
	public String getKey() {
		return this.String;
	}

	@Override
	public Product getValue() {
		return this.Product;
	}

	@Override
	public Product setValue(Product value) {
		Product toDelete = this.Product;
		this.Product = value;
		return toDelete;
	}

}
