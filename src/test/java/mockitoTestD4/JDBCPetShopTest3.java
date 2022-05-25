package mockitoTestD4;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import petShopJDBC.Bird;
import petShopJDBC.JDBCConfig;
import petShopJDBC.PetShop2;


public class JDBCPetShopTest3<PetShop> {
	
	PetShop2 shop = new PetShop2();
	
	
	JDBCConfig db = new JDBCConfig();
	Connection conn = db.connect();
	
	
	Bird bird2 = new Bird("test colour 2", 2, "test name 2");
	Bird bird2ID = new Bird(2, "test colour 2", 2, "test name 2");
	Bird bird1ID = new Bird(1, "test colour", 1, "test name"); 
	
	
	
	@BeforeEach
	public void setup() {
		
		try {
			String query1 = "TRUNCATE TABLE birds;";
			String query2 = "INSERT INTO birds(feather_colour, wingspan, name) VALUES('test colour', 1, 'test name');";
			PreparedStatement preStmt1 = conn.prepareStatement(query1);
			PreparedStatement preStmt2 = conn.prepareStatement(query2);
			preStmt1.executeUpdate();
			preStmt2.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void addBirdTest() {
		Bird result;
	
		result = shop.addBird(bird2);
		
		Assertions.assertEquals(bird2ID, result);
		
	}
	
	@Test
	public void getBirdByIDTest() {
		
		Assertions.assertEquals(bird1ID, shop.getBirdById(1));
		
		Bird result;
		int id = 1;
		
		result = shop.getBirdById(id);
		
		Assertions.assertEquals(bird1ID, result);
		
	}

	
	
	
}
	


