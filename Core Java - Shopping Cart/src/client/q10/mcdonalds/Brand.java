package client.q10.mcdonalds;

import java.util.ArrayList;

public class Brand {
	
	private String brandName;
	private ArrayList<Product> productList;
	
	public Brand(String brandName, ArrayList<Product> productList) {
		this.setBrandName(brandName);
		this.setProductList(productList);
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

}
