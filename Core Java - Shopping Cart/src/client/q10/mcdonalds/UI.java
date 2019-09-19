package client.q10.mcdonalds;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class UI {

	private String customerName;	
	private ShoppingCart shoppingCart;
	private Scanner scn;

	UI() {
		this.shoppingCart = new ShoppingCart();
	}

	/**
	 * The startUI method runs the user interface.
	 * @param data Contains the populated data.
	 */
	public void startUI(PopulateData data) {
		ArrayList<Category> categoryList = data.getCategoryList();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
		LocalDateTime now = LocalDateTime.now();
		scn = new Scanner(System.in);
		int categoryChoice, brandChoice, productChoice, quantityChoice, quantityChoiceTemp, confirmChoice, shoppingCartChoice, continueChoice;
		boolean brandFlag, productFlag, confirmPurchaseFlag;
		String brandHeader, productHeader;

		try {
			// Introduction header
			System.out.println("*****************************************");
			System.out.println("           Welcome To McDonalds          ");
			System.out.println("*****************************************");

			// Customer name input
			System.out.print("Please enter your name: ");
			this.customerName = scn.nextLine();
			System.out.println();
			System.out.println("Welcome " + this.customerName);
			System.out.println();

			// Display current date & time
			System.out.println("*****************************************|" + "Singapore GMT+8");
			System.out.println("          New Meal Promotions!           |" + "Date: " + date.format(now));
			System.out.println("*****************************************|" + "Time: " + time.format(now));

			// Select a category
			while(true) {
				// Reset while loop flags
				brandFlag = true;
				productFlag = true;
				confirmPurchaseFlag = true;
				// Display all categories 
				System.out.println("Please select a category:");
				for(int i=0; i<categoryList.size(); i++) {
					System.out.println((i+1) + ". " + categoryList.get(i).getCategory());
				}
				System.out.println(categoryList.size() + 1 + ". Exit");
				System.out.println();
				// Choose a category
				System.out.print("Choice: ");
				while(!scn.hasNextInt()) {
					System.out.println();
					System.out.println("Please enter a valid input no.");
					System.out.println();
					System.out.print("Choice: ");
					scn.next();
				}
				categoryChoice = scn.nextInt();
				System.out.println();
				// Customer enters invalid choice no.
				if(categoryChoice < 1 || categoryChoice > categoryList.size() + 1) {
					System.out.println("Please enter a valid choice no.");
					System.out.println();
					System.out.println("Would you like to continue?");
					System.out.println("1. Yes");
					System.out.println("2. No");
					System.out.println();
					System.out.print("Choice: ");
					while(!scn.hasNextInt()) {
						System.out.println();
						System.out.println("Please enter a valid input no.");
						System.out.println();
						System.out.print("Choice: ");
						scn.next();
					}
					continueChoice = scn.nextInt();
					System.out.println();
					if(continueChoice == 1) {
						continue;
					}
					else if(continueChoice == 2) {
						System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
						return;
					}
					else {
						System.out.println("Please enter a valid choice no.");
					}
				}
				// Customer exits category
				if(categoryChoice == categoryList.size() + 1) {
					// Check shopping cart
					if(shoppingCart.getShoppingCartMap().isEmpty()) {
						System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
						return;
					}
					else {
						this.displayShoppingCart(this.customerName);
						// Select an option
						System.out.println("Please select an option:");
						System.out.println("1. Pay for items in shopping cart");
						System.out.println("2. Go back to main menu");
						System.out.println("3. Exit");
						System.out.println();
						System.out.print("Choice: ");
						while(!scn.hasNextInt()) {
							System.out.println();
							System.out.println("Please enter a valid input no.");
							System.out.println();
							System.out.print("Choice: ");
							scn.next();
						}
						shoppingCartChoice = scn.nextInt();
						while(shoppingCartChoice < 1 || shoppingCartChoice > 3) {
							System.out.println();
							System.out.println("Please enter a valid choice no.");
							System.out.println();
							System.out.println("Please select an option:");
							System.out.println("1. Pay for items in shopping cart");
							System.out.println("2. Go back to main menu");
							System.out.println("3. Exit");
							System.out.println();
							System.out.print("Choice: ");
							while(!scn.hasNextInt()) {
								System.out.println();
								System.out.println("Please enter a valid input no.");
								System.out.println();
								System.out.print("Choice: ");
								scn.next();
							}
							shoppingCartChoice = scn.nextInt();
						}
						switch(shoppingCartChoice) {
						case 1:
							System.out.println();
							System.out.println("Payment made. Thank you for visiting McDonalds!");
							return;
						case 2:
							System.out.println();
							continue;
						case 3:
							System.out.println();
							System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
							return;
						}
					}
				}

				// Select a brand
				while(brandFlag) {
					// Display brand information header
					brandHeader = "Welcome to " + categoryList.get(categoryChoice - 1).getCategory() + " category";
					for(int i=0; i<brandHeader.length(); i++) {
						System.out.print("-");
					}
					System.out.println();
					System.out.println(brandHeader);
					for(int i=0; i<brandHeader.length(); i++) {
						System.out.print("-");
					}
					System.out.println();
					// Display brands in selected category
					System.out.println("Please select a category:");
					for(int i=0; i<categoryList.get(categoryChoice - 1).getBrandList().size(); i++) {
						System.out.println((i+1) 
								+ ". " 
								+ categoryList.get(categoryChoice - 1).getBrandList().get(i).getBrandName());
					}
					System.out.println(categoryList.get(categoryChoice - 1).getBrandList().size() + 1 + ". Go back to main menu");
					System.out.println(categoryList.get(categoryChoice - 1).getBrandList().size() + 2 + ". Exit");
					System.out.println();
					System.out.print("Choice: ");	
					while(!scn.hasNextInt()) {
						System.out.println();
						System.out.println("Please enter a valid input no.");
						System.out.println();
						System.out.print("Choice: ");
						scn.next();
					}
					brandChoice = scn.nextInt();
					System.out.println();
					// Customer enters invalid choice no.
					if(brandChoice < 1 || brandChoice > categoryList.get(categoryChoice - 1).getBrandList().size() + 2) {
						System.out.println("Please enter a valid choice no.");
						System.out.println();
						System.out.println("Would you like to continue?");
						System.out.println("1. Yes");
						System.out.println("2. No");
						System.out.println();
						System.out.print("Choice: ");
						while(!scn.hasNextInt()) {
							System.out.println();
							System.out.println("Please enter a valid input no.");
							System.out.println();
							System.out.print("Choice: ");
							scn.next();
						}
						continueChoice = scn.nextInt();
						System.out.println();
						if(continueChoice == 1) {
							continue;
						}
						else if(continueChoice == 2) {
							System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
							return;
						}
						else {
							System.out.println("Please enter a valid choice no.");
						}
					}
					if(brandChoice == categoryList.get(categoryChoice - 1).getBrandList().size() + 1) {
						break;
					}
					if(brandChoice == categoryList.get(categoryChoice - 1).getBrandList().size() + 2) {
						// Check shopping cart
						if(shoppingCart.getShoppingCartMap().isEmpty()) {
							System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
							return;
						}
						else {
							this.displayShoppingCart(this.customerName);
							// Select an option
							System.out.println("Please select an option:");
							System.out.println("1. Pay for items in shopping cart");
							System.out.println("2. Go back to main menu");
							System.out.println("3. Exit");
							System.out.println();
							System.out.print("Choice: ");
							while(!scn.hasNextInt()) {
								System.out.println();
								System.out.println("Please enter a valid input no.");
								System.out.println();
								System.out.print("Choice: ");
								scn.next();
							}
							shoppingCartChoice = scn.nextInt();
							while(shoppingCartChoice < 1 || shoppingCartChoice > 3) {
								System.out.println();
								System.out.println("Please enter a valid choice no.");
								System.out.println();
								System.out.println("Please select an option:");
								System.out.println("1. Pay for items in shopping cart");
								System.out.println("2. Go back to main menu");
								System.out.println("3. Exit");
								System.out.println();
								System.out.print("Choice: ");
								while(!scn.hasNextInt()) {
									System.out.println();
									System.out.println("Please enter a valid input no.");
									System.out.println();
									System.out.print("Choice: ");
									scn.next();
								}
								shoppingCartChoice = scn.nextInt();
							}
							if(shoppingCartChoice == 1) {
								System.out.println();
								System.out.println("Payment made. Thank you " + this.customerName + " for visiting McDonalds!");
								return;
							}
							else if(shoppingCartChoice == 2) {
								System.out.println();
								break;
							}
							else {
								System.out.println();
								System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
								return;
							}
						}
					}
					// Select a product
					while(productFlag) {
						// Display product information header
						productHeader = "Welcome to " 
								+ categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getBrandName() 
								+ " brand";
						for(int i=0; i<productHeader.length(); i++) {
							System.out.print("-");
						}
						System.out.println();
						System.out.println(productHeader);
						for(int i=0; i<productHeader.length(); i++) {
							System.out.print("-");
						}
						System.out.println();
						// Display product choices in selected brand
						System.out.println("Please select a product to add to cart:");
						for(int i=0; i<categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().size(); i++) {
							System.out.printf((i+1) 
									+ ". " 
									+ categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(i).getProductName()
									+ " S$"
									+ "%.2f", categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(i).getPrice());
							System.out.println();
						}
						System.out.println(categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().size() 
								+ 1 
								+ ". Go back to main menu");
						System.out.println(categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().size() 
								+ 2 
								+ ". Exit");
						System.out.println();
						// Display product choices
						System.out.print("Choice: ");
						while(!scn.hasNextInt()) {
							System.out.println();
							System.out.println("Please enter a valid input no.");
							System.out.println();
							System.out.print("Choice: ");
							scn.next();
						}
						productChoice = scn.nextInt();
						System.out.println();
						// Customer enters invalid choice no.
						if(productChoice < 1 || productChoice > categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().size() + 2) {
							System.out.println("Please enter a valid choice no.");
							System.out.println();
							System.out.println("Would you like to continue?");
							System.out.println("1. Yes");
							System.out.println("2. No");
							System.out.println();
							System.out.print("Choice: ");
							while(!scn.hasNextInt()) {
								System.out.println();
								System.out.println("Please enter a valid input no.");
								System.out.println();
								System.out.print("Choice: ");
								scn.next();
							}
							continueChoice = scn.nextInt();
							System.out.println();
							if(continueChoice == 1) {
								continue;
							}
							else if(continueChoice == 2) {
								System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
								return;
							}
							else {
								System.out.println("Please enter a valid choice no.");
							}
						}
						if(productChoice == categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().size() + 1) {
							productFlag = false;
							brandFlag = false;
							break;
						}
						else if(productChoice == categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().size() + 2) {
							// Check shopping cart
							if(shoppingCart.getShoppingCartMap().isEmpty()) {
								System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
								return;
							}
							else {
								this.displayShoppingCart(this.customerName);
								// Select an option
								System.out.println("Please select an option:");
								System.out.println("1. Pay for items in shopping cart");
								System.out.println("2. Go back to main menu");
								System.out.println("3. Exit");
								System.out.println();
								System.out.print("Choice: ");
								while(!scn.hasNextInt()) {
									System.out.println();
									System.out.println("Please enter a valid input no.");
									System.out.println();
									System.out.print("Choice: ");
									scn.next();
								}
								shoppingCartChoice = scn.nextInt();
								while(shoppingCartChoice < 1 || shoppingCartChoice > 3) {
									System.out.println();
									System.out.println("Please enter a valid choice no.");
									System.out.println();
									System.out.println("Please select an option:");
									System.out.println("1. Pay for items in shopping cart");
									System.out.println("2. Go back to main menu");
									System.out.println("3. Exit");
									System.out.println();
									System.out.print("Choice: ");
									while(!scn.hasNextInt()) {
										System.out.println();
										System.out.println("Please enter a valid input no.");
										System.out.println();
										System.out.print("Choice: ");
										scn.next();
									}
									shoppingCartChoice = scn.nextInt();
									System.out.println();
								}
								switch(shoppingCartChoice) {
								case 1:
									System.out.println();
									System.out.println("Payment made. Thank you " + this.customerName + " for visiting McDonalds!");
									return;
								case 2:
									System.out.println();
									productFlag = false;
									brandFlag = false;
									continue;
								case 3:
									System.out.println();
									System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
									return;
								}
							}
						}
						System.out.print("Quantity: ");	
						while(!scn.hasNextInt()) {
							System.out.println();
							System.out.println("Please enter a valid input no.");
							System.out.println();
							System.out.print("Quantity: ");
							scn.next();
						}
						quantityChoice = scn.nextInt();
						if(quantityChoice < 1) {
							System.out.println();
							System.out.println("Please enter a valid quantity no.");
							System.out.println();
							System.out.println("Would you like to continue?");
							System.out.println("1. Yes");
							System.out.println("2. No");
							System.out.println();
							System.out.print("Quantity: ");
							while(!scn.hasNextInt()) {
								System.out.println();
								System.out.println("Please enter a valid input no.");
								System.out.println();
								System.out.print("Choice: ");
								scn.next();
							}
							continueChoice = scn.nextInt();
							System.out.println();
							if(continueChoice == 1) {
								continue;
							}
							else if(continueChoice == 2) {
								System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
								return;
							}
							else {
								System.out.println("Please enter a valid choice no.");
							}
						}
						quantityChoiceTemp = quantityChoice;
						System.out.println();
						// Check for confirmation of item purchase
						while(confirmPurchaseFlag) {
							System.out.println("Confirm purchase?");
							System.out.println("1. Yes");
							System.out.println("2. No");
							System.out.println();
							System.out.print("Choice: ");
							while(!scn.hasNextInt()) {
								System.out.println();
								System.out.println("Please enter a valid input no.");
								System.out.println();
								System.out.print("Choice: ");
								scn.next();
							}
							confirmChoice = scn.nextInt();
							System.out.println();
							if(confirmChoice == 1) {
								// Add product to shopping cart
								// Check if product exists in shopping cart
								if(shoppingCart.getShoppingCartMap().containsKey(categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(productChoice - 1))) {
									quantityChoice += shoppingCart.getShoppingCartMap().get(categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(productChoice - 1));
									shoppingCart.getShoppingCartMap().replace(categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(productChoice - 1), quantityChoice);
								}
								shoppingCart.getShoppingCartMap().put(categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(productChoice - 1),  quantityChoice);
								System.out.println(quantityChoiceTemp + "x " + categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(productChoice - 1).getProductName() + " added to shopping cart");
								System.out.println();
								break;
							}
							else if(confirmChoice == 2){
								System.out.println("Purchase of " + categoryList.get(categoryChoice - 1).getBrandList().get(brandChoice - 1).getProductList().get(productChoice - 1).getProductName() + " is cancelled.");
								System.out.println();
								break;
							}
							else {
								System.out.println("Please enter a valid choice no.");
								System.out.println();
								System.out.println("Would you like to continue?");
								System.out.println("1. Yes");
								System.out.println("2. No");
								System.out.println();
								System.out.print("Choice: ");
								while(!scn.hasNextInt()) {
									System.out.println();
									System.out.println("Please enter a valid input no.");
									System.out.println();
									System.out.print("Choice: ");
									scn.next();
								}
								continueChoice = scn.nextInt();
								System.out.println();
								if(continueChoice == 1) {
									continue;
								}
								else if(continueChoice == 2) {
									System.out.println("Thank you " + this.customerName + " for visiting McDonalds!");
									return;
								}
								else {
									System.out.println("Please enter a valid choice no.");
								}
							}
						}
					}
				}


			}
		} catch(InputMismatchException e) {
			System.out.println(e);
			System.out.println("test");
		}
	}


	/**
	 * The displayShoppingCart method displays the shopping cart in the user interface.
	 */
	public void displayShoppingCart(String customerName) {
		Iterator<Entry<Product, Integer>> itr = shoppingCart.getShoppingCartMap().entrySet().iterator();
		int counter = 0;
		double totalPrice = 0;

		System.out.format("%4s%c %10s %75s %c%c %3s", "S/no", '.', "Quantity", "Item", ' ', ' ', "Price");
		System.out.println();
		for(int i=0; i<=125; i++) {
			System.out.print("-");
		}
		System.out.println();

		while(itr.hasNext()) {
			Map.Entry<Product, Integer> cartItem = (Entry<Product, Integer>)itr.next();
			totalPrice += (cartItem.getKey().getPrice() * cartItem.getValue());
			System.out.format("%4x%c %9d%c %75s %c%c %.2f", ++counter, '.', cartItem.getValue(), 'x', cartItem.getKey().getProductName(), 'S', '$', cartItem.getKey().getPrice());
			System.out.println();			
		}
		for(int i=0; i<=125; i++) {
			System.out.print("-");
		}
		System.out.println();
		// Display total price
		System.out.format("%4s%c %10s %75s %c%c %.2f", " ", ' ', " ", "Total", 'S', '$', totalPrice);
		System.out.println();
	}

}