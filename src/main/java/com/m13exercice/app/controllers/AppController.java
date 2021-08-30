package com.m13exercice.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.m13exercice.app.bean.Employee;
import com.m13exercice.app.bean.Job;
import com.m13exercice.app.repository.DataBase;
import com.m13exercice.app.repository.DataBase2;
import com.m13exercice.app.repository.EmployeeRepository;
import com.m13exercice.app.service.DataBase2Service;

@Controller
@RequestMapping("")
public class AppController {
	
	//EmployeeRepository bd = new EmployeeRepository();
	//DataBase bd = new DataBase();
	@Autowired
	DataBase2Service bd;
	
	@GetMapping("/")
	public String start(Model model) {
		ArrayList<Employee> employees = bd.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("button", "Insert employee");
		model.addAttribute("action", "/insert");
		return "index";
	}
	
	@PostMapping("/insert")
	public String insert(Employee employee, Model model) {
		bd.insert(employee);
		ArrayList<Employee> employees = bd.getEmployees();
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("button", "Insert employee");
		model.addAttribute("action", "/insert");
		return "index";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		bd.delete(id);
		ArrayList<Employee> employees = bd.getEmployees();
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employees);
		model.addAttribute("button", "Insert employee");
		model.addAttribute("action", "/insert");
		return "index";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Employee employee = bd.getEmployee(id);
		ArrayList<Employee> employees = bd.getEmployees();
		model.addAttribute("employee", employee);
		model.addAttribute("employees", employees);
		model.addAttribute("button", "Edit employee");
		model.addAttribute("action", "/edit");
		return "index";
	}
	
	@PostMapping("/edit")
	public String edit2(Employee employee, Model model) {
		bd.edit(employee);
		ArrayList<Employee> employees = bd.getEmployees();
		model.addAttribute("employee", new Employee());
		model.addAttribute("employees", employees);
		model.addAttribute("button", "Insert employee");
		model.addAttribute("action", "/insert");
		return "index";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam Job job, Model model) {
		ArrayList<Employee> emp = bd.getEmployees();
		List<Employee> employees = emp.stream().filter(s -> s.getJob()==job).collect(Collectors.toList());
		model.addAttribute("employees", employees);
		model.addAttribute("employee", new Employee());
		model.addAttribute("button", "Insert employee");
		model.addAttribute("action", "/insert");
		return "index";
	}
	

}
