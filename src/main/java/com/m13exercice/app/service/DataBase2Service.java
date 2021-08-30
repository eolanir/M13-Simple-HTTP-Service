package com.m13exercice.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m13exercice.app.bean.Employee;
import com.m13exercice.app.repository.DataBase2;

@Service
public class DataBase2Service implements IDataBase2 {
	
	@Autowired
	DataBase2 bd;
	
	@Override
	public void insert(Employee employee) {
		bd.save(employee);

	}

	@Override
	public void delete(int id) {
		bd.deleteById(id);

	}

	@Override
	public void edit(Employee employee) {
		bd.save(employee);

	}

	@Override
	public Employee getEmployee(int id) {
		Optional<Employee> l = bd.findById(id);
		return l.get();

	}

	@Override
	public ArrayList<Employee> getEmployees() {
		return (ArrayList<Employee>)bd.findAll();
	}

}
