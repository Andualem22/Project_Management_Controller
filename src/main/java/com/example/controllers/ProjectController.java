package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.dao.EmployeeRepository;
import com.example.dao.ProjectRepository;
import com.example.entities.Employee;
import com.example.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired	
	ProjectRepository proRepo;
	
	@Autowired	
	EmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjectss(Model model) {
		List<Project> projects = proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}	
	@PostMapping("/save")
	public String createProject(Project project, Model model) {
		
			proRepo.save(project);
			
			// use a redirect to prevent duplicate submissions
			return "redirect:/projects";
		
	}
}
