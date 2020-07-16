package com.edu.beans;

public class HelloBean {
	private String name;
	private String number;

	public HelloBean() {
		this.name = "no name";
		this.number = "no number";
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
