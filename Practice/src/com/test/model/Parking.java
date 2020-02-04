package com.test.model;

public class Parking {
	
	private ParkingSize size;
	private String id;
	
	public Parking(ParkingSize size, String id) {
		super();
		this.size = size;
		this.id = id;
	}
	public ParkingSize getSize() {
		return size;
	}
	public void setSize(ParkingSize size) {
		this.size = size;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	

}
