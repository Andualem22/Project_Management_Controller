package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entities.Employee;
import com.example.services.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired	
	EmployeeService empService;
	
	@GetMapping
	public String displayEmployees(Model model) {
		List<Employee> employees = empService.getAll();
		model.addAttribute("employees", employees);
		return "employees/list-employees";
	}
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee", anEmployee);
		
		return "employees/new-employee";
	}	
	@PostMapping("/save")
	public String createEmployee(Employee employee, Model model) {
			empService.save(employee);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/employees/new";
		
	}
}
