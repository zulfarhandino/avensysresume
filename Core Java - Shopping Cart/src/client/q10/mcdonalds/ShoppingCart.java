package client.q10.mcdonalds;

import java.util.LinkedHashMap;

public class ShoppingCart {
	
	private LinkedHashMap<Product, Integer> shoppingCartMap;
	
	public ShoppingCart() {
		this.shoppingCartMap = new LinkedHashMap<>();
	}

	public LinkedHashMap<Product, Integer> getShoppingCartMap() {
		return shoppingCartMap;
	}

	public void setShoppingCartMap(LinkedHashMap<Product, Integer> shoppingCartMap) {
		this.shoppingCartMap = shoppingCartMap;
	}



}
