package com.test.model;

public class Innings {
	
	private int runs;
	private boolean out;
	
	public Innings(int runs, boolean out) {
		super();
		this.runs = runs;
		this.out = out;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	};

}
