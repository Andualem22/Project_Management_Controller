package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.TimeChartData;
import com.example.entities.Employee;
import com.example.entities.Project;
import com.example.services.EmployeeService;
import com.example.services.ProjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired	
	ProjectService proService;
	
	@Autowired	
	EmployeeService empService;
	
	@GetMapping
	public String displayProjectss(Model model) {
		List<Project> projects = proService.getAll();
		model.addAttribute("projects", projects);
		return "projects/list-projects";
	}
	
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		List<Employee> employees = empService.getAll();
		model.addAttribute("project", aProject);
		model.addAttribute("allEmployees", employees);
		return "projects/new-project";
	}	
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		
		proService.save(project);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects ";
		
	}
	
	@GetMapping("/update")
	public String updateProject(@RequestParam("id") long projectId, Model model) {
		Project theProject = proService.findByProjectId(projectId);
		model.addAttribute("project", theProject);
		return "projects/new-project";
	}
	
	@GetMapping("delete")
	public String deleteProject(@RequestParam("id") long projectId, Model model) {
		Project theProject = proService.findByProjectId(projectId);
		proService.delete(theProject);
		return "redirect:/projects";
	}
	@GetMapping("/timelines")
	public String displayProjectTimelines(Model model) throws JsonProcessingException {
		
		List<TimeChartData> timelineData = proService.getTimeData();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonTimelineString = objectMapper.writeValueAsString(timelineData);
		
		System.out.println("-------- project timelines ---------");
		System.out.println(jsonTimelineString);
		
		model.addAttribute("projectTimeList", jsonTimelineString);
		
		return "projects/project-timelines";
	}
	
}
