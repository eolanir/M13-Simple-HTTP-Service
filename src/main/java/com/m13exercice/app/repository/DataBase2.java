package com.m13exercice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m13exercice.app.bean.Employee;

public interface DataBase2 extends JpaRepository<Employee, Integer>{

}
