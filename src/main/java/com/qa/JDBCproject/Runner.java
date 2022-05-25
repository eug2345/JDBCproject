package com.qa.JDBCproject;

public class Runner {
	
public static void main(String[] args) {
	new JDBCpro();
	
	// Create our Cafe object
	Cafe newCafe = new Cafe();
	
	new Drink("latte", "grande", true, 1.50f);
	new Drink("caramel frappe", "venti", false, 4.15f);
	Drink newDrink = new Drink("vimto", "big", true, 1.71f);
	
	System.out.println(newCafe.getDrinkById(10));
	System.out.println(newCafe.getDrinkById(15));
	System.out.println("*************************************");
	System.out.println(newCafe.getAllDrinks());
	System.out.println(newCafe.getDrinksByQuery("type", "'latte'"));
	System.out.println(newCafe.updateDrinkById(newDrink, 17));
	newCafe.getDrinkById(10); // gives us a useless id reference
}

}