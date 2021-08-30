package com.m13exercice.app.repository;

import java.util.ArrayList;

import com.m13exercice.app.bean.Employee;
import com.m13exercice.app.bean.Job;

public class EmployeeRepository {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public EmployeeRepository() {
		employees.add(new Employee(1, "Julio", "Altisent", Job.JUNIOR));
		employees.add(new Employee(2, "Albert", "Cases", Job.JUNIOR));
		employees.add(new Employee(3, "Laia", "Pascua", Job.MID));
		employees.add(new Employee(4, "Roger", "De Flor", Job.SENIOR));
		employees.add(new Employee(5, "Laura", "Casadevall", Job.MANAGER));
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	
	public void insert(Employee employee) {
		employees.add(employee);
	}
	
	public void delete(int id) {
		for(Employee i : employees) {
			if(id == i.getId()) {
				employees.remove(i);
				break;
			}
		}
	}
	
	public Employee getEmployee(int id) {
		for(Employee i : employees) {
			if(id == i.getId()) {
				return i;
			}
		}
		return null;
	}
	
	public void edit(Employee employee) {
		for(Employee i : employees) {
			if(employee.getId()==i.getId()) {
				i.setName(employee.getName());
				i.setLastname(employee.getLastname());
				i.setJob(employee.getJob());
				break;
			}
		}
	}
	
}
