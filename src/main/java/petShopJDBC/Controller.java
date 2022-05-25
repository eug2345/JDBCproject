package petShopJDBC;

public class Controller {
	
	private PetShop2 petShop2;
	
	public Controller(PetShop2 petShop2) {
		super();
		this.petShop2 = petShop2;
		
		
	}

	public Bird createBird1(Bird bird) {
		Bird addBird = petShop2.addBird(bird);
		System.out.println(bird.getName() + "add to petShop2!");
		return addBird;
			
	}
	public Bird readBirdById(int id) {
		Bird bird = petShop2.getBirdById(id);
	
		return bird;
			
	}
public boolean deleteBird(int id) {
	boolean delete = petShop2.deleteBirdById(id);
	System.out.println("bird. of id: " + id + "has been removed: ( ");
	return delete;
	
}
public Bird updateBird(int id, Bird bird) {
	Bird uppdatedBird = petShop2.updateBirdById(id, bird);
	System.out.println(bird.getName() + "has been updated");
	return uppdatedBird;
	
}
public static Bird createBird(Bird bird1) {
	// TODO Auto-generated method stub
	return null;
}
}
