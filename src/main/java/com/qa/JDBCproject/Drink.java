package com.qa.JDBCproject;

public class Drink {
	
	private int id;
	private String type;
	private String size;
	private boolean dairyfree;
	private float cost;
	
//Contraster
	public Drink(String type, String size, boolean dairyfree, float cost) {
		super();
		this.type = type;
		this.size = size;
		this.dairyfree = dairyfree;
		this.cost = cost;
	}

	public Drink(int id, String type, String size, boolean dairyfree, float cost) {
		super();
		this.id = id;
		this.type = type;
		this.size = size;
		this.dairyfree = dairyfree;
		this.cost = cost;
	}
//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isDairyfree() {
		return dairyfree;
	}

	public void setDairyfree(boolean dairyfree) {
		this.dairyfree = dairyfree;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", type=" + type + ", size=" + size + ", dairyFree=" + dairyfree + ", cost=" + cost
				+ "]";

	}


	
		
	}


	

