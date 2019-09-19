package client.q10.mcdonalds;

import java.util.ArrayList;

public class Category {
	
	private String category;
	private ArrayList<Brand> brandList;
	
	public Category(String category, ArrayList<Brand> brandList) {
		this.setCategory(category);
		this.setBrandList(brandList);
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ArrayList<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(ArrayList<Brand> brandList) {
		this.brandList = brandList;
	}
	

}
