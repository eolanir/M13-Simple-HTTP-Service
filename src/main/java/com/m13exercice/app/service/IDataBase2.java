package com.m13exercice.app.service;

import java.util.ArrayList;

import com.m13exercice.app.bean.Employee;

public interface IDataBase2 {

	public void insert(Employee employee);
	public void delete(int id);
	public void edit(Employee employee);
	public Employee getEmployee(int id);
	public ArrayList<Employee> getEmployees();
}
