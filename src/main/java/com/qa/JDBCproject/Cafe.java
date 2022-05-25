package com.qa.JDBCproject;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// Serve a similar purpose to Garage, used for our methods
public class Cafe {
	
	// ArrayList<Vehicle>.. - Because our Database will be storing our data
	
	Statement stmt = null;  // import java.sql
	Connection conn = null;	// import java.sql
	
	JDBCpro db = new JDBCpro(); // making my object
	
	
	// making a method to add our drink to our database
	public void addDrink(Drink drink) {
		try {
			conn = db.connect();
			stmt = conn.createStatement(); 
			String query = "INSERT INTO drinks(type, size, dairyFree, cost) VALUES('"+ drink.getType() + "', '"+ drink.getSize() +"', " + drink.isDairyfree()+ ", "+ drink.getCost()+");";
			System.out.println(query);
			stmt.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Drink getDrinkById(int id) {
		try {
			
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks WHERE id = " + id;
			// return an object of type ResultSet - A set of data from the database
			ResultSet results = stmt.executeQuery(query); 
			results.next(); // moves the selection cursor down to the next row
//			System.out.println(results); // We need to convert to a useful object
			Drink drinkResult = modelDrink(results);
			return drinkResult;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Drink> getAllDrinks() {
		ArrayList<Drink> resultList = new ArrayList<Drink>();
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			String query = "SELECT * FROM drinks";
			ResultSet results = stmt.executeQuery(query);
			
			// While there is another row below this one, keep going
			while(results.next()) {
				// Return the current row as a Drink object, add it to this arraylist
				resultList.add(modelDrink(results));
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public <db> ArrayList<Drink> getDrinksByQuery(String queryTerm, String value){
		ArrayList<Drink> resultList = new ArrayList<Drink>();
		try {
			conn = db.connect();
			stmt = conn.createStatement();
			// SELECT * FROM drinks WHERE size = 'large'
			String query = "SELECT * FROM drinks WHERE " + queryTerm + " = " + value;
			System.out.println(query);
			ResultSet results = stmt.executeQuery(query);
			
			// While there is another row below this one, keep going
			while(results.next()) {
				// Return the current row as a Drink object, add it to this arraylist
				resultList.add(modelDrink(results));
			}
			return resultList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	// Prepared Statements: 
	// - We create a statement Object which contains a query, then run the statement
	// - Pass in ? in place of data in our queries - WHERE " + term + " =.." 
	// WHERE size = ? (change ? to be any value)
	
	public int deleteDrinkById(int id) {
		try {
			conn = db.connect();
			String query = "DELETE FROM drinks WHERE id = ?";
			PreparedStatement preStmt = conn.prepareStatement(query);
			// Set the value of ?, you can have as many ? as you want, they index from 1
			preStmt.setInt(1, id); // the first ? = id
			return preStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// drink - What we're updating with
	// id 	 - What drink we're updating
	public Drink updateDrinkById(Drink drink, int id) {
		try {
			conn = db.connect();
			String query = "UPDATE drinks SET type = ?, size = ?, dairyFree = ?, cost = ? WHERE id = ? ";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, drink.getType()); // return the type of our drink
			preStmt.setString(2, drink.getSize());
			preStmt.setBoolean(3, drink.isDairyfree());
			preStmt.setFloat(4, drink.getCost());
			preStmt.setInt(5, id);   // If you're getting data - query (Read)
			preStmt.executeUpdate(); // otherwise its an update (Create, Update, Delete)
			return getDrinkById(id); // Getting the drink we have just updated
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	// Will return a Drink from a drink resultSet
	public Drink modelDrink(ResultSet result) {
		try {
			int id = result.getInt(1); // pass in the column number (1 - 5)
			String type = result.getString("type"); // pass in the column name (type, size)
			String size = result.getString("size");
			boolean bool = result.getBoolean("dairyFree");
			float cost = result.getFloat("cost");
			
			// Make a new Drink object 
			Drink drink = new Drink(id, type, size, bool, cost);
			return drink;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	

}