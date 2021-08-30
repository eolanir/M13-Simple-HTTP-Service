package com.m13exercice.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastname;
	@Column(name="job")
	@Enumerated(EnumType.STRING)
	private Job job;
	
	public Employee(int id, String name, String lastname, Job job) {
		this.id=id;
		this.name=name;
		this.lastname=lastname;
		this.job=job;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(Job job) {
		this.job=job;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getId() {
		return id;
	}
	
	
}
