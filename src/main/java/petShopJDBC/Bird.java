package petShopJDBC;

public class Bird {
	
	// Fields
	private int id;
	private String featherColour;
	private int wingspan; 
	private String name;
	
	//Contractor
	public Bird(int id, String featherColour, int wingspan, String name) {
		super();
		this.id = id;
		this.featherColour = featherColour;
		this.wingspan = wingspan;
		this.name = name;
	}

	//contractor with no id
	public Bird(String featherColour, int wingspan, String name) {
		super();
		this.featherColour = featherColour;
		this.wingspan = wingspan;
		this.name = name;
	}
	
	// Getters and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeatherColour() {
		return featherColour;
	}

	public void setFeatherColour(String featherColour) {
		this.featherColour = featherColour;
	}

	public int getWingspan() {
		return wingspan;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Bird [id=" + id + ", featherColour=" + featherColour + ", wingspan=" + wingspan + ", name=" + name
				+ "]";
	}

	public static char[] addBird(Bird bird) {
		// TODO Auto-generated method stub
		return null;
	}
}
