package com.m13exercice.app.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.m13exercice.app.bean.Employee;
import com.m13exercice.app.bean.Job;

public class DataBase {
	
	private Connection connection;
	
	public DataBase() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connec = "jdbc:mysql://localhost:3306/m13";
			this.connection = DriverManager.getConnection(connec, "root", "003021");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Employee employee) {
		String query = "insert into employees (id, name, lastname, job)" + " values (?, ?, ?, ?)";
		try {
			PreparedStatement preparedStmt;
			preparedStmt = connection.prepareStatement(query);
			preparedStmt.setInt(1, employee.getId());
			preparedStmt.setString(2, employee.getName());
			preparedStmt.setString(3, employee.getLastname());
			preparedStmt.setString(4, employee.getJob().toString());
			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}
	}
	
	public void delete(int id) {
		String query = "delete from employees where id=" + id;
		try {
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void edit(Employee employee) {
		String query = "update employees set name=?, lastname=?, job=?" + " where id=?";
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(query);
			preparedStmt.setString(1, employee.getName());
			preparedStmt.setString(2, employee.getLastname());
			preparedStmt.setString(3, employee.getJob().toString());
			preparedStmt.setInt(4, employee.getId());
			System.out.println(preparedStmt.toString());
			
			preparedStmt.executeUpdate();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public Employee getEmployee(int id) {
		Employee employee = null;
		
		try {
			Statement s = connection.createStatement();
			String sql = "SELECT * FROM EMPLOYEES WHERE ID="+id;
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			rs.next();
			employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), Job.valueOf(rs.getString(4)));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return employee;
	}
	
	public ArrayList<Employee> getEmployees(){
		ArrayList<Employee> list = new ArrayList<Employee>();
		try {
			Statement s = connection.createStatement();
			String sql = "SELECT * FROM EMPLOYEES";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while (rs.next()) {
				Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), Job.valueOf(rs.getString(4)));
				list.add(employee);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return list;
	}
	
	
}
