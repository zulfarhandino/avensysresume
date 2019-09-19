package client.q10.mcdonalds;

import java.util.ArrayList;

public class PopulateData {

	private ArrayList<Category> categoryList;

	PopulateData() {
		this.setCategoryList(this.populateData());
	}

	/**
	* The populateData method populates the data required for the application.
	*/
	public ArrayList<Category> populateData() {
		categoryList = new ArrayList<>();

		// Generate categories
		getCategoryList().add(new Category("Set meals", new ArrayList<Brand>()));
		getCategoryList().add(new Category("Drinks", new ArrayList<Brand>()));
		getCategoryList().add(new Category("Snacks", new ArrayList<Brand>()));

		/* SET MEALS */
		
		getCategoryList().get(0).getBrandList().add(new Brand("Value meals", new ArrayList<Product>()));
		getCategoryList().get(0).getBrandList().add(new Brand("Promotion meals", new ArrayList<Product>()));
		getCategoryList().get(0).getBrandList().add(new Brand("Standard meals", new ArrayList<Product>()));

		getCategoryList().get(0).getBrandList().get(0).getProductList().add(new Product("Happy meal", 7.50));
		getCategoryList().get(0).getBrandList().get(0).getProductList().add(new Product("Fillet-o-fish meal", 5.00));
		getCategoryList().get(0).getBrandList().get(0).getProductList().add(new Product("Double hamburger meal", 5.00));
		
		getCategoryList().get(0).getBrandList().get(1).getProductList().add(new Product("Samurai burger meal", 8.90));
		getCategoryList().get(0).getBrandList().get(1).getProductList().add(new Product("Prosperity double beef burger meal", 9.90));
		getCategoryList().get(0).getBrandList().get(1).getProductList().add(new Product("Prosperity chicken burger meal", 7.90));
		
		getCategoryList().get(0).getBrandList().get(2).getProductList().add(new Product("Big Mac meal", 6.90));
		getCategoryList().get(0).getBrandList().get(2).getProductList().add(new Product("Double McSpicy meal", 8.90));
		getCategoryList().get(0).getBrandList().get(2).getProductList().add(new Product("McSpicy meal", 7.00));

		/* Drinks */
		
		getCategoryList().get(1).getBrandList().add(new Brand("Fanta", new ArrayList<Product>()));
		getCategoryList().get(1).getBrandList().add(new Brand("Pokka", new ArrayList<Product>()));
		getCategoryList().get(1).getBrandList().add(new Brand("Coca-Cola", new ArrayList<Product>()));

		getCategoryList().get(1).getBrandList().get(0).getProductList().add(new Product("Fanta grape S", 1.90));
		getCategoryList().get(1).getBrandList().get(0).getProductList().add(new Product("Fanta grape M", 2.90));
		getCategoryList().get(1).getBrandList().get(0).getProductList().add(new Product("Fanta grape L", 3.90));
		
		getCategoryList().get(1).getBrandList().get(1).getProductList().add(new Product("Pokka Green Tea S", 1.90));
		getCategoryList().get(1).getBrandList().get(1).getProductList().add(new Product("Pokka Green Tea M", 2.90));
		getCategoryList().get(1).getBrandList().get(1).getProductList().add(new Product("Pokka Green Tea L", 3.95));
		
		getCategoryList().get(1).getBrandList().get(2).getProductList().add(new Product("Coke zero S", 1.45));
		getCategoryList().get(1).getBrandList().get(2).getProductList().add(new Product("Coke zero M", 2.15));
		getCategoryList().get(1).getBrandList().get(2).getProductList().add(new Product("Coke zero L", 3.00));

		/* SNACKS */
		
		getCategoryList().get(2).getBrandList().add(new Brand("Ice Cream", new ArrayList<Product>()));
		getCategoryList().get(2).getBrandList().add(new Brand("Pies", new ArrayList<Product>()));
		getCategoryList().get(2).getBrandList().add(new Brand("Healthy snacks", new ArrayList<Product>()));

		getCategoryList().get(2).getBrandList().get(0).getProductList().add(new Product("McFlurry", 3.00));
		getCategoryList().get(2).getBrandList().get(0).getProductList().add(new Product("Vanilla cone", 0.70));
		getCategoryList().get(2).getBrandList().get(0).getProductList().add(new Product("Chocolate sunday", 1.90));
		
		getCategoryList().get(2).getBrandList().get(1).getProductList().add(new Product("Apple pie", 1.00));
		getCategoryList().get(2).getBrandList().get(1).getProductList().add(new Product("Banana pie", 1.20));
		getCategoryList().get(2).getBrandList().get(1).getProductList().add(new Product("Taro pie", 1.20));
		
		getCategoryList().get(2).getBrandList().get(2).getProductList().add(new Product("Sliced apples", 2.50));
		getCategoryList().get(2).getBrandList().get(2).getProductList().add(new Product("Cup corn", 1.50));
		getCategoryList().get(2).getBrandList().get(2).getProductList().add(new Product("Salad w/ chicken", 5.90));

		return getCategoryList();
	}

	public ArrayList<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
	}

}
