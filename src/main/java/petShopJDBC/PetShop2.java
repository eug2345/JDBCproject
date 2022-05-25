package petShopJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PetShop2 {
	
	JDBCConfig db = new JDBCConfig();
	
	Statement stmt = null;
	Connection conn = db.connect();
	
	
	public Bird addBird(Bird bird) {
		try {
			String query = "INSERT INTO birds(feather_colour, wingspan, name) VALUES(?, ?, ?);";
			PreparedStatement preStmt = conn.prepareStatement(query); 
			preStmt.setString(1, bird.getFeatherColour()); 
			preStmt.setInt(2, bird.getWingspan());
			preStmt.setString(3, bird.getName());
			
			preStmt.executeUpdate(); 
			return readLatest();
		} catch (Exception e) {
			
			e.printStackTrace(); 
			return null;
		}
		
	}
	
	public Bird getBirdById(int id) {
		try {
			String query = "SELECT * FROM birds where id = ?;";
			PreparedStatement preStmt = conn.prepareStatement(query);
	
			preStmt.setInt(1, id);
			ResultSet results = preStmt.executeQuery();
			return modelBird(results); 	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteBirdById(int id) {
		try {
			String query = "DELETE FROM birds where id = ?;";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setInt(1, id);
			preStmt.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
		public Bird readLatest() {
			try{
				String query = "SELECT * FROM birds ORDER BY id BESC limit 1";
				PreparedStatement preStmt =conn.prepareStatement(query);
				ResultSet results = preStmt.executeQuery();
				return modelBird(results);
			}catch (Exception e) {
					e.printStackTrace();
					return null;
				}
		
			}
		
	
	public Bird updateBirdById(int id, Bird bird) {
		try {
			String query = "UPDATE birds set feather_colour = ?, wingspan = ?, name = ? WHERE id = ?;";
			PreparedStatement preStmt = conn.prepareStatement(query);
			preStmt.setString(1, bird.getFeatherColour());
			preStmt.setInt(2, bird.getWingspan());
			preStmt.setString(3, bird.getName());
			preStmt.setInt(4, id);
			preStmt.executeUpdate();
			return getBirdById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Bird modelBird(ResultSet result) {
		try { 
			int id = result.getInt("id"); 
			String featherColour = result.getString("feather_colour"); 
			
			int wingspan = result.getInt("wingspan");
			String name = result.getString("name");
			
			
			Bird bird = new Bird(id, featherColour, wingspan, name);
			return bird;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Object atLeast(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Bird verify(PetShop2 mockShop, Object atLeast) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}
	
	
	
	

