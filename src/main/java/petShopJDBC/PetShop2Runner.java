package petShopJDBC;



public class PetShop2Runner {
	
	// Petshop uses a db to store pets
	// Create
	// Read
	// Update
	// Delete
	// PetNoise() 
	
	private static final String Toni = null;

	public static void main(String[] args) {
		
		PetShop2 paws = new PetShop2();
		
		new Controller(paws);
		
		Controller.createBird(new Bird("Purple", 13, Toni));

		System.out.println(paws.addBird(new Bird("Green and Orange", 9, "Katie")));

		System.out.println(paws.getBirdById(1));


	}	

}