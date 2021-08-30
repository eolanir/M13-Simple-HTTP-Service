package com.m13exercice.app.bean;

public enum Job {
	JUNIOR("Junior", 1500), MID("Mid", 2000), SENIOR("Senior", 2500), MANAGER("Manager", 3000);
	
	private String name;
	private int salary;
	
	private Job(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSalary() {
		return this.salary;
	}
}
