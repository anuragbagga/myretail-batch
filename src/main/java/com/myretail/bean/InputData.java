package com.myretail.bean;

public class InputData {

	private int id;
	private int quantity;
	private double cost;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public InputData(int id, int quantity, double cost) {
		super();
		this.quantity = quantity;
		this.id = id;
		this.cost = cost;
	}

	
}